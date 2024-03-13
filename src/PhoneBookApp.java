import java.util.Scanner;

public class PhoneBookApp {
    private static final PhoneBookClass phoneBook = new PhoneBookClass();
    private static Scanner scanner = new Scanner(System.in);

    public static int checkInput(int number){
        while (number < 1 || number > phoneBook.getContacts().size()) {
            System.out.println("Please select number between 1 and " + phoneBook.getContacts().size());
            number = scanner.nextInt();
        }
        return number;
    }
    public static void main(String[] args) {
        phoneBook.addContact(new Contact("mohbaba","123456"));
        //System.out.println("PhoneBookApp.main");
        System.out.println("PhoneBookApp.main "+phoneBook.getContacts());
          while (true) {
            phoneBook.displayMenu();
            int input = scanner.nextInt();
            if (input == 0){
                break;
            }

            switch (input) {
                case 1:

                    System.out.println("Contact Name:");
                    String name = scanner.next();

                    System.out.println("Phone Number: ");
                    String phoneNumber = scanner.next();

                    phoneBook.addContact(name,phoneNumber);

                    System.out.println();
                    break;
                case 2:
                    phoneBook.displayContactsList();
                    System.out.println("Select which number to delete:");
                    int number = scanner.nextInt();

                    number = checkInput(number);

                    System.out.println("Are you sure you want to delete " + phoneBook.getContacts().get(number - 1).getName() + "?");
                    String reply = scanner.next().toLowerCase();
                    if (reply.equals("yes")) {
                        System.out.println("Contact deleted");
                        phoneBook.deleteContact(number-1);
                        System.out.println();
                    } else {
                        break;
                    }

                case 3:
                    phoneBook.displayContactsList();
                    break;

                case 4:
                    phoneBook.displayContactsList();
                    System.out.println("Select number you want to edit");
                    int answer = scanner.nextInt();
                    answer = checkInput(answer);

                    System.out.println("Enter 1 to edit name, 2 to edit number and 3 to quit");
                    int option = scanner.nextInt();
                    while (option < 1 || option > 3){
                        System.out.println("Enter 1 to edit name, 2 to edit number and 3 to quit");
                        option = scanner.nextInt();
                    }
                    if (option==1){
                        System.out.println("Please enter new name");
                        String newName = scanner.nextLine();
                        phoneBook.editContact(answer-1,newName);
                    } else if (option == 2) {
                        System.out.println("Please enter new number");
                        String newPhoneNumber = scanner.nextLine();
                        phoneBook.editContact(newPhoneNumber,answer-1);
                    } else if (option == 3) {
                        break;
                    }
            }
        }
    }
}
