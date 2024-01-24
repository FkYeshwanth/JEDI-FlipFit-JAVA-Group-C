package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.GymOwner;
public class GymOwnerFlipFitMenu {
    GymOwner gymOwner = new GymOwner();

    public void gymOwnerMenu(Scanner in, String email) {
        boolean recur = true;
        while (recur) {
            System.out.println("\nHere are the actions you can perform!");

            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Request Gym");
            System.out.println("4. Edit Gym");
            System.out.println("5, Delete Gym");
            System.out.println("6. Update Slot");
            System.out.println("7. View All Gym Details");
            System.out.println("8. LogOut\n");

            System.out.print("Enter Your Choice: ");
            int choice = in.nextInt();

            System.out.println("______________________________________________________________\n");

            switch (choice) {
                case 1:
//                    viewProfile(in, email);
                    break;
                case 2:
//                    editProfile(in, email);
                    break;
                case 3:
//                    addGym(in, email);
                    break;
                case 4:
//                    editGym(in, email);
                    break;
                case 5:
//                    deleteGym();
                    break;
                case 6:
//                    addSlot(in);
                    break;
                case 7:
//                    getGymDetails(in, email);
                    break;
                case 8:
                    recur = false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
//            if (!recur) {
//                gymOwner = new GymOwner();
//                boolean logOutSuccess = userBusiness.logout(gymOwner);
//                if (logOutSuccess)
//                    System.out.println(ColorConstants.GREEN + "Logged Out Successfully!" + ColorConstants.RESET);
//                else
//                    System.out.println(ColorConstants.RED + "Logged Out Successfully!" + ColorConstants.RESET);
//            }

        }


    }
    public void gymOwnerRegistration (Scanner in){
        System.out.println("\nEnter GymOwner Details: \n");
        System.out.print("Enter Email: ");
        gymOwner.setEmail(in.next());
        System.out.print("Enter Password: ");
        gymOwner.setPassword(in.next());
        gymOwner.setRoleId("GymOwner");
        System.out.print("Enter Name: ");
        gymOwner.setName(in.next());
        System.out.print("Enter Phone Number: ");
        gymOwner.setPhoneNumber(in.next());
        System.out.print("Enter PAN: ");
        gymOwner.setPanNumber(in.next());
        System.out.print("Enter Aadhaar: ");
        gymOwner.setAadharNumber(in.next());

    }
}
