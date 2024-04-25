package org.example.mvcProject;

import java.util.ArrayList;

public class ContactController {
    private ContactDAO contactDAO;
    private ContactView contactView;

    public ContactController(ContactDAO contactDAO, ContactView contactView) {
        this.contactDAO = contactDAO;
        this.contactView = contactView;
        contactView.setContactController(this);
    }

    public void addContact(String name, String phone) {
        // Validate input
        if (name.isEmpty()) {
            contactView.showMessage("No name provided!");
            return;
        }
        if (phone.isEmpty() || !phone.matches("\\d+")) {
            contactView.showMessage("Invalid phone number!");
            return;
        }

        // Add contact
        Contact newContact = new Contact(name, Integer.parseInt(phone));
        contactDAO.addContact(newContact);
        contactView.updateContacts(contactDAO.getAllContacts());
    }

    public void viewContacts() {
        contactView.updateContacts(contactDAO.getAllContacts());
        contactView.displayContactsWindow();
    }

    public void redoContact(Contact contact) {
        contactView.redoContact(contact);
    }

    public void deleteContact(Contact contact) {
        contactDAO.deleteContact(contact);
        contactView.updateContacts(contactDAO.getAllContacts());
    }
}
