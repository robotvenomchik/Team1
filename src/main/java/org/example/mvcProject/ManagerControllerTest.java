package org.example.mvcProject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerControllerTest {

    private ContactModel contactModel;
    private ContactView contactView;
    private ContactController contactController;

    @Before
    public void setUp() {
        contactModel = new ContactModel();
        contactView = new ContactView();
        contactController = new ContactController(contactModel, contactView);
    }

    @Test
    public void testAddContactValidSize() {
        contactController.addContact("John", "123456789");
        assertEquals(4, contactModel.getContacts().size());
    }

    @Test
    public void testAddContactValidName() {
        contactController.addContact("John", "123456789");
        Contact addedContact = contactModel.getContacts().get(0);
        assertEquals("John", addedContact.getName());
    }

    @Test
    public void testAddContactValidPhone() {
        contactController.addContact("John", "123456789");
        Contact addedContact = contactModel.getContacts().get(0);
        assertEquals(123456789, addedContact.getPhone());
    }


    @Test
    public void testAddContactEmptyName() {
        contactController.addContact("", "123456789");
        assertEquals(2, contactModel.getContacts().size());
    }

    @Test
    public void testAddContactNonNumericPhone() {
        contactController.addContact("John", "abc123");
        assertEquals(1, contactModel.getContacts().size());
    }

    @Test
    public void testViewContacts() {
        contactModel.addContact(new Contact("John", 123456789));
        contactController.viewContacts();
    }
}
