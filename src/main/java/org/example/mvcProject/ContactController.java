package org.example.mvcProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ContactController {
    private ContactModel contactModel;
    private ContactView contactView;

    public ContactController(ContactModel contactModel, ContactView contactView) {
        this.contactModel = contactModel;
        this.contactView = contactView;
        contactView.setContactController(this);
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

    }

    public void viewContacts() {
        contactView.updateContacts(contactModel.getContacts()); // Оновлення відображення контактів
        contactView.displayContactsWindow(); // Відображення вікна з контактами
    }

    public void redoContact1(Contact contact) {
        contactModel.redoContact(contact);
        contactView.updateContacts(contactModel.getContacts()); // Оновлення відображення після переробки контакту
        contactView.displayContactsWindow(); // Перевідображення вікна з контактами
    }

    public void deleteContact1(Contact contact) {
        Window[] windows = Window.getWindows();
        if (windows.length > 0) {
            windows[windows.length - 1].dispose();
        }

        // Delete the contact and update the view
        contactModel.deleteContact(contact);
        contactView.updateContacts(contactModel.getContacts());
        contactView.displayContactsWindow();
    }
    public ArrayList<Contact> getContacts(){
        return contactModel.getContacts();
    }
}
