package com.flipkart.client;
import java.text.ParseException;
import java.util.*;
import com.flipkart.bean.GymUser;
import com.flipkart.service.GymUserFlipFitInterface;
import com.flipkart.DAO.PersonDAOImpl;
import java.text.SimpleDateFormat;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymUserFlipFitService;
import com.flipkart.service.PersonFlipFitService;

public class CustomerFlipFitMenu {
	GymUser customer = new GymUser();
	GymUserFlipFitService customerBusiness = new GymUserFlipFitService();
	Scanner sc = new Scanner(System.in);
	public void registerGymUser() {
		System.out.print("Enter email: ");
		customer.setName(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		PersonFlipFitService userBusiness = new PersonFlipFitService();
		userBusiness.registerCustomer(customer);

		System.out.println("Customer registered successfully!");

	}

	public void viewGyms(String email) throws ParseException {
		getGyms();
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("Enter Date (yyyy-mm-dd): ");
		String dateStr = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateStr);

		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
		for (Slot slot : slots) {
			System.out.print("Slot Id: " + slot.getSlotId());
			System.out.print("Availability: " + customerBusiness.isSlotBooked(slot.getSlotId(), date));
		}
		System.out.print("Enter the slot ID which you want to book: ");
		String slotId = sc.next();
		int bookingResponse = customerBusiness.bookSlot(gymId,slotId, email, date);
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

	public void editProfile(String email) {
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNumber(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		System.out.println("Successfully edited your profile");
	}

	public void getGyms() {
		System.out.print("Enter your city: ");
		List<Gym> gyms = customerBusiness.getGymInCity(sc.next());
		for (Gym gym : gyms) {
			System.out.print("Gym Id: " + gym.getGymId());
			System.out.print("Gym Owner Email: " + gym.getOwnerEmail());
			System.out.print("Gym Name: " + gym.getGymName());
			System.out.println();
		}
	}

	public void cancelBooking(String email) {
		System.out.print("Enter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}
	public void customerMenu(String email) {
		int choice = 0;

		while (choice != 8) {
			System.out.println("\u001B[32mMenu:-");
			System.out.println("1.Select Gym in Bangalore \n2.View Available Slots \n3.View Bookings \n4.Book Slot \n5.Cancel Slot \n6.View Profile \n7.Edit Profile \n8.Exit\033[0m");
			System.out.print("\u001B[35mEnter your choice: \033[0m");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
//					viewGyms(email);
					break;
				case 2:
//					viewAvailableSlots();
					break;
				case 3:
//					customerBusiness.getBookings(email);
					break;
				case 4:
//					bookSlot();
					break;
				case 5:
//					cancelBooking(email);
					break;
				case 6:
//					viewProfile(email)
					break;
				case 7:
//					editProfile(email);
				case 8:
					break;
				default:
					System.out.println("\u001B[31mInvalid choice!\033[0m");
			}
		}

	}

	public void registerCustomer() {
		GymUser customer = new GymUser();
		System.out.print("\u001B[36mEnter email: ");
		String email =sc.next();
		customer.setEmail(email);
		System.out.print("Enter password: ");
		String password =sc.next();
		customer.setPassword(password);
		System.out.print("Enter Name: ");
		String name=sc.next();
		customer.setName(name);
		System.out.print("Enter Phone Number: ");
		String number=sc.next();
		customer.setPhoneNumber(number);
		System.out.print("Enter Age: ");
		int age= sc.nextInt();
		customer.setAge(age);
		System.out.print("Enter Address: \033[0m");
		String address=sc.next();
		customer.setAddress(address);
//		UserBusiness userBusiness = new UserBusiness();
	//	PersonFlipFitService temp = new PersonFlipFitService();
	//	temp.registerCustomer(customer);
		PersonDAOImpl personDAOImpl = new PersonDAOImpl();
		personDAOImpl.registerCustomer(customer);

		System.out.println("\u001B[32mCustomer registered successfully!\033[0m");


	}



}
