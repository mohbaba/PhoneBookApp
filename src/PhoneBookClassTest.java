import org.junit.jupiter.api.AfterEach;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookClassTest {
    private PhoneBookClass phoneBookClass;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        phoneBookClass = new PhoneBookClass();
        phoneBookClass.addContact("Fola","1234567");
        phoneBookClass.addContact("Abike","2324432");
        phoneBookClass.addContact("bEEJAY","223233");
        phoneBookClass.addContact("Dayo","9586945");


    }

    @AfterEach
    public void tearDown(){
        phoneBookClass.getContacts().clear();
    }
    @Test
    public void testAddContact() {
        phoneBookClass.addContact("tola","1234543");
        assertEquals(phoneBookClass.getContacts().getLast(),contact);
        int numberOfContacts = 5;
        assertEquals(numberOfContacts, phoneBookClass.getContacts().size());
    }

    @Test
    public void deleteContact() {
        phoneBookClass.deleteContact("9586945");
        assertEquals(3,phoneBookClass.getContacts().size());

        phoneBookClass.deleteContact("beejay");
        assertEquals(2,phoneBookClass.getContacts().size());

    }

    @Test
    public void testGetContacts() {
        assertEquals(4,phoneBookClass.getContacts().size());
    }

    @Test
    void editContact() {
    }

    @Test
    void testEditContact() {
    }

    @Test
    void testCheckPhoneNumber() {

    }
}