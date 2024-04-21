package org.example.mvcProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContactView extends JPanel {
    private ContactController contactController;
    private JPanel contactsPanel = new JPanel();

    public ContactView() {
        setLayout(new BorderLayout());
    }

    public void setContactController(ContactController contactController) {
        this.contactController = contactController;
    }

    public void updateContacts(ArrayList<Contact> contacts) {
        contactsPanel.removeAll(); // Очищаємо попередні компоненти перед додаванням нових

        contactsPanel.setLayout(new BoxLayout(contactsPanel, BoxLayout.Y_AXIS)); // Встановлюємо layout на BoxLayout з вертикальною орієнтацією

        for (Contact contact : contacts) {
            JPanel contactPanel = new JPanel(); // Створюємо нову панель для кожного контакту
            contactPanel.setLayout(new BorderLayout()); // Встановлюємо layout на BorderLayout

            JLabel contactLabel = new JLabel(contact.getName() + ": " + contact.getPhone());
            JButton redoButton = new JButton("Redo");
            JButton deleteButton = new JButton("Delete");

            redoButton.addActionListener(e -> contactController.redoContact1(contact));
            deleteButton.addActionListener(e -> contactController.deleteContact1(contact));

            JPanel buttonPanel = new JPanel(); // Панель для кнопок redo та delete
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Встановлюємо layout на FlowLayout з праворучним вирівнюванням
            buttonPanel.add(redoButton);
            buttonPanel.add(deleteButton);

            contactPanel.add(contactLabel, BorderLayout.CENTER); // Додаємо мітку контакту у центр панелі
            contactPanel.add(buttonPanel, BorderLayout.EAST); // Додаємо панель з кнопками у правий край панелі

            contactsPanel.add(contactPanel); // Додаємо панель контакту до загальної панелі контактів
        }

        revalidate(); // Перерендерити панель для відображення змін
        repaint();
    }

    public void displayContactsWindow() {
        JOptionPane.showOptionDialog(null,
                contactsPanel,
                "Choose",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[] {},
                null);    }
}

