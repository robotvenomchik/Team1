package org.example.mvcProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ContactView extends JPanel {
    private ContactController contactController;

    public ContactView(ContactController contactController) {
        this.contactController = contactController;

        setLayout(new BorderLayout());
        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new GridLayout(contactController.getContacts().size(), 3));

        for (Contact contact : contactController.getContacts()) {
            JLabel contactLabel = new JLabel(contact.getName() + ": " + contact.getPhone());
            JButton redoButton = new JButton("Redo");
            JButton deleteButton = new JButton("Delete");

            redoButton.addActionListener(e -> contactController.redoContact1(contact));
            deleteButton.addActionListener(e -> contactController.deleteContact1(contact));

            contactsPanel.add(contactLabel);
            contactsPanel.add(redoButton);
            contactsPanel.add(deleteButton);
        }

        JOptionPane.showMessageDialog(null, contactsPanel, "Contacts", JOptionPane.PLAIN_MESSAGE);
    }

    public void updateContacts(ArrayList<Contact> contacts) {
        setLayout(new BorderLayout());
        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new GridLayout(contactController.getContacts().size(), 3));

        for (Contact contact : contactController.getContacts()) {
            JLabel contactLabel = new JLabel(contact.getName() + ": " + contact.getPhone());
            JButton redoButton = new JButton("Redo");
            JButton deleteButton = new JButton("Delete");

            redoButton.addActionListener(e -> contactController.redoContact1(contact));
            deleteButton.addActionListener(e -> contactController.deleteContact1(contact));

            contactsPanel.add(contactLabel);
            contactsPanel.add(redoButton);
            contactsPanel.add(deleteButton);
        }

        JOptionPane.showMessageDialog(null, contactsPanel, "Contacts", JOptionPane.PLAIN_MESSAGE);
    }
}
