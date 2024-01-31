import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PhoneBookClass {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ArrayList<String> names;
    private ArrayList<String> phoneNumbers;



    public void displayMenu(){
        System.out.println("1.Add Contact");
        System.out.println("2.Delete Contact");
        System.out.println("3.Display Contacts list ");
        System.out.println("4.Edit Contact Info");
        System.out.println("Select any option (1-4 )");
    }

    public void addContact(String name, String phoneNumber){
        contacts.add(new Contact(name,phoneNumber));
        displayContactsList();
    }

    public void deleteContact(int number){
        if (number <  1 || number > contacts.size()) {
            throw new ArrayIndexOutOfBoundsException(number+" doesn't exist in phonebook");
        }
        contacts.remove(number);

    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void editContact(int number,String name){
        contacts.get(number).setName(name);
    }

    public void editContact(String phoneNumber,int number){
        contacts.get(number).setPhoneNumber(phoneNumber);
    }

    public  void displayContactsList(){
        System.out.printf("S/N%10s%10s%n","Names","Numbers");
        for (int contact = 0; contact < contacts.size() ; contact++) {
            System.out.printf("%d%10s%11s%n",contact+1, contacts.get(contact).getName(), contacts.get(contact).getPhoneNumber());
        }
    }
}