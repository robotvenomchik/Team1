/*package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerTest {
    public ManagerTest() {
    }

    @Before
    public void setUp() throws Exception {
        new Contact("Kseniia", 9847563);
    }

    @Test
    public void addcontact_name1() {
        Contact Contact = new Contact("Babayka", 9847563);
        assertEquals("Babayka", Contact.getName());
    }

    @Test
    public void addcontact_phone1() {
        Contact Contact = new Contact("Babayka", 9847563);
        assertEquals(9847563L, (long)Contact.getPhone());
    }
}

    @Test
    public void testAddContactValid() {
        Manager manager = new Manager();
        manager.getNameField().setText("John");
        manager.getPhoneField().setText("123456789");
        manager.addContact();
        assertEquals(1, manager.contacts.size());
        Contact addedContact = manager.contacts.get(0);
        assertEquals("John", addedContact.getName());
        assertEquals(123456789, addedContact.getPhone());
    }


    @Test
    public void testAddContactEmptyName() {
        Manager manager = new Manager();
        manager.getNameField().setText("");
        manager.getPhoneField().setText("123456789");
        manager.addContact();
        assertEquals(0, manager.contacts.size());
        // Verify that error message is displayed
        assertTrue(manager.getComponents()[0] instanceof JOptionPane);
        JOptionPane optionPane = (JOptionPane) manager.getComponents()[0];
        assertEquals("No words in line Name", optionPane.getMessage());
    }


    @Test
    public void testAddContactNonNumericPhone() {
        Manager manager = new Manager();
        manager.nameField.setText("John");
        manager.phoneField.setText("abc123");
        manager.addContact();
        assertEquals(0, manager.contacts.size());
        // Verify that error message is displayed
        assertTrue(manager.getComponents()[0] instanceof JOptionPane);
        JOptionPane optionPane = (JOptionPane) manager.getComponents()[0];
        assertEquals("Phone number cannot contain letters", optionPane.getMessage());
    }


    @Test
    public void testViewContacts() {
        Manager manager = new Manager();
        manager.contacts.add(new Contact("John", 123456789));
        manager.viewContacts();
        // Verify that a JOptionPane is displayed with contact details
        assertTrue(manager.getComponents()[0] instanceof JOptionPane);
        JOptionPane optionPane = (JOptionPane) manager.getComponents()[0];
        assertTrue(optionPane.getMessage() instanceof JPanel);
        JPanel contactsPanel = (JPanel) optionPane.getMessage();
        // Verify that the contacts panel contains the expected components
        assertEquals(3, contactsPanel.getComponentCount());
        assertTrue(contactsPanel.getComponent(0) instanceof JLabel);
        assertTrue(contactsPanel.getComponent(1) instanceof JButton);
        assertTrue(contactsPanel.getComponent(2) instanceof JButton);
    }

 */