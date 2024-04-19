package org.example.mvcProject;

import javax.swing.*;
import java.util.ArrayList;

class ContactController {
    private ContactModel contactModel;
    private ContactView contactView;

    public ContactController(ContactModel contactModel, ContactView contactView) {
        this.contactModel = contactModel;
        this.contactView = contactView;
    }

    public void addContact(String name, String phone) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No words in line Name");
            return;
        }
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No number in line Phone");
            return;
        }
        if (!phone.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Phone number cannot contain letters");
            return;
        }
        Contact newContact = new Contact(name, Integer.parseInt(phone));
        contactModel.addContact(newContact);
        contactView.updateContacts(contactModel.getContacts());
    }

    public void viewContacts() {
        contactView.updateContacts(contactModel.getContacts());
        JOptionPane.showMessageDialog(null, contactView, "Contacts", JOptionPane.PLAIN_MESSAGE);
    }

    public void redoContact1(Contact contact) {
        contactModel.redoContact(contact);
        contactView.updateContacts(contactModel.getContacts());
    }

    public void deleteContact1(Contact contact) {
        contactModel.deleteContact(contact);
        contactView.updateContacts(contactModel.getContacts());
    }
    public ArrayList<Contact> getContacts(){
        return contactModel.getContacts();
    }
}
