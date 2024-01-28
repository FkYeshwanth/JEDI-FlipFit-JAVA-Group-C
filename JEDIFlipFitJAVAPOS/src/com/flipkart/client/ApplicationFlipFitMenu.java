package com.flipkart.client;

import java.util.*;

import com.flipkart.bean.Person;
import com.flipkart.service.PersonFlipFitService;
import com.flipkart.constants.*;

public class ApplicationFlipFitMenu {

    public static void login() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("__________________________________________________________________________________\n");
        System.out.println("Enter LogIn Details\n");
        System.out.print("Enter Email: ");
        String PersonEmail = in.next();
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.print("Enter Role Id: (1=admin /2=customer /3=owner)");
        String roleId = in.next();
        Person Person = new Person(PersonEmail, password, roleId);
        PersonFlipFitService personService = new PersonFlipFitService();
        if (roleId.equalsIgnoreCase("1")) {
            AdminFlipFitMenu admin = new AdminFlipFitMenu();
            admin.AdminMenu(in);
        }
        else if (personService.authenticatePerson(Person)) {
            System.out.println("__________________________________________________________________________________\n");
            System.out.println(
                    ColorConstants.GREEN + "Welcome " + PersonEmail + "! You are logged in." + ColorConstants.RESET);

            if (roleId.equalsIgnoreCase("2")) {

                CustomerFlipFitMenu customer = new CustomerFlipFitMenu();
                customer.customerMenu(PersonEmail);

            } else if (roleId.equalsIgnoreCase("3")) {

                GymOwnerFlipFitMenu gymOwner = new GymOwnerFlipFitMenu();
                gymOwner.gymOwnerMenu(in, PersonEmail);

            } else {
                System.out.println(ColorConstants.RED + "Wrong Choice!" + ColorConstants.RESET);
            }
        } else {
            System.out.println(ColorConstants.RED + "\nSorry! You are not Registered! Please Register Yourself!" + ColorConstants.RESET);
        }
    }

    public static void applicationMenu() throws Exception {
        boolean recur = true;
        System.out.println(ColorConstants.GREEN + "Welcome to the FlipFit Application!" + ColorConstants.RESET);

        while (recur) {
            System.out.println("\nChoose your action:");
            System.out.println("1. Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Gym Owner Registration");
            System.out.println("4. Exit");
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
                    System.out.println(ColorConstants.RED + "Exiting..." + ColorConstants.RESET);
                    System.out.println(ColorConstants.GREEN + "Exited Successfully" + ColorConstants.RESET);
                    recur = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println(ColorConstants.RED + "Wrong choice" + ColorConstants.RESET);
            }
        }


    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        applicationMenu();
    }

}
