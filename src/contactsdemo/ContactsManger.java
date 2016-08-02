/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsdemo;

import java.util.Scanner;
/**
 *
 * @author Mohamed Abderlezek
 */
public class ContactsManger{ 

    private static MobilePhone phone = new MobilePhone();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startPhone();
        boolean flag = true;
        printActions();
        while (flag) {
            System.out.print("Enter action  -  (7) to show actions  : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    shutdown();
                    flag = false;
                    break;
                            
                case 1:
                    printContacts();

                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    upadteContact();

                    break;
                case 4:
                    removeContact();

                    break;
                case 5:
                    queryContact();

                    break;
                case 6:
                     removeAllContact();
                    break;
                    case 7:
                 
                    printActions();
                    break;
                default:
                    System.out.println("invalid  input ...... Try again or press 0 to shutdown ");
                    break;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Phone Starting    ........................ ");
    }

    private static void printActions() {
        System.out.println("Available actions  .  .. . . !   \nChoose ");
        System.out.println("0 -to shutdown \n1 "
                + "-to print contacts\n2"
                + " -to add a new contact\n3 "
                + "-to update an existing"
                + " contact\n4 -to remove"
                + " an existing contact\n5 "
                + "-Query if an existing contact i"
                + "s exists\n6 -to remove all contact\n7 -to print a list of avai"
                + "lable actions\n");
    }

    private static void shutdown() {
        System.out.println("shutdown ....... !");
    }

    private static void addNewContact() {
        System.out.print("Enter name : ");
        String name = scanner.next();
        System.out.print("Enter number : ");
        String number = scanner.next();
        Contact contact = Contact.CreateContact(name, number);
        phone.addNewContact(contact);
    }

    private static void upadteContact() {
        System.out.print("Enter Contact number you wana update :  ");
        String name = scanner.next();
        Contact existingContactRecord = phone.QureyContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found  !");
            return;
        }
        System.out.print("Enter new  name : ");
        String C_name = scanner.next();
        System.out.println("Enter new  number : ");
        String C_number = scanner.next();
        Contact newContact = Contact.CreateContact(C_name, C_number);
        phone.upadteContact(existingContactRecord, newContact);

    }

    private static void printContacts() {
        phone.showContacts();
    }

    private static void removeContact() {
        System.out.print("Enter Contact number you wana Remove :  ");
        String name = scanner.next();
        Contact existingContactRecord = phone.QureyContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found  !");
            return;
        }
        phone.removeContact(existingContactRecord);
        System.out.println(existingContactRecord.getName() + " was deleted !");

    }

    private static void queryContact() {
        System.out.print("Enter Contact number you wana Query :  ");
        String name = scanner.next();
        Contact existingContactRecord = phone.QureyContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found  !");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + "\nPhone Number: " + existingContactRecord.getNumber());
    }

    private static void removeAllContact() {
     if( phone.removeAllContact())
     {
     
         System.out.println("All contacts was removed \n ");
     }
     else
            System.out.println("ther is no contact to remove !");
    }
}
