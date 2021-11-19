package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewContactDialogController {
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField notesTextField;

    public Contact getNewContact() {
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();
        String notes = notesTextField.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || notes.isEmpty()) {
            return null;
        }
        return new Contact(firstName, lastName, phoneNumber, notes);
    }

    public void editContact(Contact contact) {
        firstNameTextField.setText(contact.getFirstName());
        lastNameTextField.setText(contact.getLastName());
        phoneNumberTextField.setText(contact.getPhoneNumber());
        notesTextField.setText(contact.getNotes());
    }

    public void updateContact(Contact contact) {
        contact.setFirstName(firstNameTextField.getText());
        contact.setLastName(lastNameTextField.getText());
        contact.setPhoneNumber(phoneNumberTextField.getText());
        contact.setNotes(notesTextField.getText());
    }
}
