package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.flipkart.bean.Person;
import com.flipkart.service.PersonFlipFitService;
import com.flipkart.constants.*;

public class ApplicationFlipFitMenu {

    public static void login() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("____________________________\n");
        System.out.println("Enter LogIn Details\n");
        System.out.print("Enter Email: ");
        String personEmail = in.next();
        System.out.print("Enter Password: ");
        String password = in.next();
        System.out.print("Enter Role Id: (1=Admin / 2=Customer / 3=Owner)");
        String roleId = in.next();
        Person person = new Person(personEmail, password, roleId);
        PersonFlipFitService personService = new PersonFlipFitService();

        if (roleId.equalsIgnoreCase("1")) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            System.out.println("____________________________\n");
            System.out.println(ColorConstants.GREEN + "Welcome Admin " + personEmail + " ! You are logged in at " + formattedDateTime + "." + ColorConstants.RESET);

            AdminFlipFitMenu admin = new AdminFlipFitMenu();
            admin.AdminMenu(in);
        } else if (personService.authenticatePerson(person)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);



            if (roleId.equalsIgnoreCase("2")) {
                System.out.println("____________________________\n");
                System.out.println(ColorConstants.GREEN + "Welcome Customer " + personEmail + "! You are logged in at " + formattedDateTime + "." + ColorConstants.RESET);
                CustomerFlipFitMenu customer = new CustomerFlipFitMenu();
                customer.customerMenu(personEmail);
            } else if (roleId.equalsIgnoreCase("3")) {
                System.out.println("____________________________\n");
                System.out.println(ColorConstants.GREEN + "Welcome Gym Owner " + personEmail + "! You are logged in at " + formattedDateTime + "." + ColorConstants.RESET);
                GymOwnerFlipFitMenu gymOwner = new GymOwnerFlipFitMenu();
                gymOwner.gymOwnerMenu(in, personEmail);
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
            int choice=4;
            try{
                choice= in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println(ColorConstants.RED +"Please enter a numeric value between [1-4]");
                System.out.println(ColorConstants.RESET);
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

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        applicationMenu();
    }

}