import Task2.Contact;
import Task2.ContactManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactManagerTest {
    private ContactManager contactManager;

    @BeforeEach
    public void setUp() {
        contactManager = new ContactManager();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("John Doe", "john@example.com");
        contactManager.addContact(contact);
        assertEquals(1, contactManager.getContacts().size());
    }

    @Test
    public void testEditContact() {
        Contact contact1 = new Contact("Alice", "alice@example.com");
        Contact contact2 = new Contact("Bob", "bob@example.com");
        contactManager.addContact(contact1);
        contactManager.addContact(contact2);

        Contact newContact = new Contact("Charlie", "charlie@example.com");
        contactManager.editContact(1, newContact);

        assertEquals("Charlie", contactManager.getContacts().get(1).getName());
    }

    @Test
    public void testDeleteContact() {
        Contact contact1 = new Contact("Alice", "alice@example.com");
        Contact contact2 = new Contact("Bob", "bob@example.com");
        contactManager.addContact(contact1);
        contactManager.addContact(contact2);

        contactManager.deleteContact(0);
        assertEquals(1, contactManager.getContacts().size());
        assertTrue(contactManager.getContacts().get(0).getName().equals("Bob"));
    }
}