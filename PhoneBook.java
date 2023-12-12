package Adhyapan;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        // Create a HashMap to store contact information (name -> phone number)
        Map<String, String> phoneBook = new HashMap<>();

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display menu and handle user input
        while (true) {
            System.out.println("Phone Book Application");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display Phone Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact(phoneBook, scanner);
                    break;
                case 2:
                    removeContact(phoneBook, scanner);
                    break;
                case 3:
                    searchContact(phoneBook, scanner);
                    break;
                case 4:
                    displayPhoneBook(phoneBook);
                    break;
                case 5:
                    System.out.println("Exiting the phone book application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Method to add a new contact to the phone book
    private static void addContact(Map<String, String> phoneBook, Scanner scanner) {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();

        // Add the contact to the phone book
        phoneBook.put(name, phoneNumber);

        System.out.println("Contact added successfully!");
    }

    // Method to remove a contact from the phone book
    private static void removeContact(Map<String, String> phoneBook, Scanner scanner) {
        System.out.print("Enter the name to remove the contact: ");
        String name = scanner.nextLine();

        // Check if the name exists in the phone book
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Contact removed successfully!");
        } else {
            System.out.println("Contact not found in the phone book.");
        }
    }

    // Method to search and display the phone number based on the name
    private static void searchContact(Map<String, String> phoneBook, Scanner scanner) {
        System.out.print("Enter the name to search for the contact: ");
        String name = scanner.nextLine();

        // Check if the name exists in the phone book
        if (phoneBook.containsKey(name)) {
            String phoneNumber = phoneBook.get(name);
            System.out.println("Phone Number for " + name + ": " + phoneNumber);
        } else {
            System.out.println("Contact not found in the phone book.");
        }
    }

    // Method to display the entire phone book
    private static void displayPhoneBook(Map<String, String> phoneBook) {
        System.out.println("Phone Book:");

        // Iterate through the phone book entries and display them
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
