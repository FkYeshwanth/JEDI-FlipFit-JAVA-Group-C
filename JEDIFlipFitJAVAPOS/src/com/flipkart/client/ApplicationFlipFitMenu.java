package com.flipkart.client;
import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.util.*;

public class ApplicationFlipFitMenu {

    public static void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("\u001B[32m__________________________________________________________________________________\n");
        System.out.println("\u001B[33mEnter LogIn Details\033[0m\n");
        System.out.print("\u001B[35mEnter Email: ");
        String PersonEmail = in.next();
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.println("Enter Role Choice: \033[0m");
        System.out.println("\u001B[32m1. Admin");
        System.out.println("2. Gym Owner");
        System.out.println("3. Gym Customer\033[0m");
        String roleId = in.next();
        Person Person = new Person(PersonEmail, password, roleId);
        PersonFlipFitInterface PersonFlipFitService = new PersonFlipFitInterface() {
            @Override
            public boolean authenticatePerson(com.flipkart.bean.Person p) {
                return false;
            }

            @Override
            public boolean registerCustomer(GymUser customer) {
                return false;
            }

            @Override
            public boolean registerGymOwner(GymOwner gymOwner) {
                return false;
            }

            @Override
            public boolean authenticateUser(com.flipkart.bean.Person user) {
                return false;
            }

            @Override
            public boolean logout(com.flipkart.bean.Person user) {
                return false;
            }
        };
        if (roleId.equals("1")) {
            AdminFlipFitMenu admin = new AdminFlipFitMenu();
            admin.AdminMenu(in);
        }
        else if (PersonFlipFitService.authenticatePerson(Person)) {
            System.out.println("__________________________________________________________________________________\n");
            System.out.println("Welcome " + PersonEmail + "! You are logged in.");

            if (roleId.equals("3")) {

                CustomerFlipFitMenu customer = new CustomerFlipFitMenu();
                customer.customerMenu(PersonEmail);

            } else if (roleId.equals("2")) {

                GymOwnerFlipFitMenu gymOwner = new GymOwnerFlipFitMenu();
                gymOwner.gymOwnerMenu(in, PersonEmail);

            } else {
                System.out.println("\u001B[31mWrong Choice!\033[0m");
            }
        } else {
            System.out.println("\n\u001B[31mSorry! You are not Registered! Please Register Yourself!\033[0m");
        }
    }

    public static void applicationMenu() {
        boolean recur = true;
        System.out.println("\u001B[36mWelcome to the \u001B[36mFlipFit Application\033[0m");

        while (recur) {
            System.out.println("\n\u001B[33m Available menu are:-\033[0m");
            System.out.println("\u001B[32m1. Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Gym Owner Registration");
            System.out.println("4. Update Password");
            System.out.println("5. Exit");
            System.out.print("\n\u001B[35mEnter Your Choice: \033[0m");

            Scanner in = new Scanner(System.in);

            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    CustomerFlipFitMenu customer = new CustomerFlipFitMenu();
                    customer.registerCustomer();
                    login();
                    break;
                case 3:
                    GymOwnerFlipFitMenu owner = new GymOwnerFlipFitMenu();
                    owner.gymOwnerRegistration(in);
                    login();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("\u001B[34mExiting...");
                    System.out.println("Exited Successfully\033[0m");
                    recur = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("\u001B[31mWrong choice\033[0m");
            }
        }

    }
    public static void main(String[] args) {
        applicationMenu();
    }
}
