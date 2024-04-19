package org.example.mvcProject;

import org.example.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Manager extends JFrame {
    private ContactModel contactModel;
    private ContactView contactView;
    private ContactController contactController;


    public Manager() {
        contactModel = new ContactModel();
        contactController = new ContactController(contactModel, contactView);
        contactView = new ContactView(contactController);


        setTitle("Contact Manager");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 25));
        JTextField phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);

        JButton addButton = new JButton("Add Contact");
        addButton.setFont(new Font("Arial", Font.PLAIN, 15));
        addButton.addActionListener(e -> contactController.addContact(nameField.getText(), phoneField.getText()));

        JButton viewButton = new JButton("View Contacts");
        viewButton.setFont(new Font("Arial", Font.PLAIN, 15));
        viewButton.addActionListener(e -> contactController.viewContacts());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Manager::new);
    }
}
