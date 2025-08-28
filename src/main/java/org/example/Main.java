package org.example;

import org.example.validator.PasswordValidator;
import org.example.validator.Reason;
import org.example.validator.ValidationResult;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String allowed = "!@#$%^&*()-_+=?.,;:";
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie bitte ein neues Passwort ein:");
        // "sfd;B5gdg?dsAA6#"
        checkPassword(input.nextLine(), allowed);
        System.out.println();
        System.out.println("Das Passwort wird automatisch generiert.");
        System.out.println();
        checkPassword(PasswordValidator.generateSecurePassword(10, allowed), allowed);
    }

    static void checkPassword(String password, String allowed) {
        System.out.println("\r\n###############  " + password + "  ###############\r\n");
        ValidationResult validationResult = PasswordValidator.validatePassword(password, allowed);
        if(validationResult.isValid()) {
            System.out.println("Das Passwort ist gültig");
        } else {
            for(Reason reason : validationResult.getReasons()) {
                System.out.println(reason.getMessage());
            }
        }
    }
}