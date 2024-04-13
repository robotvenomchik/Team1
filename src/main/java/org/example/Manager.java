package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Manager extends JFrame {
    private JTextField nameField;
    private JTextField phoneField;
    private JButton addButton;
    private JList<String> contactList;

    private ArrayList<Contact> contacts;

    public Manager() {
        contacts = new ArrayList<>();

        setTitle("Contact Manager");
        setSize(500, 350);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        nameField = new JTextField();
        phoneField = new JTextField();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);

        addButton = new JButton("Add Contact");
        addButton.addActionListener(e -> addContact());


        add(inputPanel, BorderLayout.NORTH);
        add(addButton, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        Contact contact = new Contact(name, phone);
        contacts.add(contact);
        nameField.setText("");
        phoneField.setText("");
    }

    private class Contact {
        private String name;
        private String phone;

        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return name + ": " + phone;
        }
    }
}
