package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymOwnerFlipFitService;
import com.flipkart.service.PersonFlipFitService;
import com.flipkart.constants.ColorConstants;
import com.flipkart.utils.IdGenerator;

/**
 * This class provides a menu-driven interface for the gym owners using the FlipFit application.
 */
public class GymOwnerFlipFitMenu {

    GymOwner gymOwner = new GymOwner();
    GymOwnerFlipFitService gymOwnerservice = new GymOwnerFlipFitService();
    PersonFlipFitService userservice = new PersonFlipFitService();

    /**
     * Registers a new gym owner by taking user input for email, password, name, phone number, PAN, and Aadhaar.
     * Registers the gym owner using the PersonFlipFitService.
     *
     * @param in The Scanner object for user input.
     */
    public void gymOwnerRegistration(Scanner in) {
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

        PersonFlipFitService userservice = new PersonFlipFitService();
        boolean registerSuccess = userservice.registerGymOwner(gymOwner);

        if (registerSuccess)
            System.out
                    .println("\n" + ColorConstants.GREEN + "Gym Owner registered successfully!" + ColorConstants.RESET);
        else
            System.out.println(
                    "\n" + ColorConstants.RED + "Gym Owner registration failed! Try again!" + ColorConstants.RESET);
    }

    /**
     * Edits the profile details of the gym owner.
     * Takes user input for new email, password, name, phone number, PAN, and Aadhaar.
     * Calls the editProfile method of GymOwnerFlipFitService to update the profile.
     *
     * @param in The Scanner object for user input.
     * @param email The email of the gym owner whose profile is being edited.
     */
    public void editProfile(Scanner in, String email) {
        gymOwner = gymOwnerservice.getProfile(email);
        GymOwner newgymOwner = new GymOwner();
        System.out.println("Enter Details: ");
        System.out.print("Enter Email: ");
        newgymOwner.setEmail(in.next());
        System.out.print("Enter Password: ");
        newgymOwner.setPassword(in.next());
        newgymOwner.setRoleId("3");
        System.out.print("Enter Name: ");
        newgymOwner.setName(in.next());
        System.out.print("Enter Phone Number: ");
        newgymOwner.setPhoneNumber(in.next());
        System.out.print("Enter PAN: ");
        newgymOwner.setPanNumber(in.next());
        System.out.print("Enter Aadhaar: ");
        newgymOwner.setAadharNumber(in.next());

        gymOwnerservice.editProfile(gymOwner,newgymOwner);
    }

    /**
     * Displays the profile details of the gym owner.
     *
     * @param in The Scanner object for user input.
     * @param email The email of the gym owner whose profile is being viewed.
     */
    public void viewProfile(Scanner in, String email) {
        gymOwner = gymOwnerservice.getProfile(email);
        System.out.println("______________________________________________________________");
        System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
        System.out.println();
        System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNumber(), gymOwner.getPanNumber(),
                gymOwner.getAadharNumber());
        System.out.println("\n______________________________________________________________");
    }

    /**
     * Adds a new gym with details such as gym name, address, slot count, and seats per slot count.
     * Calls the addGym method of GymOwnerFlipFitService to add the gym.
     *
     * @param in The Scanner object for user input.
     * @param email The email of the gym owner adding the gym.
     */
    public void addGym(Scanner in, String email) {
        System.out.println("Please Enter Gym Details ");

        Gym gym = new Gym();
        gym.setGymId(IdGenerator.generateId("Gym"));
        System.out.print("Gym Name: ");
        gym.setGymName(in.next());
        gym.setOwnerEmail(email);
        System.out.print("Address: ");
        gym.setAddress(in.next());
        System.out.print("SlotCount: ");
        gym.setSlotCount(in.nextInt());
        System.out.print("SeatsPerSlotCount: ");
        gym.setSeatsPerSlotCount(in.nextInt());
        gym.setVerified(false);

        gymOwnerservice.addGym(gym);
    }

    /**
     * Edits the details of an existing gym, such as gym name, address, slot count, and seats per slot count.
     * Calls the editGym method of GymOwnerFlipFitService to update the gym details.
     *
     * @param in The Scanner object for user input.
     * @param email The email of the gym owner editing the gym.
     */
    public void editGym(Scanner in, String email) {
        System.out.println("Please Enter Gym Details ");

        Gym gym = new Gym();
        System.out.print("Gym Id: ");
        gym.setGymId(in.next());
        System.out.print("GymName: ");
        gym.setGymName(in.next());
        gym.setOwnerEmail(email);
        System.out.print("Address: ");
        gym.setAddress(in.next());
        System.out.print("SlotCount: ");
        gym.setSlotCount(in.nextInt());
        System.out.print("SeatsPerSlotCount: ");
        gym.setSeatsPerSlotCount(in.nextInt());
        gym.setVerified(false);

        gymOwnerservice.editGym(gym);
    }

    /**
     * Displays details of all gyms owned by the gym owner.
     *
     * @param in The Scanner object for user input.
     * @param email The email of the gym owner whose gyms are being viewed.
     */
    public void getGymDetails(Scanner in, String email) {
        List<Gym> gymDetails = gymOwnerservice.getGymDetail(email);
        for (Gym gym : gymDetails) {
            System.out.println(gym);
        }
    }

    /**
     * Adds a new slot to a gym with details such as start time, end time, number of seats, and trainer.
     * Calls the addSlot method of GymOwnerFlipFitService to add the slot.
     *
     * @param in The Scanner object for user input.
     */
    public void addSlot(Scanner in) {
        System.out.println("Enter Slot Details: ");
        Slot slot = new Slot();
        slot.setSlotId(IdGenerator.generateId("Slot"));
        System.out.print("Enter Gym Id:");
        slot.setGymId(in.next());
        System.out.print("Enter Slot Start Time: ");
        slot.setStartTime(in.next());
        System.out.print("Enter Slot End Time: ");
        slot.setEndTime(in.next());
        System.out.print("Enter number of seats in slot: ");
        slot.setNumOfSeats(in.nextInt());
        System.out.print("Enter Trainer: ");
        slot.setTrainer(in.next());
        slot.setNumOfSeatsBooked(0);

        gymOwnerservice.addSlot(slot);
    }

    /**
     * Displays the menu for gym owners, allowing them to perform various actions.
     * The actions include viewing/editing profile, adding/editing gyms, adding slots, and logging out.
     *
     * @param in The Scanner object for user input.
     * @param email The email of the gym owner accessing the menu.
     */
    public void gymOwnerMenu(Scanner in, String email) {
        boolean recur = true;
        while (recur) {
            System.out.println("\nHere are the actions you can perform!");

            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Add Gym");
            System.out.println("4. Edit Gym");
            System.out.println("5. Add Slot");
            System.out.println("6. View All Gym Details");
            System.out.println("7. LogOut\n");

            System.out.print("Enter Your Choice: " );
            int choice = in.nextInt();

            System.out.println("______________________________________________________________\n");

            switch (choice) {
                case 1:
                    viewProfile(in, email);
                    break;
                case 2:
                    editProfile(in, email);
                    break;
                case 3:
                    addGym(in, email);
                    break;
                case 4:
                    editGym(in, email);
                    break;
                case 5:
                    addSlot(in);
                    break;
                case 6:
                    getGymDetails(in, email);
                    break;
                case 7:
                    recur = false;
                    break;
                default:
                    System.out.println(ColorConstants.RED + "Invalid Choice!" + ColorConstants.RESET);
            }
            if (!recur) {
                gymOwner = new GymOwner();
                boolean logOutSuccess = userservice.logout(gymOwner);
                if (logOutSuccess)
                    System.out.println(ColorConstants.GREEN + "Logged Out Successfully!" + ColorConstants.RESET);
                else
                    System.out.println(ColorConstants.RED + "Logged Out Successfully!" + ColorConstants.RESET);
            }
        }

    }

}