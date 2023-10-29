package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1 - Add Contact");
            System.out.println("2 - Edit Contact");
            System.out.println("3 - Delete Contact");
            System.out.println("4 - List Contacts");
            System.out.println("0 - Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(new Contact(name, email));
                    break;
                case 2:
                    System.out.print("Enter index of the contact to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    contactManager.editContact(editIndex, new Contact(newName, newEmail));
                    break;
                case 3:
                    System.out.print("Enter index of the contact to delete: ");
                    int deleteIndex = scanner.nextInt();
                    contactManager.deleteContact(deleteIndex);
                    break;
                case 4:
                    List<Contact> contactList = contactManager.getContacts();
                    for (int i = 0; i < contactList.size(); i++) {
                        Contact contact = contactList.get(i);
                        System.out.println("Contact " + i + ": Name - " + contact.getName() + ", Email - " + contact.getEmail());
                    }
                    break;
                case 0:
                    System.out.println("Exiting Contact Manager.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}