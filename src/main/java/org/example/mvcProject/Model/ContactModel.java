package org.example.mvcProject.Model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactModel implements ContactDAO {
    private ArrayList<Contact> contacts;

    public ContactModel() {
        contacts = readContactsFromFile();
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            writeContactsToFile();
        } else {
            JOptionPane.showMessageDialog(null, "Contact already exists");
        }
    }

    @Override
    public void deleteContact(Contact contact) {
        contacts.remove(contact);
        writeContactsToFile();
    }

    @Override
    public void updateContact(Contact contact) {
        // Implementation for updating contact goes here
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
