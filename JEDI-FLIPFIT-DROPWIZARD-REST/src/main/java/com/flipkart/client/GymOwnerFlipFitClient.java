package com.flipkart.client;

import com.flipkart.DAO.UserFlipFitDAOImpl;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.UnauthorizedAccessException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.service.GymOwnerFlipFitServiceImpl;
import com.flipkart.service.UserFlipFitServiceImpl;
import com.flipkart.utils.IdGenerator;
import com.flipkart.validator.EmailFlipfitValidator;
import com.flipkart.validator.LengthFlipfitValidator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GymOwnerFlipFitClient {

	GymOwner gymOwner = new GymOwner();
	GymOwnerFlipFitServiceImpl gymOwnerBusiness = new GymOwnerFlipFitServiceImpl();
	UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();

	public void gymOwnerRegistration(Scanner in) throws UserAlreadyExistsException {
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                GYM OWNER REGISTRATION             "+ColorConstants.RESET);
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"\nEnter Gym Owner Details: \n");
		String aadhar="",email="",phoneNo="",pan="";
		boolean isEmailCorrect=false;
		while(isEmailCorrect==false){
            System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Email: "+ColorConstants.RESET);
            email = in.next();
			isEmailCorrect = EmailFlipfitValidator.isEmailCorrect(email);
		}
		gymOwner.setEmail(email);

		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Password: "+ColorConstants.RESET);
		gymOwner.setPassword(in.next());
		gymOwner.setRoleId("GymOwner");
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Name: "+ColorConstants.RESET);
		gymOwner.setName(in.next());

		while(!LengthFlipfitValidator.isLengthCorrect(phoneNo,10)){
			if(!phoneNo.isEmpty())
                System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Invalid Phone number"+ColorConstants.RESET);
            System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Phone Number"+ColorConstants.RESET);
            phoneNo = in.next();
		}
		gymOwner.setPhoneNumber(phoneNo);

		while(!LengthFlipfitValidator.isLengthCorrect(aadhar,12)){
			if(!aadhar.isEmpty())
                System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Invalid Aadhaar Number"+ColorConstants.RESET);
            System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Aadhaar Number"+ColorConstants.RESET);
			aadhar = in.next();
		}
		gymOwner.setAadharNumber(aadhar);
		while(!LengthFlipfitValidator.isLengthCorrect(pan,10)){
            if(!pan.isEmpty())System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Invalid PAN Number"+ColorConstants.RESET);
            System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter PAN Number"+ColorConstants.RESET);
            pan = in.next();
		}
		gymOwner.setPanNumber(pan);

		UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();
        userBusiness.registerGymOwner(gymOwner);
        System.out
                .println("\n" + ColorConstants.GREEN + "Gym Owner registered successfully!" + ColorConstants.RESET);
    }

	public void editProfile(Scanner in, String email) {

		try {
			gymOwner = gymOwnerBusiness.getProfile(email);
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		try{
			UserFlipFitDAOImpl u1 = new UserFlipFitDAOImpl();

			gymOwner.setPassword(u1.getPassword(gymOwner.getEmail()));
		}catch (Error e){
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Bad issue"+ColorConstants.RESET);
			return ;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                EDIT PROFILE             "+ColorConstants.RESET);
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Email? Yes/No");
		String choice = sc.next();
		if(choice.equals("Yes")){
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Email: "+ColorConstants.RESET);
			gymOwner.setEmail(email);
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Password? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")){
			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Password: "+ColorConstants.RESET);
			gymOwner.setPassword(in.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Name? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		gymOwner.setRoleId("GymOwner");
		if(choice.equals("Yes")){
			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Name: "+ColorConstants.RESET);
			gymOwner.setName(in.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Phone Number? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Phone Number: "+ColorConstants.RESET);
			gymOwner.setPhoneNumber(in.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change PAN Number? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter PAN Number: "+ColorConstants.RESET);
			gymOwner.setPanNumber(in.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Aadhar Number? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Aadhaar Number: "+ColorConstants.RESET);
			gymOwner.setAadharNumber(in.next());
		}
		try {
			gymOwnerBusiness.editProfile(gymOwner);
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public void viewProfile(Scanner in, String email) {
		try {
			gymOwner = gymOwnerBusiness.getProfile(email);
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=========================================================================="+ColorConstants.RESET);
		System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"%15s%15s%15s%20s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number"+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"\n=========================================================================="+ColorConstants.RESET);
		System.out.println();
		System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"%15s%15s%15s%20s", gymOwner.getName(), gymOwner.getPhoneNumber(), gymOwner.getPanNumber(),
				gymOwner.getAadharNumber());
		System.out.println();
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"\n=========================================================================="+ColorConstants.RESET);
	}

	public void addGym(Scanner in, String email) {
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Please Enter Gym Details "+ColorConstants.RESET);

		Gym gym = new Gym();
		gym.setGymId(IdGenerator.generateId("Gym"));
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Gym Name: "+ColorConstants.RESET);
		gym.setGymName(in.next());
		gym.setOwnerEmail(email);
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Address: "+ColorConstants.RESET);
		gym.setAddress(in.next());
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Slot Count: "+ColorConstants.RESET);
		try {
			gym.setSlotCount(in.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"SeatsPerSlotCount: "+ColorConstants.RESET);
		gym.setSeatsPerSlotCount(in.nextInt());
		gym.setVerified(false);

		gymOwnerBusiness.addGym(gym);
	}

	public void editGym(Scanner in, String email) throws GymNotFoundException {
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Please Enter Gym Details "+ColorConstants.RESET);
		Scanner sc = new Scanner(System.in);
		Gym gym = new Gym();
//		System.out.println("Want to change Email? Yes/No");
//		String choice = sc.next();
//		if(choice.equals("Yes")){
//			System.out.println("Enter Email: ");
//			gymOwner.setEmail(email);
//		}
		String choice;

		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Gym Id: "+ColorConstants.RESET);
		gym.setGymId(in.next());
		Gym existingGym = gymOwnerBusiness.getGymById(gym.getGymId());

		// Check if gym exists and populate values if it exists
		if (existingGym != null) {
			// Use existing values as default values
			gym.setGymName(existingGym.getGymName());
			gym.setAddress(existingGym.getAddress());
			gym.setSlotCount(existingGym.getSlotCount());
			gym.setSeatsPerSlotCount(existingGym.getSeatsPerSlotCount());
			gym.setGymId(existingGym.getGymId());
			gym.setOwnerEmail(existingGym.getOwnerEmail());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Gym Name? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")){
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Gym Name: "+ColorConstants.RESET);
			gym.setGymName(in.next());
			gym.setOwnerEmail(email);
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Address? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")){
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Address: "+ColorConstants.RESET);
			gym.setAddress(in.next());
		}
//
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Slot Count? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter SlotCount: "+ColorConstants.RESET);
			try {
				gym.setSlotCount(in.nextInt());
				System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Want to change Seats Per Slot Count? Yes/No"+ColorConstants.RESET);
				choice = sc.next();
				if (choice.equals("Yes")) {
					System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter SeatsPerSlotCount: "+ColorConstants.RESET);
					gym.setSeatsPerSlotCount(in.nextInt());
				}
			} catch (InputMismatchException e) {
				System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
				return;
			}
		}

		gym.setVerified(false);

		try {
			gymOwnerBusiness.editGym(gym);
		} catch (GymNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public void getGymDetails(Scanner in, String email) {
		List<Gym> gymDetails = gymOwnerBusiness.getGymDetail(email);
		if (gymDetails.size() == 0) {
			System.out.println(ColorConstants.RED + "Sorry, no gyms found!" + ColorConstants.RESET);
			return;
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"================================================================================================="+ColorConstants.RESET);
		System.out.println();
		System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"%15s%15s%15s%15s%15s%15s", "Gym Id", "Gym Name", "Address", "SlotCount", "SeatsPerSlot", "Verification"+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"================================================================================================="+ColorConstants.RESET);
		gymDetails.forEach(gym -> {
			System.out.println();
			System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getAddress(),
					gym.getSlotCount(), gym.getSeatsPerSlotCount(),
					gym.isVerified() ? ColorConstants.GREEN+"Verified" : ColorConstants.RED+"Not Verified");
		});
		System.out.println();
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"================================================================================================="+ColorConstants.RESET);
	}

	public void addSlot(Scanner in, String email) {
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Slot Details: "+ColorConstants.RESET);
		Slot slot = new Slot();
		slot.setSlotId(IdGenerator.generateId("Slot"));
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Gym Id:"+ColorConstants.RESET);
		slot.setGymId(in.next());
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Slot Date: "+ColorConstants.RESET);
		slot.setDate(in.next());
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Slot Start Time: "+ColorConstants.RESET);
		slot.setStartTime(in.next());
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Slot End Time: "+ColorConstants.RESET);
		slot.setEndTime(in.next());
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter number of seats in slot: "+ColorConstants.RESET);
		try {
			slot.setNumOfSeats(in.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Trainer: "+ColorConstants.RESET);
		slot.setTrainer(in.next());
		slot.setNumOfSeatsBooked(0);

		try {
			gymOwnerBusiness.addSlot(slot, email);
		} catch (GymNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		} catch (UnauthorizedAccessException e) {
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
		}
	}

	public void gymOwnerMenu(Scanner in, String email) throws GymNotFoundException {
		boolean recur = true;
		while (recur) {
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"================================================================================================="+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"\n                                      Actions:"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"================================================================================================="+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"1. View Profile"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"2. Edit Profile"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"3. Add Gym"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"4. Edit Gym"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"5. Add Slot"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"6. View All Gym Details"+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"7. LogOut\n"+ColorConstants.RESET);

			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter Your Choice: "+ColorConstants.RESET);
			int choice = in.nextInt();


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
					addSlot(in, email);
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
				boolean logOutSuccess = userBusiness.logout(gymOwner);
				if (logOutSuccess)
					System.out.println(ColorConstants.GREEN + "Logged Out Successfully!" + ColorConstants.RESET);
				else
					System.out.println(ColorConstants.RED + "Logged Out Successfully!" + ColorConstants.RESET);
			}
		}

	}

}
