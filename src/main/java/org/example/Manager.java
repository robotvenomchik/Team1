package org.example;

import org.example.Contact;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends JFrame {
    private JTextField nameField;
    private JTextField phoneField;
    private JButton addButton;
    private JButton viewButton;
    private ArrayList<Contact> contacts;

    public Manager() {
        contacts = readContactsFromFile();

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
            return;
        }
        if (phoneField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No number in line Phone");
            return;
        }
        if (!phoneField.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "Phone number cannot contain letters");
            return;
        }

        String name = nameField.getText();
        int phone = Integer.parseInt(phoneField.getText());
        Contact newContact = new Contact(name, phone);
        if (!contacts.contains(newContact)) {
            contacts.add(newContact);
            writeContactsToFile();
            nameField.setText("");
            phoneField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Contact already exists");
        }
    }

    private void viewContacts() {
        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new GridLayout(contacts.size(), 3));

        for (Contact contact : contacts) {
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
        if (newPhone != null && newPhone.matches("[0-9]+")) {
            int phone = Integer.parseInt(newPhone);
            contact.setPhone(phone);
            JOptionPane.showMessageDialog(null, "Contact has been edited successfully", "Edit Success", JOptionPane.INFORMATION_MESSAGE);
            writeContactsToFile();
        } else {
            JOptionPane.showMessageDialog(null, "Editing cancelled, mistake in the input", "Edit Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void redoName(Contact contact){
        String newName = JOptionPane.showInputDialog(null, "Enter new name for contact:", "Edit Name", JOptionPane.QUESTION_MESSAGE);
        if (newName != null) {
            contact.setName(newName);
            JOptionPane.showMessageDialog(null, "Contact has been edited successfully", "Edit Success", JOptionPane.INFORMATION_MESSAGE);
            writeContactsToFile();
        } else {
            JOptionPane.showMessageDialog(null, "Editing cancelled, mistake in the input", "Edit Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void back(){
        JOptionPane.getRootFrame().dispose();
        JOptionPane.getRootFrame().dispose();
        writeContactsToFile();
        viewContacts();
    }

    public void deleteContact(Contact contact){
        contacts.remove(contact);
        writeContactsToFile();
        viewContacts();
    }

    private ArrayList<Contact> readContactsFromFile() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            File file = new File("filename.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                String name = parts[0];
                int phone = Integer.parseInt(parts[1]);
                contacts.add(new Contact(name, phone));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private void writeContactsToFile() {
        try {
            FileWriter writer = new FileWriter("filename.txt");
            for (Contact contact : contacts) {
                writer.write(contact.getName() + ":" + contact.getPhone() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
