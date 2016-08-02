/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsdemo;

import java.util.ArrayList;

/**
 *
 * @author Mohamed Abderlezek
 */
public class MobilePhone {


    ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact newConact) {
        if (findContact(newConact.getName()) != -1) {

            System.out.println("Contact already exist !");
            return false;
        }

        myContacts.add(newConact);
        System.out.println(newConact.getName() + "  was added !");
        return true;

    }

    public boolean upadteContact(Contact oldContact, Contact newContact) {
        int foundposition = findContact(oldContact);
        if (foundposition < 0) {
            System.out.println(oldContact.getName() + "Contact not exist ! ");
            return false;
        }

        this.myContacts.set(foundposition, newContact);
        System.out.println(oldContact.getName() + " was  replaced with " + newContact.getName());
        return true;
    }

    public void showContacts() {
        if (this.myContacts.isEmpty()) {
            System.out.println("Your list is empty  :D   ");
            return;
        }
        System.out.println("                       Your Contact list is : ");

        for (int i = 0; i < myContacts.size(); i++) {

            System.out.println(this.myContacts.get(i).getName() + "---> " + this.myContacts.get(i).getNumber());
        }

    }

    private int findContact(Contact oldContact) {
        return this.myContacts.indexOf(oldContact);

    }

    private int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (this.myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String QureyContact(Contact contact) {
        if (findContact(contact) < 0) {
            return "Not Found   ";
        }
        return contact.getName();
    }

    public String removeContact(Contact c) {
        int position = findContact(c);
        if (position < 0) {
            return c.getName() + "  wasnt  found  ! ";
        }
        this.myContacts.remove(position);
        return c.getName() + " was delete :) !";

    }

    public Contact QureyContact(String name) {
        int position = findContact(name);
        if (position < 0) {
            return null;
        }
        return this.myContacts.get(position);

    }

    public boolean removeAllContact() {
        return this.myContacts.removeAll(myContacts);
    }

}
