package com.flipkart.client;

import java.util.Scanner;


import com.flipkart.utils.*;
import com.flipkart.bean.Person;
import com.flipkart.constants.ColorConstants;
import com.flipkart.service.PersonFlipFitService;
import com.flipkart.exception.InvalidInputException;

/**
 * This class provides a menu-driven interface for the FlipFit application.
 */
public class ApplicationFlipFitMenu {

    /**
     * Authenticates the user and navigates to the respective menu based on the provided credentials.
     * Handles login for Admin, Customer, and Gym Owner roles.
     *
     * @throws Exception Any exception that might occur during the login process.
     */
    public static void login() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("__________________________________________________________________________________\n");
        System.out.println("Enter LogIn Details\n");
        System.out.print("Enter Email: ");
        String personEmail = in.next();
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.print("\u001B[36mEnter Role Id: ( 1=Admin / 2=Customer / 3=Owner )\u001B[0m");
        String roleId = in.next();
        Person person = new Person(personEmail, password, roleId);
        PersonFlipFitService personService = new PersonFlipFitService();
        if (roleId.equalsIgnoreCase("1")) {
            AdminFlipFitMenu admin = new AdminFlipFitMenu();
            admin.AdminMenu(in);
        } else if (personService.authenticatePerson(person)) {
            System.out.println("__________________________________________________________________________________\n");
            System.out.println(
                    ColorConstants.GREEN + "Welcome " + personEmail + "! You are logged in." + ColorConstants.RESET);

            if (roleId.equalsIgnoreCase("2")) {
                CustomerFlipFitMenu customer = new CustomerFlipFitMenu();
                customer.customerMenu(personEmail);
            } else if (roleId.equalsIgnoreCase("3")) {
                GymOwnerFlipFitMenu gymOwner = new GymOwnerFlipFitMenu();
                gymOwner.gymOwnerMenu(in, personEmail);
            } else {
                System.out.println(ColorConstants.RED + "Wrong Choice!" + ColorConstants.RESET);
            }
        } else {
            System.out.println(ColorConstants.RED + "\nSorry! You are not Registered! Please Register Yourself!" + ColorConstants.RESET);
        }
    }

    /**
     * Displays the main application menu and handles user choices.
     * Allows users to login, register as a customer, register as a gym owner, or exit the application.
     *
     * @throws Exception Any exception that might occur during the execution of the menu.
     */
    public static void applicationMenu() throws Exception {
        boolean recur = true;
        //System.out.println(ColorConstants.GREEN + "Welcome to the FlipFit Application!" + ColorConstants.RESET);
        System.out.println("\n");
        System.out.println(("\u001B[36m---------------------------------------------------------------------------------------------------------------------------------------------------------"));
        System.out.println("\n");
        System.out.println(" /$$      /$$           /$$                                                     /$$                     /$$$$$$$$ /$$ /$$           /$$$$$$$$ /$$   /$$    \n" +
                "| $$  /$ | $$          | $$                                                    | $$                    | $$_____/| $$|__/          | $$_____/|__/  | $$    \n" +
                "| $$ /$$$| $$  /$$$$$$ | $$  /$$$$$$$  /$$$$$$  /$$$$$$/$$$$   /$$$$$$        /$$$$$$    /$$$$$$       | $$      | $$ /$$  /$$$$$$ | $$       /$$ /$$$$$$  \n" +
                "| $$/$$ $$ $$ /$$__  $$| $$ /$$_____/ /$$__  $$| $$_  $$_  $$ /$$__  $$      |_  $$_/   /$$__  $$      | $$$$$   | $$| $$ /$$__  $$| $$$$$   | $$|_  $$_/  \n" +
                "| $$$$_  $$$$| $$$$$$$$| $$| $$      | $$  \\ $$| $$ \\ $$ \\ $$| $$$$$$$$        | $$    | $$  \\ $$      | $$__/   | $$| $$| $$  \\ $$| $$__/   | $$  | $$    \n" +
                "| $$$/ \\  $$$| $$_____/| $$| $$      | $$  | $$| $$ | $$ | $$| $$_____/        | $$ /$$| $$  | $$      | $$      | $$| $$| $$  | $$| $$      | $$  | $$ /$$\n" +
                "| $$/   \\  $$|  $$$$$$$| $$|  $$$$$$$|  $$$$$$/| $$ | $$ | $$|  $$$$$$$        |  $$$$/|  $$$$$$/      | $$      | $$| $$| $$$$$$$/| $$      | $$  |  $$$$/\n" +
                "|__/     \\__/ \\_______/|__/ \\_______/ \\______/ |__/ |__/ |__/ \\_______/         \\___/   \\______/       |__/      |__/|__/| $$____/ |__/      |__/   \\___/  \n" +
                "                                                                                                                         | $$                              \n" +
                "                                                                                                                         | $$                              \n" +
                "                                                                                                                         |__/                              ");

        System.out.println("\n");
        System.out.println(("---------------------------------------------------------------------------------------------------------------------------------------------------------\u001B[0m"));
        System.out.println("\n");
        while (recur) {
            System.out.println("\u001B[33m\nChoose your action:\u001B[0m");
            System.out.println("\u001B[36m1. Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Gym Owner Registration");
            System.out.println("4. Exit\u001B[0m");
            System.out.print("\nEnter Your Choice: ");

            Scanner in = new Scanner(System.in);
            int choice = 4;
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println(ColorConstants.RED + "Please enter a numeric value between [1-4]" + ColorConstants.RESET);
                continue;
            }

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

    /**
     * Main method to start the FlipFit application.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws Exception Any exception that might occur during the execution of the main method.
     */
    public static void main(String[] args) throws Exception {
        applicationMenu();
    }
}
