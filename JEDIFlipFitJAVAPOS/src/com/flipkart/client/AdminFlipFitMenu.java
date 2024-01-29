package com.flipkart.client;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.service.*;

import java.util.*;
public class AdminFlipFitMenu {
    AdminFlipFitService adminBusiness = new AdminFlipFitService();

    List<GymOwner> gymOwnerList = adminBusiness.getGymOwners();
    List<Gym> gymList = adminBusiness.getGym();
    Scanner sc = new Scanner(System.in);

    public void viewAllPendingGymOwnerRequests() {
        viewAllGymOwners(adminBusiness.viewAllPendingGymOwnerRequests());
    }
    public void viewAllPendingGymRequests() {
        viewAllGyms(adminBusiness.viewAllPendingGymRequests());
    }

    public void approveSingleGymOwnerRequest() {
        System.out.println("Enter gym owner email: ");
        adminBusiness.approveSingleGymOwnerRequest(sc.next());
    }

    public void approveSingleGymRequest() {
        System.out.println("Enter gym Id: ");
        adminBusiness.approveSingleGymRequest(sc.next());
    }

    public void approvePendingGymOwnerRequests() {
        adminBusiness.approveAllPendingGymOwnerRequests();
    }

    public void approvePendingGymRequests() {
        adminBusiness.approveAllPendingGymRequests();
    }
    public void viewAllGyms(List<Gym> gyms) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s |\n",
                "Gym ID", "Gym Name", "Edited", "Address", "Total Slots", "Approved");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for (Gym gym : gyms) {
            System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-10d | %-15s|\n",
                    gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(), gym.getAddress(),
                    gym.getSlotCount(), gym.isVerified() ? "Approved" : "Processing");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public void viewAllGymOwners(List<GymOwner> gymOwners) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-20s | %-15s | %-20s | %-15s |\n",
                "Owner Name", "Owner PhoneNo", "Owner Adhaar", "Owner PAN", "Owner Verification");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for (GymOwner gymOwner : gymOwners) {
            System.out.printf("| %-15s | %-20s | %-15s | %-20s | %-15s |\n",
                    gymOwner.getName(), gymOwner.getPhoneNumber(), gymOwner.getAadharNumber(), gymOwner.getPanNumber(),
                    gymOwner.isVerified() ? "Approved" : "Processing");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

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
                    viewAllGyms(gymList);
                    break;
                case 2:
                    viewAllGymOwners(gymOwnerList);
                    break;
                case 3:
                    viewAllPendingGymOwnerRequests();
                    break;
                case 4:
                    viewAllPendingGymRequests();
                    break;
                case 5:
                    approvePendingGymOwnerRequests();
                    break;
                case 6:
                    approvePendingGymRequests();
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
