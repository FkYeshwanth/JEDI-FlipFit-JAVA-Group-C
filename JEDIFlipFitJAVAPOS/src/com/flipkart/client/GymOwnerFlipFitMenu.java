package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.GymOwner;
public class GymOwnerFlipFitMenu {
    GymOwner gymOwner = new GymOwner();

    public void gymOwnerMenu(Scanner in, String email) {
        boolean recur = true;
        while (recur) {
            System.out.println("\n\u001B[32mHere are the actions you can perform!");

            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Request Gym");
            System.out.println("4. Edit Gym");
            System.out.println("5, Delete Gym");
            System.out.println("6. Update Slot");
            System.out.println("7. View All Gym Details");
            System.out.println("8. LogOut\033[0m\n");

            System.out.print("\u001B[35mEnter Your Choice: \033[0m");
            int choice = in.nextInt();

            System.out.println("\u001B[33m______________________________________________________________\033[0m\n");

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
                    System.out.println("\u001B[31mInvalid Choice!\033[0m");
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
        System.out.println("\n\u001B[32mEnter GymOwner Details: \n");
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
        System.out.print("Enter Aadhaar: \033[0m");
        gymOwner.setAadharNumber(in.next());

    }
}
