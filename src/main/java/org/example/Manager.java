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
        nameField.setFont(new Font("Arial", Font.PLAIN, 25));
        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);

        addButton = new JButton("Add Contact");
        addButton.setFont(new Font("Arial", Font.PLAIN, 15));
        addButton.addActionListener(e -> addContact());

        viewButton = new JButton("View Contacts");
        viewButton.setFont(new Font("Arial", Font.PLAIN, 15));
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
        if (nameField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No words in line Name");
        }
        else if (phoneField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No number in line Phone");
        }
        else if (!phoneField.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "Phone number cannot contain letters");
        }
        else{
            String name = nameField.getText();
            int phone = Integer.parseInt(phoneField.getText());
            Contact contact = new Contact(name, phone);
            contacts.add(contact);
            nameField.setText("");
            phoneField.setText("");
        }
    }
    private void viewContacts() {
        JButton[] buttons = new JButton[contacts.size()];

        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new GridLayout(contacts.size(), 3));

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            JLabel contactLabel = new JLabel(contact.getName() + ": " + contact.getPhone());
            JButton redoButton = new JButton("Redo");
            JButton deleteButton = new JButton("Delete");

            redoButton.addActionListener(e -> redoContact(contact));
            deleteButton.addActionListener(e -> deleteContact(contact));

            contactsPanel.add(contactLabel);
            contactsPanel.add(redoButton);
            contactsPanel.add(deleteButton);
        }

        JOptionPane.showMessageDialog(null, contactsPanel, "Contacts", JOptionPane.PLAIN_MESSAGE);
    }
    private void redoContact(Contact contact) {

        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new GridLayout(contacts.size(), 3));
        JButton numberButton=new JButton("Number");
        numberButton.addActionListener(e->redoNumber(contact));
        JButton nameButton=new JButton("Name");
        nameButton.addActionListener(e->redoName(contact));
        JButton backButton=new JButton("Back");
        backButton.addActionListener(e->back());

        contactsPanel.add(numberButton);
        contactsPanel.add(nameButton);
        contactsPanel.add(backButton);
        JOptionPane.showOptionDialog(null,
                contactsPanel,
                "Choose",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[] {},
                null);

    }

    private void redoNumber(Contact contact){
        String newPhone = JOptionPane.showInputDialog(null, "Enter new phone number for contact:", "Edit Phone", JOptionPane.QUESTION_MESSAGE);
        int phone = Integer.parseInt(newPhone);

        if (newPhone != null && newPhone.matches("[0-9]+")) {
            contact.setPhone(phone);
            JOptionPane.showMessageDialog(null, "Contact has been edited successfully", "Edit Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Editing cancelled, mistake in the input", "Edit Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void redoName(Contact contact){
        String newName = JOptionPane.showInputDialog(null, "Enter new name for contact:", "Edit Name", JOptionPane.QUESTION_MESSAGE);
        if (newName != null) {
            contact.setName(newName);
            JOptionPane.showMessageDialog(null, "Contact has been edited successfully", "Edit Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Editing cancelled, mistake in the input", "Edit Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void back(){
        JOptionPane.getRootFrame().dispose();
        JOptionPane.getRootFrame().dispose();
        refreshContacts();
    }
    public void deleteContact(Contact contact){
        contacts.remove(contact);
        JOptionPane.getRootFrame().dispose();
        viewContacts();
    }
    private void refreshContacts(){
        JButton[] buttons = new JButton[contacts.size()];

        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new GridLayout(contacts.size(), 3));

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            JLabel contactLabel = new JLabel(contact.getName() + ": " + contact.getPhone());
            JButton redoButton = new JButton("Redo");
            JButton deleteButton = new JButton("Delete");

            redoButton.addActionListener(e -> redoContact(contact));
            deleteButton.addActionListener(e -> deleteContact(contact));

            contactsPanel.add(contactLabel);
            contactsPanel.add(redoButton);
            contactsPanel.add(deleteButton);
        }

        JOptionPane.showMessageDialog(null, contactsPanel, "Contacts", JOptionPane.PLAIN_MESSAGE);
    }

}
