import java.util.ArrayList;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PhoneBookClass {
    private final ArrayList<Contact> contacts = new ArrayList<Contact>();



    public void displayMenu(){
        System.out.println("1.Add Contact");
        System.out.println("2.Delete Contact");
        System.out.println("3.Display Contacts list ");
        System.out.println("4.Edit Contact Info");
        System.out.println("Select any option (1-4 )");
    }

    public void addContact(String name, String phoneNumber){
        contacts.add(new Contact(name,phoneNumber));

    }

    public void checkPhoneNumber(String phoneNumber){
        if (phoneNumber.length() > 12 || phoneNumber.length() < 6) {
            throw new IllegalArgumentException("The number is Incorrect!!! ");
        }
    }

    public Contact findContact(String name, String number){
        Contact foundContact = null;
        for (Contact contact : contacts){
            if (contact.getName() == name && contact.getPhoneNumber() == number){
                foundContact = contact;
            }
        }
        return foundContact;
    }

    public void deleteContact(String contactNameOrNumber){
        for(int contact = 0; contact < contacts.size(); contact++) {
            if (contacts.get(contact).getName().equalsIgnoreCase(contactNameOrNumber) || contacts.get(contact).getPhoneNumber().equals(contactNameOrNumber) ){
                contacts.remove(contact);
            }

        }


    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void editContact(String name,String newName,String newNumber){
         for (int contact = 0; contact < contacts.size(); contact++) {
            if (name.equals(contacts.get(contact).getName())){
                contacts.get(contact).setName(newName);
            }
        }


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