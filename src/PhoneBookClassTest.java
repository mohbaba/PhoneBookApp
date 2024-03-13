import Exceptions.EmptyPhoneBookException;
import org.junit.jupiter.api.AfterEach;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookClassTest {
    private PhoneBookClass phoneBook;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBookClass();
        phoneBook.addContact("Ola","1234567");
        phoneBook.addContact("Abike","2324432");
        phoneBook.addContact("bEEJAY","223233");
        phoneBook.addContact("Dayo","9586945");


    }

    @AfterEach
    public void tearDown(){
        phoneBook.getContacts().clear();
    }
    @Test
    public void testAddContact() {
        phoneBook.addContact("Baba","1234543");
        int numberOfContacts = 5;
        assertEquals(numberOfContacts, phoneBook.getContacts().size());
    }

    @Test
    public void deleteContact() {
        phoneBook.deleteContact("9586945");
        assertEquals(3, phoneBook.getContacts().size());

        phoneBook.deleteContact("bEEJAY");
        assertEquals(2, phoneBook.getContacts().size());

    }

    @Test
    public void testGetContacts() {
        assertEquals(4, phoneBook.getContacts().size());
    }

    @Test
    public void testFindContactThatExists() {
        assertNotNull(phoneBook.findContact("Abike"));
        assertNotNull(phoneBook.findContact("223233"));
    }

    @Test
    public void testFindContactThatDoesNotExist() {
        assertNull(phoneBook.findContact("fake"));
    }


    @Test
    public void testDeleteContact_ThatDoesNotExists() {
        assertThrows(EmptyPhoneBookException.class, () -> phoneBook.deleteContact("Nonexistent"));
    }

    @Test
    public void testEditContactName() {
        phoneBook.editContactName("Dayo", "OmoAkin");
        assertEquals("OmoAkin", phoneBook.findContact("OmoAkin").getName());
    }

    @Test
    public void testEditContactNumber() {
        phoneBook.editContactNumber("9876543210", "Abike");
        assertEquals("9876543210", phoneBook.findContact("Abike").getPhoneNumber());
    }

    @Test
    public void testIsPhoneBookEmpty() {
        assertFalse(phoneBook.isPhoneBookEmpty());
    }
}