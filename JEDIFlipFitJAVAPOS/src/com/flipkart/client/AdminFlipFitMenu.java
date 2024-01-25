package com.flipkart.client;
import java.util.*;
public class AdminFlipFitMenu {

    public void AdminMenu(Scanner in) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        while (true) {
            System.out.println("\u001B[32m1. View All Gym ");
            System.out.println("2. View All Gym Owners");
            System.out.println("3. View all pending Gym Owner Requests");
            System.out.println("4. View all pending Gym Requests");
            System.out.println("5. Approve all pending Gym Owner Requests");
            System.out.println("6. Approve all pending Gym Requests");
            System.out.println("7. Access User History");
            System.out.println("8. Exit\033[0m");

            System.out.print("\u001B[35mEnter your choice: \033[0m");
            int choice = in.nextInt();
            switch (choice) {
                // Case statements
                case 1:
//                    viewAllGyms(gymList);
                    break;
                case 2:
//                    viewAllGymOwners(gymOwnerList);
                    break;
                case 3:
//                    viewAllPendingGymOwnerRequests();
                    break;
                case 4:
//                    viewAllPendingGymRequests();
                    break;
                case 5:
//                    approvePendingGymOwnerRequests();
                    break;
                case 6:
//                    approvePendingGymRequests();
                    break;
                case 7:
//                    accessLogs();
                case 8:
                    return;
                // Default case statement
                default:
                    System.out.println("\u001B[31mWrong choice\033[0m");
            }

        }
    }
}
