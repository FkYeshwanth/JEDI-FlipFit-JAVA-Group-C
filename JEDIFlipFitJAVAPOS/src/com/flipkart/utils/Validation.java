package com.flipkart.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static Scanner sc=new Scanner(System.in);

    public static String enter_email(){
        System.out.print("\u001B[35mEnter Email: \u001B[0m");
        String email=sc.next();
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(email);
        while(!m.matches()){
            System.out.println("\u001B[31mInvalid Email\u001B[0m");
            System.out.print("\u001B[35mEnter Email: \u001B[0m");
            email = sc.next();
            m = pattern.matcher(email);
        }

        return email;
    }

    public static String enter_password() {
        String password;
        String confirmPassword;

        do {
            System.out.print("\u001B[35mEnter password: \u001B[0m");
            password = sc.next();

            System.out.print("\u001B[35mConfirm password: \u001B[0m");
            confirmPassword = sc.next();

            if (!password.equals(confirmPassword)) {
                System.out.println("\u001B[31mPasswords do not match. Please try again.\u001B[0m");
            }
        } while (!password.equals(confirmPassword));

        System.out.println("\u001B[32mPassword set successfully....\u001B[0m");
        return password;
    }

    public static String enterName() {
        System.out.print("\u001B[35mEnter Name: \u001B[0m");
        String name = sc.next();
        String regex = "^[a-zA-Z]+$"; // Only alphabets allowed
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(name);

        while (!m.matches()) {
            System.out.println("\u001B[31mInvalid Name. Only alphabets are allowed.\u001B[0m");
            System.out.print("\u001B[35mEnter Name: \u001B[0m");
            name = sc.next();
            m = pattern.matcher(name);
        }

        return name;
    }




    public static String enter_phone_number() {
        String phoneNo;

        do {
            System.out.print("\u001B[35mEnter Phone Number: \u001B[0m");
            phoneNo = sc.next();
            if (phoneNo.length() != 10 || !phoneNo.matches("\\d+")) {
                System.out.println("\u001B[31mInvalid Phone Number\u001B[0m");
            }


        } while (phoneNo.length() != 10 || !phoneNo.matches("\\d+"));

        return phoneNo;
    }

    public static String enter_adhar_number() {
        String adharNo;

        do {
            System.out.print("\u001B[35mEnter Adhar Number: \u001B[0m");
            adharNo = sc.next();
            if (adharNo.length() != 12 || !adharNo.matches("\\d+")) {
                System.out.println("\u001B[31mInvalid Adhar Number\u001B[0m");
            }


        } while (adharNo.length() != 12 || !adharNo.matches("\\d+"));

        return adharNo;
    }

    public static String enterPan() {
        System.out.print("\u001B[35mEnter PAN: \u001B[0m");
        String pan = sc.next();
        String regex = "^[A-Z]{5}[0-9]{4}[A-Z]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(pan);

        while (!m.matches()) {
            System.out.println("\u001B[31mInvalid PAN. Please enter a valid PAN.\u001B[0m");
            System.out.print("\u001B[35mEnter PAN: \u001B[0m");
            pan = sc.next();
            m = pattern.matcher(pan);
        }

        return pan;
    }

    public static int enter_age() {
        int age;

        do {
            System.out.print("\u001B[35mEnter Age : \u001B[0m");

            while (!sc.hasNextInt()) {
                System.out.println("\u001B[31mInvalid input. Please enter a valid integer for age.\u001B[0m");
                System.out.print("\u001B[35mEnter Age: \u001B[0m");
                sc.next(); // Consume the invalid input
            }

            age = sc.nextInt();

            if (age < 1 || age > 119) {
                System.out.println("\u001B[31mInvalid Age...\u001B[0m");
            }

        } while (age < 1 || age > 119);

        return age;
    }

    public static String enter_address() {
        String address;

        do {
            System.out.print("\u001B[35mEnter Address: \u001B[0m");
            // Consume the newline character left by previous sc.nextInt()
            sc.nextLine();

            address = sc.nextLine().trim(); // Trim to remove leading/trailing whitespaces

            if (address.isEmpty()) {
                System.out.println("\u001B[31mInvalid Address. Please enter a non-empty address.\u001B[0m");
            }

        } while (address.isEmpty());

        return address;
    }



}
