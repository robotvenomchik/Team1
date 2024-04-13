package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Manager extends JFrame {
    private JTextField nameField;
    private JTextField phoneField;
    private JButton addButton;
    private JButton viewButton;
    private JList<String> contactList;

    private ArrayList<Contact> contacts;

    public Manager() {
        contacts = new ArrayList<>();

        setTitle("Contact Manager");
        setSize(500, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        viewButton = new JButton("View Contacts");
        viewButton.addActionListener(e -> viewContacts());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addContact() {
        if(nameField.getText().isEmpty() || phoneField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "no words in lines");
        }
        else{
            String name = nameField.getText();
            String phone = phoneField.getText();
            Contact contact = new Contact(name, phone);
            contacts.add(contact);
            nameField.setText("");
            phoneField.setText("");
        }

    }
    private void viewContacts() {

    }

}
