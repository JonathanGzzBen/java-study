package com.company;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private List<Contact> contactList;

    public MobilePhone(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public MobilePhone() {
        this.contactList = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return contactList;
    }

    public void storeContact(Contact contact) {
        int indexOfContact = contactList.indexOf(contact);
        if (indexOfContact >= 0) {
            contactList.set(indexOfContact, contact);
        }
        else
            contactList.add(contact);
    }

    public boolean modifyContact(Contact oldContact, Contact contact) {
        int indexOfContact = contactList.indexOf(oldContact);
        if (indexOfContact >= 0) {
            contactList.set(indexOfContact, contact);
            return true;
        }
        return false;
    }

    public Contact getContact(String name) {
        for (Contact contact:
                contactList) {
            if (contact.getName().equals(name))
                return contact;
        }
        return null;
    }

    public boolean removeContact(Contact contact) {
        return contactList.remove(contact);
    }
}
