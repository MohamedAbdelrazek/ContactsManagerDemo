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
public class Contact {
    private static Scanner scanner=new Scanner(System.in);

       private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static Contact CreateContact(String name,String number) {
        return new Contact(name, number);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
    

}
