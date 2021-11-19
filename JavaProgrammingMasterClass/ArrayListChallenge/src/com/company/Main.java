package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static MobilePhone mobilePhone;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mobilePhone = new MobilePhone();
        boolean keepExecuting = true;
        while (keepExecuting) {
            printMenu();
            if (scanner.hasNextInt()) {
                int selectedOption = scanner.nextInt();
                scanner.nextLine();
                switch (selectedOption) {
                    case 1:
                        keepExecuting = false;
                        break;
                    case 2:
                        printListOfContacts();
                        break;
                    case 3:
                        addNewContact();
                        break;
                    case 4:
                        updateExistingContact();
                        break;
                    case 5:
                        removeContact();
                        break;
                    case 6:
                        searchContact();
                        break;
                    case 7:
                        printMenu();
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid input");
            }
        }


    }

    private static void printMenu() {
        System.out.println("Mobile Phone");
        System.out.println("Select an option:");
        System.out.println("1. Quit");
        System.out.println("2. Print list of contacts");
        System.out.println("3. Add new contact");
        System.out.println("4. Update existing contact");
        System.out.println("5. Remove contact");
        System.out.println("6. Search contact");
        System.out.println("7. Print this menu again");
    }

    private static void printListOfContacts() {
        List<Contact> contacts = mobilePhone.getContacts();
        for (Contact contact:
                contacts) {
            System.out.println(contact.getName());
            System.out.println(contact.getPhoneNumber() + "\n");
        }
    }

    private static void addNewContact() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = new Contact(contactName, phoneNumber);
        mobilePhone.storeContact(newContact);
        System.out.println("Added new contact");
    }

    private static void updateExistingContact() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        Contact oldContact = mobilePhone.getContact(contactName);
        if (oldContact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.print("Enter new contact name: ");
            String newContactName = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            Contact newContact = new Contact(newContactName, newPhoneNumber);
            mobilePhone.modifyContact(oldContact, newContact);
            System.out.println("Added new contact");
        }
    }

    private static void removeContact() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        Contact matchingContact = mobilePhone.getContact(contactName);
        if (matchingContact == null) {
            System.out.println("Contact not found");
        } else {
            mobilePhone.removeContact(matchingContact);
            System.out.println("Removed contact");
        }
    }

    private static void searchContact() {
        System.out.print("Enter contact name" );
        String contactName = scanner.nextLine();
        Contact matchingContact = mobilePhone.getContact(contactName);
        if (matchingContact != null) {
            System.out.println(matchingContact.getName());
            System.out.println(matchingContact.getPhoneNumber());
        } else
            System.out.println("Contact not found");
    }
}
