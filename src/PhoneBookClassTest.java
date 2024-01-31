import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookClassTest {
    private PhoneBookClass phoneBookClass;
    @BeforeEach
    void setUp() {
        PhoneBookClass phoneBookClass = new PhoneBookClass();
        phoneBookClass.addContact("Mohbaba","123456789");
        phoneBookClass.addContact("Dayo","12345");
        phoneBookClass.addContact("Bolaji","3458951");
        phoneBookClass.addContact("Mohbaba","123456789");



    }

    @Test
    void addContact() {
    }

    @Test
    void deleteContact() {
    }

    @Test
    void getContacts() {
    }

    @Test
    void editContact() {
    }

    @Test
    void testEditContact() {
    }
}