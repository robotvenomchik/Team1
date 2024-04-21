package org.example.mvcProject;

import javax.swing.*;
import java.awt.*;

public class ManagerView extends JFrame {
    private ContactModel contactModel;
    private ContactView contactView;
    private ContactController contactController;


    public ManagerView() {
        contactModel = new ContactModel();
        contactView = new ContactView();
        contactController = new ContactController(contactModel, contactView);


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
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            contactController.addContact(name, phone);
            nameField.setText("");
            phoneField.setText("");});

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
        SwingUtilities.invokeLater(ManagerView::new);
    }
}
