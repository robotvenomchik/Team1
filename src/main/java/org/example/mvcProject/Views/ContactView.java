package org.example.mvcProject.Views;

import org.example.mvcProject.Model.Contact;
import org.example.mvcProject.Controller.ContactController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContactView extends JFrame {
    private ContactController contactController;
    private JPanel contactsPanel = new JPanel();

    public ContactView() {
        setLayout(new BorderLayout());
    }

    public void setContactController(ContactController contactController) {
        this.contactController = contactController;
    }

    public void updateContacts(ArrayList<Contact> contacts) {
        contactsPanel.removeAll();
        contactsPanel.setLayout(new GridLayout(contacts.size(), 3));
        for (Contact contact : contacts) {
            JLabel contactLabel = new JLabel(contact.getName() + ": " + contact.getPhone());
            JButton redoButton = new JButton("Redo");
            JButton deleteButton = new JButton("Delete");

            redoButton.addActionListener(e -> contactController.redoContact(contact));
            deleteButton.addActionListener(e -> contactController.deleteContact(contact));

            contactsPanel.add(contactLabel);
            contactsPanel.add(redoButton);
            contactsPanel.add(deleteButton);
        }
        revalidate();
        repaint();
    }

    public void displayContactsWindow() {
        JOptionPane.showOptionDialog(null, contactsPanel, "Contacts", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    }

    public void redoContact(Contact contact) {
        String newName = JOptionPane.showInputDialog(null, "Enter new name for contact:", "Edit Name", JOptionPane.QUESTION_MESSAGE);
        if (newName != null) {
            contact.setName(newName);
            contactController.viewContacts();
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
