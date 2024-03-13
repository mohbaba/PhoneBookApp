import java.util.Scanner;

public class PhoneBookApp {
    private static final PhoneBookClass phoneBook = new PhoneBookClass();


    public static int checkInput(int number){
        while (number < 1 || number > phoneBook.getContacts().size()) {
            System.out.println("Please select number between 1 and " + phoneBook.getContacts().size());
            number = scanner.nextInt();
        }
        return number;
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static String input(String prompt){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void mainMenu(){
        System.out.println("1.Add Contact");
        System.out.println("2.Delete Contact");
        System.out.println("3.Display Contacts list ");
        System.out.println("4.Edit Contact Name");
        System.out.println("5.Edit Contact Number");
        System.out.println("6.Exit");
        String userInput = input("Select any option (1-4 )");
        switch (userInput.charAt(0)){
            case '1':
                addContact();
                break;
            case '2':
                deleteContact();
                break;
            case '3':
                displayContacts();
                break;
            case '4':
                editContactName();
                break;
            case '5':
                editContactNumber();
                break;
            case '6':
                print("Thank you for using this app we hope to see you next time");
                System.exit(0);
            default:
                print("Enter valid input between 1-6");
                mainMenu();
        }

    }

    private static void editContactNumber(){
        try {
            String name = input("Enter the phone number of the contact you'd like to edit: ");
            String newNumber = input("Enter the new number of the contact: ");
            phoneBook.editContactNumber(name,newNumber);
            print("***************************");
            print("Contact Updated Successfully");
            print("***************************");
        }catch (Exception e){
            print(e.getMessage());
        }finally {
            mainMenu();
        }
    }

    private static void editContactName() {
        try{
            String name = input("Enter the phone number of the contact you'd like to edit: ");
            String newName = input("Enter the new name of the contact: ");
            phoneBook.editContactName(name,newName);
            print("***************************");
            print("Contact Updated Successfully");
            print("***************************");
        }catch (Exception e){
            print(e.getMessage());
        }finally {
            mainMenu();
        }
    }

    private static void displayContacts() {
        try{
            if (phoneBook.isPhoneBookEmpty())print("Phonebook is currently empty");
            else phoneBook.displayContactsList();
        }catch (Exception ignore){

        }finally {
            mainMenu();
        }
    }

    public static void addContact(){
        try{
            String name = input("Enter name of contact: ");
            String number = input("Enter number of contact: ");
            phoneBook.addContact(name,number);
            print("***************************");
            print("Contact Added Successfully");
            print("***************************");
        }catch (Exception ignore){

        }finally {
            mainMenu();
        }
    }

    public static void deleteContact(){
        try {
            String contactDetails = input("Enter the number of contact you'd like to delete");
            phoneBook.deleteContact(contactDetails);
            print("***************************");
            print("Contact Deleted Successfully");
            print("***************************");
        }catch (Exception e){
            print(e.getMessage());
        }finally {
            mainMenu();
        }
    }
    public static void main(String[] args) {
        mainMenu();

    }
}
