package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView<Contact> contactTableView;
    @FXML
    private ObservableList<Contact> contacts;
    @FXML
    private BorderPane borderPane;

    public void initialize() {
//        initializeColumns();

        ContactData.getInstance().loadContacts();
        contacts = ContactData.getInstance().getContacts();

        contactTableView.setItems(contacts);

    }

    public void handleNewContact() {
        Dialog<ButtonType>dialog = new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Create new Contact");
        dialog.setHeaderText("Use this dialog to add a new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newContactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            NewContactDialogController newContactDialogController = fxmlLoader.getController();
            Contact newContact = newContactDialogController.getNewContact();
            if (newContact != null) {
                ContactData.getInstance().addContact(newContact);
                ContactData.getInstance().saveContacts();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Property missing");
                alert.setHeaderText("A field is missing");
                alert.setContentText("All fields are required.");
                alert.showAndWait();
            }
        }
    }

    private void initializeColumns() {
        TableColumn firstNameColumn = new TableColumn("First Name");
        TableColumn lastNameColumn = new TableColumn("Last Name");
        TableColumn phoneNumberColumn = new TableColumn("Phone Number");
        TableColumn notesColumn = new TableColumn("Notes");

        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("firstName")
        );
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("lastName")
        );
        phoneNumberColumn.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("phoneNumber")
        );
        notesColumn.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("notes")
        );

        firstNameColumn.prefWidthProperty().bind(contactTableView.widthProperty().divide(4));
        lastNameColumn.prefWidthProperty().bind(contactTableView.widthProperty().divide(4));
        phoneNumberColumn.prefWidthProperty().bind(contactTableView.widthProperty().divide(4));
        notesColumn.prefWidthProperty().bind(contactTableView.widthProperty().divide(4));

        contactTableView.getColumns().setAll(firstNameColumn, lastNameColumn, phoneNumberColumn, notesColumn);
    }

    @FXML
    public void showEditContactDialog() {
        Contact selectedContact = contactTableView.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newContactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        NewContactDialogController contactDialogController = loader.getController();
        contactDialogController.editContact(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            contactDialogController.updateContact(selectedContact);
            ContactData.getInstance().saveContacts();
        }
    }

    @FXML
    public void deleteContact() {
        Contact selectedContact = contactTableView.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to delete");
            alert.showAndWait();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected contact: " +
                selectedContact.getFirstName() + " " + selectedContact.getLastName());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(selectedContact);
            ContactData.getInstance().saveContacts();
        }
    }
}
