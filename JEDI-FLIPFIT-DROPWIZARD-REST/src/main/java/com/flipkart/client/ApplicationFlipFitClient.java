package com.flipkart.client;

import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserFlipFitServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.flipkart.constants.ColorConstants.*;

public class ApplicationFlipFitClient {

	public static void login() throws Exception {
		Scanner in = new Scanner(System.in);

		LocalDateTime currentDateTime = LocalDateTime.now();

		// Format the date and time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		System.out.println(BLUE +"============================================="+ RESET);
		System.out.println(BOLD_TEXT + YELLOW +"               LOGIN DETAILS                   "+ RESET);
		System.out.println(BLUE +"============================================="+ RESET);
		System.out.print(BOLD_TEXT + CYAN +"Enter Email: "+ RESET);
		String userEmail = in.next();
		System.out.print(BOLD_TEXT + CYAN +"Enter Password: "+ RESET);
		String password = in.next();
		System.out.print(BOLD_TEXT + CYAN +"Enter Role ID: "+ BOLD_TEXT + BLUE +"1. Customer 2. Gym Owner 3. Gym Administrator "+ RESET);
		String roleCode = in.next();
		String roleId = "Admin";
		if (roleCode.equals("1")) // tokenizing the role id
		{
			roleId = "Customer";
		}
		else if (roleCode.equals("2")) {
			roleId = "GymOwner";
		}
		else if(roleCode.equals("3"))
		{
			roleId = "Admin";
		}
		else
		{
			System.out.println(BOLD_TEXT + RED + "Wrong Selection"+ RESET);
			return;
//			throw InvalidInputException("Exiting");
		}
		User user = new User(userEmail, password, roleId);
		UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();
		if (roleId.equalsIgnoreCase("Admin")) {
			AdminFlipFitClient admin = new AdminFlipFitClient();
			admin.adminMenu(in);
			return;
		}
		try {
			userBusiness.authenticateUser(user);
			System.out.println(BLUE +"============================================="+ RESET);
			System.out.println(
					GREEN + "Welcome " + userEmail + "! You are logged in. " + "(" + formattedDateTime + ")"
							+ RESET);

			if (roleId.equalsIgnoreCase("Customer")) {

				CustomerFlipFitClient customer = new CustomerFlipFitClient();
				customer.customerMenu(userEmail);

			} else if (roleId.equalsIgnoreCase("GymOwner")) {

				GymOwnerFlipFitClient gymOwner = new GymOwnerFlipFitClient();
				gymOwner.gymOwnerMenu(in, userEmail);

			} else {
				System.out.println(RED + "Wrong Choice!" + RESET);
			}
		} catch (UserNotFoundException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
	}

	public static void applicationMenu() throws Exception {
		boolean recur = true;

		int choice = 0;
		while (choice != 4){
			System.out.println(WELCOME_MESSAGE);
			System.out.println(BLUE +"============================================="+ RESET);
			System.out.println(BOLD_TEXT + YELLOW + "\tWELCOME TO THE FLIPFIT APPLICATION!" + RESET);
			System.out.println(BLUE +"============================================="+ RESET);
			System.out.println(BOLD_TEXT + CYAN +"\nChoose your action:"+ RESET);
			System.out.println();
			System.out.println(BOLD_TEXT + BLUE +"1. Login"+ RESET);
			System.out.println(BOLD_TEXT + BLUE +"2. Customer Registration"+ RESET);
			System.out.println(BOLD_TEXT + BLUE +"3. Gym Owner Registration"+ RESET);
			System.out.println(BOLD_TEXT + BLUE +"4. Exit"+ RESET);
			System.out.print(BOLD_TEXT + CYAN+"\nEnter Your Choice: "+ RESET);

			Scanner in = new Scanner(System.in);

			choice = in.nextInt();
			in.nextLine();
			switch (choice) {
				case 1:
					login();
					break;
				case 2:
					CustomerFlipFitClient customer = new CustomerFlipFitClient();
					customer.registerCustomer();
					login();
					break;
				case 3:
					GymOwnerFlipFitClient owner = new GymOwnerFlipFitClient();
					owner.gymOwnerRegistration(in);
					login();
					break;
				case 4:
					System.out.println(RED + "Exiting..." + RESET);
					System.out.println(GREEN + "Exited Successfully" + RESET);
					recur = false;
					System.exit(0);
					break;
				default:
					System.out.println(RED + "Wrong Choice!" + RESET);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		applicationMenu();
	}

}