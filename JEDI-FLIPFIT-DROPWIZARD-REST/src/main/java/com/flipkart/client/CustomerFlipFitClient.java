package com.flipkart.client;

import com.flipkart.DAO.UserFlipFitDAOImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.SlotNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.service.CustomerFlipFitServiceImpl;
import com.flipkart.service.UserFlipFitServiceImpl;
import com.flipkart.validator.DateFlipfitValidator;
import com.flipkart.validator.EmailFlipfitValidator;
import com.flipkart.validator.LengthFlipfitValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.constants.ColorConstants.CYAN;

public class CustomerFlipFitClient {

	Customer customer = new Customer();
	CustomerFlipFitServiceImpl customerBusiness = new CustomerFlipFitServiceImpl();
	Scanner sc = new Scanner(System.in);

	public void registerCustomer() throws UserAlreadyExistsException {
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                CUSTOMER REGISTRATION             "+ColorConstants.RESET);
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		String email="",phoneNo="";
		boolean isEmailCorrect=false;
		while(isEmailCorrect==false){
			System.out.print("Enter Email: ");
			email = sc.next();
			isEmailCorrect = EmailFlipfitValidator.isEmailCorrect(email);
		}
		customer.setEmail(email);
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter password: "+ColorConstants.RESET);
		customer.setPassword(sc.next());
		customer.setRoleId("Customer");
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Name: "+ColorConstants.RESET);
		customer.setName(sc.next());
		while(!LengthFlipfitValidator.isLengthCorrect(phoneNo,10)){
			if(!phoneNo.isEmpty())System.out.println("Invalid Phone number");
			System.out.println("Enter Phone Number");
			phoneNo = sc.next();
		}
		customer.setPhoneNumber(phoneNo);
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Age: "+ColorConstants.RESET);
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Address: "+ColorConstants.RESET);
		customer.setAddress(sc.next());
		UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();
		userBusiness.registerCustomer(customer);

		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.GREEN+"Customer registered successfully!"+ColorConstants.RESET);

	}


//	public void viewProfile(Scanner in, String email) {
//		try {
//			customer = CustomerFlipFitServiceImpl.getProfile(email);
//		} catch (GymOwnerNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
//			return;
//		}
//		System.out.println("______________________________________________________________");
//		System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
//		System.out.println();
//		System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNumber(), gymOwner.getPanNumber(),
//				gymOwner.getAadharNumber());
//		System.out.println();
//		System.out.println("\n______________________________________________________________");
//	}

	public void getProfile(Scanner in, String email) {
		try {
			customer = customerBusiness.getProfile(email);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
			return;
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=========================================================================="+ColorConstants.RESET);
		System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"%15s%15s%15s%15s", "Customer Name", "Phone Number", "Address", "Age"+ColorConstants.RESET);
		System.out.println();
		System.out.printf(ColorConstants.BOLD_TEXT+ CYAN +"%15s%15s%15s%15s", customer.getName(), customer.getPhoneNumber(), customer.getAddress(),
				customer.getAge()+ColorConstants.RESET);
		System.out.println();
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=========================================================================="+ColorConstants.RESET);
//		n______________________");
	}



	public void viewGyms(String email) throws ParseException, SlotNotFoundException {
		getGyms();
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Gym ID: "+ColorConstants.RESET);
		String gymId = sc.next();
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Date (yyyy-mm-dd): "+ColorConstants.RESET);
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);

		if (DateFlipfitValidator.isValidFutureDate(dateStr)) {
			System.out.println(ColorConstants.BOLD_TEXT+ CYAN +"The entered date is valid."+ColorConstants.RESET);
		} else {
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Invalid date."+ColorConstants.BOLD_TEXT+ CYAN +" Please enter today's date or a future date."+ColorConstants.RESET);
		}

//		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
//		for (Slot slot : slots) {
//			System.out.print("Slot Id: " + slot.getSlotId());
//			System.out.print("Availability: " + customerBusiness.isSlotBooked(slot.getSlotId(), String.valueOf(date)));
//		}
		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
		slots.forEach(slot -> {
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Slot Id: " + slot.getSlotId()+ColorConstants.RESET);
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Availability: " + customerBusiness.isSlotBooked(slot.getSlotId(), String.valueOf(date))+ColorConstants.RESET);
			System.out.println(); // Add a newline for better readability between slots
		});

		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter the slot ID which you want to book: "+ColorConstants.RESET);
		String slotId = sc.next();
		int bookingResponse = customerBusiness.bookSlot(gymId,slotId, email, String.valueOf(date));
		switch (bookingResponse) {
			case 0:
				System.out.println(ColorConstants.BOLD_TEXT+ CYAN +"You have already booked this time. Cancelling the previous one and booking this slot"+ColorConstants.RESET);
				break;
			case 1:
				System.out.println(ColorConstants.BOLD_TEXT+ CYAN +"Slot is already booked, added to the waiting list"+ColorConstants.RESET);
				break;
			case 2:
				System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.GREEN+"Successfully booked the slot"+ColorConstants.RESET);
				break;
			case 3:
				System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Slot not found"+ColorConstants.RESET);
				break;
			default:
				System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Booking failed"+ColorConstants.RESET);
		}
	}

	public void editProfile(String email) throws CustomerNotFoundException {
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                EDIT PROFILE             "+ColorConstants.RESET);
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ CYAN +"Want to change password? Yes/No"+ColorConstants.RESET);
		String choice = sc.next();
		Customer customer = new Customer();
		try{
			Customer existingCustomer = customerBusiness.getProfile(email);
			if (existingCustomer != null) {
				// Use existing values as default values
				customer.setEmail(existingCustomer.getEmail());
				customer.setName(existingCustomer.getName());
				customer.setPhoneNumber(existingCustomer.getPhoneNumber());
				customer.setAddress(existingCustomer.getAddress());
				customer.setAge(existingCustomer.getAge());

			}
		}catch (Error e){
			System.out.println(ColorConstants.RED+"Bad issue"+ColorConstants.RESET);
		}

		try{
			UserFlipFitDAOImpl u1 = new UserFlipFitDAOImpl();
			customer.setPassword(u1.getPassword(customer.getEmail()));
		}catch (Error e){
			System.out.println(ColorConstants.RED+"Bad issue"+ColorConstants.RESET);
			return ;
		}

		if(choice.equals("Yes")){
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Password: "+ColorConstants.RESET);
			customer.setPassword(sc.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ CYAN +"Want to change name? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Name: ");
			customer.setName(sc.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"Want to change phone number? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN+"Enter Phone Number: "+ColorConstants.RESET);
			customer.setPhoneNumber(sc.next());
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"Want to change age? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Age: "+ColorConstants.RESET);
			customer.setAge(Integer.valueOf(sc.next()));
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"Want to change address? Yes/No"+ColorConstants.RESET);
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter Address: "+ColorConstants.RESET);
			customer.setAddress(sc.next());
		}
		try{
			customerBusiness.editProfile(customer);
		}catch (Error e){
			return ;
		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.GREEN+"Successfully edited your profile"+ColorConstants.RESET);
	}

	public void getGyms() {
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter your city: "+ColorConstants.RESET);
		List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=========================================================================="+ColorConstants.RESET);
		System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"%15s%20s%15s", "Gym Id", "Gym Owner Email", "Gym Name"+ColorConstants.RESET);
		System.out.println();
//		for (Gym gym : gyms) {
//			System.out.printf("%15s%20s%15s", gym.getGymId(), gym.getOwnerEmail(),gym.getGymName() );
//			System.out.println();
//			System.out.println("==========================================================================");
//			System.out.println();
//		}
		gyms.forEach(gym -> {
			System.out.printf(ColorConstants.BOLD_TEXT+ CYAN +"%15s%20s%15s", gym.getGymId(), gym.getOwnerEmail(), gym.getGymName()+ColorConstants.RESET);
			System.out.println();
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=========================================================================="+ColorConstants.RESET);
			System.out.println();
		});

		System.out.println();
	}



	public void cancelBooking(String email) {
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                CANCEL BOOKING             "+ColorConstants.RESET);
		System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
		System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter booking ID that you want to cancel: "+ColorConstants.RESET);
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}

	public void customerMenu(String email) throws ParseException, SlotNotFoundException, CustomerNotFoundException {
		int choice = 0;

		while (choice != 6) {
			System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                MENU             "+ColorConstants.RESET);
			System.out.println(ColorConstants.BLUE+"============================================="+ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"1.View Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4.Edit Profile \n5.View Profile \n6.Exit"+ColorConstants.RESET);
			System.out.print(ColorConstants.BOLD_TEXT+ CYAN +"Enter your choice: "+ColorConstants.RESET);
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					viewGyms(email);
					break;
				case 2:
					customerBusiness.getBookings(email);
					break;
				case 3:
					cancelBooking(email);
					break;
				case 4:
					editProfile(email);
					break;
				case 5:
					getProfile(sc,email);
				case 6:
					break;
				default:
					System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Invalid choice!"+ColorConstants.RESET);
			}
		}
	}
}