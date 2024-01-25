package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.DAO.GymOwnerDAOImpl;
public class GymOwnerFlipFitMenu {
    GymOwner gymOwner = new GymOwner();

    public void gymOwnerMenu(Scanner in, String email) {
        boolean recur = true;
        System.out.println(recur);
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
                    viewProfile(in, email);
                    break;
                case 2:
                    editProfile(in, email);
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

    private void viewProfile(Scanner in, String email) {
        GymOwner owner = GymOwnerDAOImpl.gymOwnerHash.get(email);
        System.out.println("Name--> "+owner.getName());
        System.out.println("Ph No--> "+owner.getPhoneNumber());
        System.out.println("Aadhaar Num--> "+owner.getAadharNumber());
        System.out.println("PAN Num--> "+owner.getPanNumber());
        System.out.println("List of registered gyms------------>");
        int count = 1;
        for(Gym i: owner.getCenteres()){
            System.out.println(count + "GymID---->" + i.getGymId());
            System.out.println("Name--> "+i.getGymName());
            System.out.println("Address--> "+i.getAddress());
            System.out.println("Slot count--> "+i.getSlotCount());
        }
    }

    private void editProfile(Scanner in, String email) {
        GymOwner owner = GymOwnerDAOImpl.gymOwnerHash.get(email);
        System.out.println("What do you want to edit----->");
        Scanner in2 = new Scanner(System.in);
        System.out.println("1.Name");
        System.out.println("2.Ph No");
        System.out.println("3.Aadhaar Num");
        System.out.println("4.PAN Num");
        int choice = in2.nextInt();
        if(choice==1){
            System.out.println("Enter new name--->");
            String newname = in2.next();
            owner.setName(newname);
        }else if(choice==2){
            System.out.println("Enter new phone number--->");
            String newph = in2.next();
            owner.setName(newph);
        }else if(choice==3){
            System.out.println("Enter updated Aadhaar Number--->");
            String newAad= in2.next();
            owner.setName(newAad);
        }else if(choice==4){
            System.out.println("Enter updated PAN--->");
            String newPAN = in2.next();
            owner.setName(newPAN);
        }
        System.out.println("Updated profile---->");
        viewProfile(in,email);
    }

    public void gymOwnerRegistration (Scanner in){
        System.out.println("\n\u001B[32mEnter GymOwner Details: \n");

        System.out.print("Enter Email: ");
        String email= in.next();
        gymOwner.setEmail(email);
        System.out.print("Enter Password: ");
        String password= in.next();
        gymOwner.setPassword(password);
        gymOwner.setRoleId("GymOwner");
        System.out.print("Enter Name: ");
        String name= in.next();
        gymOwner.setName(name);
        System.out.print("Enter Phone Number: ");
        String phoneNum= in.next();
        gymOwner.setPhoneNumber(phoneNum);
        System.out.print("Enter PAN: ");
        String pan= in.next();
        gymOwner.setPanNumber(pan);
        System.out.print("Enter Aadhaar: \033[0m");
        String aadhar= in.next();
        gymOwner.setAadharNumber(aadhar);
        GymOwnerDAOImpl gymOwnerDAOImpl = new GymOwnerDAOImpl();
        gymOwnerDAOImpl.addGymOwnerDetails(name, email, password, phoneNum,pan,aadhar);

    }
}
