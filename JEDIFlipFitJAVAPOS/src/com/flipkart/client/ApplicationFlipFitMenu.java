package com.flipkart.client;
import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.util.*;

public class ApplicationFlipFitMenu {

    public static void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("__________________________________________________________________________________\n");
        System.out.println("Enter LogIn Details\n");
        System.out.print("Enter Email: ");
        String PersonEmail = in.next();
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.println("Enter Role Choice: ");
        System.out.println("1. Admin");
        System.out.println("2. Gym Owner");
        System.out.println("3. Gym Customer");
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
            System.out.println(
                    "Welcome " + PersonEmail + "! You are logged in.");

            if (roleId.equals("3")) {

                CustomerFlipFitMenu customer = new CustomerFlipFitMenu();
                customer.customerMenu(PersonEmail);

            } else if (roleId.equals("2")) {

                GymOwnerFlipFitMenu gymOwner = new GymOwnerFlipFitMenu();
                gymOwner.gymOwnerMenu(in, PersonEmail);

            } else {
                System.out.println("Wrong Choice!");
            }
        } else {
            System.out.println("\nSorry! You are not Registered! Please Register Yourself!");
        }
    }

    public static void applicationMenu() {
        boolean recur = true;
        System.out.println("<---------------Welcome to the FlipFit Application!--------------->");

        while (recur) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Gym Owner Registration");
            System.out.println("4. Update Password");
            System.out.println("5. Exit");
            System.out.print("\nEnter Your Choice: ");

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
                    System.out.println("Exiting...");
                    System.out.println("Exited Successfully");
                    recur = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }

    }
    public static void main(String[] args) {
        applicationMenu();
    }
}
