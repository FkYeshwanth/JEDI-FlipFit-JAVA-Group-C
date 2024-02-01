package com.flipkart.client;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.ColorConstants;
import com.flipkart.service.AdminFlipFitServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 
 */

public class AdminFlipFitClient {

	AdminFlipFitServiceImpl adminBusiness = new AdminFlipFitServiceImpl();
	List<GymOwner> gymOwnerList = adminBusiness.getGymOwners();
	List<Gym> gymList = adminBusiness.getGym();
	Scanner sc = new Scanner(System.in);
	
	public void viewAllPendingGymOwnerRequests() {

		viewAllGymOwners(adminBusiness.viewAllPendingGymOwnerRequests());
	}
	public void viewAllPendingGymRequests() {

		viewAllGyms(adminBusiness.viewAllPendingGymRequests());
	}

	public void approveSingleGymOwnerRequest() {
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter the email to approve: "+ColorConstants.RESET);
		adminBusiness.approveSingleGymOwnerRequest(sc.next());
	}

	public void approveSingleGymRequest() {
		System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter gym Id to approve: "+ColorConstants.RESET);
		adminBusiness.approveSingleGymRequest(sc.next());
	}

	public void approvePendingGymOwnerRequests() {
		adminBusiness.approveAllPendingGymOwnerRequests();
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.GREEN+"All pending gym owner requests approved successfully."+ColorConstants.RESET);
	}

	public void approvePendingGymRequests() {
		adminBusiness.approveAllPendingGymRequests();
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.GREEN+"All pending gym requests approved successfully."+ColorConstants.RESET);
	}

	public void adminMenu(Scanner in) throws Exception {
		System.out.println("================= Admin FlipFit =================");
		while (true) {
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"1. View All Gyms \n 2. View All Gym Owners \n 3. View All Pending Gym Owner Requests \n 4. View All Pending Gym Requests \n 5. Approve All Pending Gym Owner Requests \n 6. Approve All Pending Gym Requests \n 7. Approve Single Gym Owner Request \n 8. Approve Single Gym Request \n 9. Exit"+ColorConstants.RESET);

			System.out.print(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Enter your choice: "+ColorConstants.RESET);
			int choice = in.nextInt();
			switch (choice) {
				// Case statements
				case 1:
					viewAllGyms(gymList);
					break;
				case 2:
					viewAllGymOwners(gymOwnerList);
					break;
				case 3:
					viewAllPendingGymOwnerRequests();
					break;
				case 4:
					viewAllPendingGymRequests();
					break;
				case 5:
					approvePendingGymOwnerRequests();
					break;
				case 6:
					approvePendingGymRequests();
					break;
				case 7:
					approveSingleGymOwnerRequest();
					break;
				case 8:
					approveSingleGymRequest();
					break;
				case 9:
					System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.GREEN+"Exiting Admin FlipFit. Goodbye!"+ColorConstants.RESET);
					return;
				// Default case statement
				default:
					System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.RED+"Invalid choice. " +
							ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Please enter a valid option."+ColorConstants.RESET);
			}
		}
	}

	public void viewAllGyms(List<Gym> gyms) {
//		System.out.println("========================================== All Gyms ==========================================");
//		for (Gym gym : gyms) {
//			System.out.printf("%15s%15s%15s%15s%15s%15s","Gym ID", "Name", "Owner Email", "Address", "Slot Count", "Verification");
//			System.out.println();
//			System.out.printf("%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(), gym.getAddress(), gym.getSlotCount(), (gym.isVerified() ? "Approved" : "Pending"));
//			System.out.println();
//			System.out.println("==============================================================================================");
//		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=============================================================================================="+ ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                                         ALL GYMS                                             "+ ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=============================================================================================="+ ColorConstants.RESET);
		gyms.forEach(gym -> {
			System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"%15s%15s%15s%15s%15s%15s", "Gym ID", "Name", "Owner Email", "Address", "Slot Count", "Verification"+ ColorConstants.RESET);
			System.out.println();
			System.out.printf(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"%15s%15s%15s%15s%15s%15s", gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(), gym.getAddress(), gym.getSlotCount(), (gym.isVerified() ? ColorConstants.GREEN+"Approved" : ColorConstants.RED+"Pending")+ ColorConstants.RESET);
			System.out.println();
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=============================================================================================="+ ColorConstants.RESET);
		});
	}

	public void viewAllGymOwners(List<GymOwner> gymOwners) {
//		System.out.println("================= All Gym Owners =================");
//		for (GymOwner gymOwner : gymOwners) {
//			System.out.println("Name: " + gymOwner.getName());
//			System.out.println("Phone Number: " + gymOwner.getPhoneNumber());
//			System.out.println("Aadhar Number: " + gymOwner.getAadharNumber());
//			System.out.println("PAN Number: " + gymOwner.getPanNumber());
//			System.out.println("Verification: " + (gymOwner.isVerified() ? "Approved" : "Pending"));
//			System.out.println("===================================================");
//		}
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=============================================================================================="+ ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.YELLOW+"                                         ALL GYM OWNERS                                           "+ ColorConstants.RESET);
		System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=============================================================================================="+ ColorConstants.RESET);
		gymOwners.forEach(gymOwner -> {
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Name: " + gymOwner.getName()+ ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Phone Number: " + gymOwner.getPhoneNumber()+ ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Aadhar Number: " + gymOwner.getAadharNumber()+ ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"PAN Number: " + gymOwner.getPanNumber()+ ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.CYAN+"Verification: " + (gymOwner.isVerified() ? ColorConstants.GREEN+"Approved" : ColorConstants.RED+"Pending")+ ColorConstants.RESET);
			System.out.println(ColorConstants.BOLD_TEXT+ ColorConstants.BLUE+"=============================================================================================="+ ColorConstants.RESET);
		});
	}
}
