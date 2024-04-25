// ContactDAO.java
package org.example.mvcProject;

import java.util.ArrayList;

public interface ContactDAO {
    ArrayList<Contact> getAllContacts();
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    void updateContact(Contact contact);
}
