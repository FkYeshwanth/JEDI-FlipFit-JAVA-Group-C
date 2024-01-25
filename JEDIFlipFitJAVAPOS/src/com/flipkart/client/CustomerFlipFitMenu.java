package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.GymUser;
import com.flipkart.service.PersonFlipFitService;
import com.flipkart.DAO.PersonDAOImpl;
public class CustomerFlipFitMenu {

	Scanner sc = new Scanner(System.in);
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
