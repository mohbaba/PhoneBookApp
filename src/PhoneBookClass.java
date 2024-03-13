import Exceptions.EmptyPhoneBookException;

import java.util.ArrayList;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PhoneBookClass {
    private final ArrayList<Contact> contacts = new ArrayList<Contact>();





    public void addContact(String name, String phoneNumber){
        contacts.add(new Contact(name,phoneNumber));

    }

    public void checkPhoneNumber(String phoneNumber){
        if (phoneNumber.length() > 12 || phoneNumber.length() < 6) {
            throw new IllegalArgumentException("The number is Incorrect!!! ");
        }
    }

    public Contact findContact(String nameOrNumber){
        Contact foundContact = null;
        for (Contact contact : contacts){
            if (contact.getName().equals(nameOrNumber) || contact.getPhoneNumber().equals(nameOrNumber)){
                foundContact = contact;
            }
        }
        return foundContact;
    }

    private void phonebookCheck(){
        if (isPhoneBookEmpty())throw new EmptyPhoneBookException("There are no contacts in the " +
                "phonebook");
    }

    public void deleteContact(String contactNameOrNumber){
        phonebookCheck();
        Contact contact = findContact(contactNameOrNumber);
        contacts.remove(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void editContactName(String nameOrNumber,String newName){
        phonebookCheck();
         Contact contact = findContact(nameOrNumber);
         contact.setName(newName);
    }

    public void editContactNumber(String phoneNumber,String nameOrNumber){
        phonebookCheck();
        Contact contact = findContact(nameOrNumber);
        contact.setPhoneNumber(phoneNumber);

    }

    public boolean isPhoneBookEmpty(){
        return contacts.isEmpty();
    }
    public  void displayContactsList(){
        System.out.printf("S/N%10s%10s%n","Names","Numbers");
        for (int contact = 0; contact < contacts.size() ; contact++) {
            System.out.printf("%d%10s%11s%n",contact+1, contacts.get(contact).getName(), contacts.get(contact).getPhoneNumber());
        }
    }
}