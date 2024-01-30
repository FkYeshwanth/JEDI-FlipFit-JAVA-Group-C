package com.flipkart.client;
import java.text.ParseException;
import java.util.*;
import com.flipkart.bean.GymUser;
import com.flipkart.exception.NoSlotsFoundException;
import com.flipkart.exception.SeatsNotavailableException;
import com.flipkart.service.GymUserFlipFitInterface;
import com.flipkart.DAO.PersonDAOImpl;
import java.text.SimpleDateFormat;
import com.flipkart.constants.*;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymUserFlipFitService;
import com.flipkart.service.PersonFlipFitService;
import com.flipkart.utils.*;

/**
 * This class provides a menu-driven interface for the customers (Gym Users) using the FlipFit application.
 */
public class CustomerFlipFitMenu {
	GymUser customer = new GymUser();
	GymUserFlipFitService customerBusiness = new GymUserFlipFitService();
	Scanner sc = new Scanner(System.in);
	/**
	 * Registers a new gym user by taking user input for email, password, name, phone number, age, and address.
	 * Registers the gym user using the PersonDAOImpl.
	 */

	/*
	public void registerGymUser() {
		//System.out.print("Enter email: ");
		String email=Validation.enter_email();
		customer.setEmail(email);
		//System.out.print("Enter Password: ");
		String pass=Validation.enter_password();
		customer.setPassword(pass);
		//System.out.print("Enter Name: ");
		String name=Validation.enterName();
		customer.setName(name);
		//System.out.print("Enter Phone Number: ");
		String phonenumber=Validation.enter_phone_number();
		customer.setPhoneNumber(phonenumber);
		//System.out.print("Enter Age: ");
		int age= Validation.enter_age();
		customer.setAge(age);
		//System.out.print("Enter Address: ");
		String address=Validation.enter_address();
		customer.setAddress(address);
		PersonFlipFitService userBusiness = new PersonFlipFitService();
		userBusiness.registerCustomer(customer);

		System.out.println("Customer registered successfully!");

	}
	*/

	/**
	 * Displays the list of gyms in Bangalore and their details.
	 */
	public void viewGyms(String email) throws ParseException, NoSlotsFoundException {
		getGyms();
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);


		//List<Slot> slots = customerBusiness.getSlotInGym(gymId);

		try {
			List<Slot> slots = customerBusiness.getSlotInGym(gymId);

			System.out.printf("%15s%15s%15s%15s", "Slot Id", "Start Time", "End Time", "Availability");
			System.out.println();
			slots.forEach(slot -> {
				System.out.printf("%15s%15s%15s%15s", slot.getSlotId(), slot.getStartTime(), slot.getEndTime(), customerBusiness.isSlotBooked(slot.getSlotId(), date)? "WaitingList": "Available");
				System.out.println();
			});
			System.out.println("\n____________________________\n");
			System.out.print("Enter the slot ID which you want to book: ");
			String slotId = sc.next();
			int bookingResponse = customerBusiness.bookSlot(gymId ,slotId , email, dateStr);
			switch (bookingResponse) {
				case 0:
					System.out.println(ColorConstants.RED +"\nYou have already booked this time. \nCancelling the previous one and booking this slot"+ColorConstants.RESET);
					break;
				case 1:
					System.out.println(ColorConstants.GREEN +"\nSlot is already booked, added to the waiting list"+ColorConstants.RESET);
					break;
				case 2:
					System.out.println(ColorConstants.GREEN +"\nSuccessfully booked the slot"+ColorConstants.RESET);
					break;
				default:
					System.out.println(ColorConstants.RED +"\nBooking failed"+ColorConstants.RESET);
			}
		} catch (Exception e) {
			System.out.println(ColorConstants.RED + "No slots found" + ColorConstants.RESET);
		}


//		System.out.printf("| %-10s | %-10s |\n","Slot Id: ","Availability");
//		if(slots!=null){
//
//		for (Slot slot : slots) {
//				System.out.printf("| %-10s | %-10s |\n",slot.getSlotId(),customerBusiness.isSlotBooked(slot.getSlotId(), date));
//			}
//		}

	}

	/**
	 * Allows the user to book a slot for a specified gym, date, and slot.
	 * Displays available slots and prompts the user to enter the slot ID for booking.
	 *
	 * @param email The email of the gym user booking the slot.
	 * @throws ParseException             When there is an error parsing the date.
	 * @throws NoSlotsFoundException       When no slots are found for the specified gym and date.
	 * @throws SeatsNotavailableException When no seats are available for booking in the specified slot.
	 */
	public void bookSlot(String email) throws ParseException, NoSlotsFoundException {
		getGyms();
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);

		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
		//System.out.printf("| %-10s | %-10s |\n","Slot Id: ","Availability");
//		if(slots!=null){
//			for (Slot slot : slots) {
//				System.out.printf("| %-10s | %-10s |\n",slot.getSlotId(),customerBusiness.isSlotBooked(slot.getSlotId(), date));
//			}
//		}
		System.out.print("Enter the slot ID which you want to book: ");
		String slotId = sc.next();
		int bookingResponse = customerBusiness.bookSlot(gymId,slotId, email, String.valueOf(date));
		switch (bookingResponse) {
			case 0:
				System.out.println("You have already booked this time. Cancelling the previous one and booking this slot");
				break;
			case 1:
				System.out.println("Slot is already booked, added to the waiting list");
				break;
			case 2:
				System.out.println("Successfully booked the slot");
				break;
			case 3:
				System.out.println("Slot not found");
				break;
			default:
				System.out.println("Booking failed");
		}
	}

	/**
	 * Allows the user to edit their profile details such as password, name, phone number, age, and address.
	 *
	 * @param email The email of the gym user editing the profile.
	 */
	public void editProfile(String email) {
		System.out.println("==========================================");
		System.out.println("              Edit Profile               ");
		System.out.println("==========================================");
		System.out.println("Want to change password? Yes/No");
		String choice = sc.next();
		GymUser customer = new GymUser();
		try{
			GymUser existingCustomer = customerBusiness.getProfile(email);
			if (existingCustomer != null) {
				// Use existing values as default values
				customer.setEmail(existingCustomer.getEmail());
				customer.setName(existingCustomer.getName());
				customer.setPhoneNumber(existingCustomer.getPhoneNumber());
				customer.setAddress(existingCustomer.getAddress());
				customer.setAge(existingCustomer.getAge());

			}
		}catch (Error e){
			System.out.println("Bad issue");
		}

//        try{
////            GymUser u1 = new GymUser();
//            customer.setPassword();
//        }catch (Error e){
//            System.out.println("Bad issue");
//            return ;
//        }

		if(choice.equals("Yes")){
			System.out.print("Enter Password: ");
			customer.setPassword(sc.next());
		}
		System.out.println("Want to change name? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Name: ");
			customer.setName(sc.next());
		}
		System.out.println("Want to change phone number? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Phone Number: ");
			customer.setPhoneNumber(sc.next());
		}
		System.out.println("Want to change age? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Age: ");
			customer.setAge(Integer.valueOf(sc.next()));
		}
		System.out.println("Want to change address? Yes/No");
		choice = sc.next();
		if(choice.equals("Yes")) {
			System.out.print("Enter Address: ");
			customer.setAddress(sc.next());
		}
		try{
			customerBusiness.editProfile(customer);
		}catch (Error e){
			return ;
		}
		System.out.println("Successfully edited your profile");
	}
	/**
	 * Displays the list of gyms in the user-specified city and their details.
	 */
	public void getGyms() {
		System.out.print("Enter your city: ");
		List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
		System.out.printf("| %-10s | %-20s | %-20s | \n","Gym Id: ","Gym Owner Email: ","Gym Name: ");
		for (Gym gym : gyms) {
			System.out.printf("| %-10s | %-20s | %-20s | \n",gym.getGymId(),gym.getOwnerEmail(),gym.getGymName());
		}
	}
	/**
	 * Displays the list of gyms in Bangalore and their details.
	 */
	public void getGymsInBangalore() {
		List<Gym> gyms = customerBusiness.getGymInCity("Bangalore");
		System.out.printf("| %-10s | %-20s | %-20s | \n","Gym Id: ","Gym Owner Email: ","Gym Name: ");
		for (Gym gym : gyms) {
			System.out.printf("| %-10s | %-20s | %-20s | \n",gym.getGymId(),gym.getOwnerEmail(),gym.getGymName());
		}
	}
	/**
	 * Displays the profile details of the gym user.
	 *
	 * @param email The email of the gym user whose profile is being viewed.
	 */
	public void getProfile(String email) {
		System.out.println("User Profile: ");
//        try {
		customer = customerBusiness.getProfile(email);
//        } catch (CustomerNotFoundException e) {
		// TODO Auto-generated catch block
//            System.out.println(ColorConstants.RED + e.getMessage() + ColorConstants.RESET);
//            return;
//        }
		System.out.println("______________________");
		System.out.printf("%15s%15s%15s%15s", "Customer Name", "Phone Number", "Address", "Age");
		System.out.println();
		System.out.printf("%15s%15s%15s%15s", customer.getName(), customer.getPhoneNumber(), customer.getAddress(),
				customer.getAge());
		System.out.println();
		System.out.println("\n______________________");
//        customerBusiness.viewProfile(email);

	}
	/**
	 * Cancels a booking for a specified gym user and booking ID.
	 *
	 * @param email The email of the gym user canceling the booking.
	 */
	public void cancelBooking(String email) {
		System.out.print("Enter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}
	/**
	 * Displays the main menu for gym users and handles their choices.
	 *
	 * @param email The email of the gym user accessing the menu.
	 * @throws ParseException             When there is an error parsing the date.
	 * @throws NoSlotsFoundException       When no slots are found for the specified gym and date.
	 * @throws SeatsNotavailableException When no seats are available for booking in the specified slot.
	 */
	public void customerMenu(String email) throws ParseException, NoSlotsFoundException, SeatsNotavailableException {
		int choice = 0;
		try{
			while (choice != 8) {
				System.out.println("\u001B[32mMenu:-");
				System.out.println("1.Select Gym in Bangalore \n2.View Available Slots \n3.View Bookings \n4.Book Slot \n5.Cancel Slot \n6.View Profile \n7.Edit Profile \n8.Exit\033[0m");
				System.out.print("\u001B[35mEnter your choice: \033[0m");
				choice = sc.nextInt();

				switch (choice) {
					case 1:
						//viewGyms(email);
						getGymsInBangalore();
						break;
					case 2:
						//
						viewGyms(email);
						break;
					case 3:
						customerBusiness.getBookings(email);
						break;
					case 4:
						bookSlot(email);
						break;
					case 5:
						cancelBooking(email);
						break;
					case 6:
						getProfile(email);
						break;
					case 7:
						editProfile(email);
					case 8:
						break;
					default:
						System.out.println("\u001B[31mInvalid choice!\033[0m");
				}
			}

		}
		catch (InputMismatchException ex){
			System.out.println("Input mismatch" +
					"");
		}



	}
	/**
	 * Registers a new gym user by taking user input for email, password, name, phone number, age, and address.
	 * Registers the gym user using the PersonFlipFitService.
	 */
	public void registerCustomer() {
		GymUser customer = new GymUser();
		//System.out.print("\u001B[36mEnter email: ");
		String email=Validation.enter_email();
		//String email =sc.next();
		customer.setEmail(email);
		//System.out.print("Enter password: ");
		String pass=Validation.enter_password();
		//String password =sc.next();
		customer.setPassword(pass);
		//System.out.print("Enter Name: ");
		String name=Validation.enterName();
		//String name=sc.next();
		customer.setName(name);
		//System.out.print("Enter Phone Number: ");
		String phonenumber=Validation.enter_phone_number();
		//String number=sc.next();
		customer.setPhoneNumber(phonenumber);

		//System.out.print("Enter Age: ");
		int age= Validation.enter_age();
		//int age= sc.nextInt();
		customer.setAge(age);
		//System.out.print("Enter Address: \033[0m");
		String address=Validation.enter_address();
		//String address=sc.next();
		customer.setAddress(address);
//		UserBusiness userBusiness = new UserBusiness();
		//	PersonFlipFitService temp = new PersonFlipFitService();
		//	temp.registerCustomer(customer);
		PersonDAOImpl personDAOImpl = new PersonDAOImpl();
		personDAOImpl.registerCustomer(customer);

		System.out.println("\u001B[32mCustomer registered successfully!\033[0m");


	}



}
