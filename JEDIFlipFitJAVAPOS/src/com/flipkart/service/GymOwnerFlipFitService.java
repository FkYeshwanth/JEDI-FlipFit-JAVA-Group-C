/**
 * Service class providing functionality for gym owner operations in the FlipFit system.
 */
package com.flipkart.service;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotApprovedExceptions;
import com.flipkart.exception.GymOwnerNotFoundException;

import java.util.List;

/**
 * Service class providing functionality for gym owner operations in the FlipFit system.
 */
public class GymOwnerFlipFitService implements GymOwnerFlipFitInterface {
    // Instance of GymOwnerDAOImpl to interact with the data layer
    GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();

    /**
     * Retrieves gym owner's profile details.
     *
     * @param email The email of the gym owner whose profile details are requested.
     * @return GymOwner object representing the gym owner's profile.
     */
    public GymOwner getProfile(String email) {
        System.out.println(ColorConstants.GREEN + "Fetched Gym owner details successfully! " + email + ColorConstants.RESET);
        GymOwner gymOwner = null;
        try {
            gymOwner = gymOwnerDAO.getGymOwnerDetails(email);
        } catch (GymOwnerNotFoundException ex) {
            System.out.println("There is no gym owners available");
        }
        return gymOwner;
    }

    /**
     * Allows the gym owner to update their profile.
     *
     * @param gymOwnerOld Original GymOwner object representing the current profile.
     * @param gymOwnerNew Updated GymOwner object with the new profile information.
     */
    public void editProfile(GymOwner gymOwnerOld, GymOwner gymOwnerNew) {
        gymOwnerDAO.editGymOwnerDetails(gymOwnerOld, gymOwnerNew);
        System.out.println(ColorConstants.GREEN + "\nEdited your profile Successfully!" + ColorConstants.RESET);
    }

    /**
     * Allows a gym owner to add details of a particular gym.
     *
     * @param gym Gym object representing the gym details.
     * @return True if the addition is successful, false otherwise.
     */
    public boolean addGym(Gym gym) {
        gymOwnerDAO.addGym(gym);
        System.out.println(ColorConstants.GREEN + "\nAdded Gym Successfully!" + gym.getGymId() + ColorConstants.RESET);
        return true;
    }

    /**
     * Allows a gym owner to edit details of a particular gym.
     *
     * @param gym Gym object representing the gym details.
     */
    public void editGym(Gym gym) {
        gymOwnerDAO.editGym(gym);
        System.out.println(ColorConstants.GREEN + "\nEdited Gym Details Successfully! " + gym.getGymId() + ColorConstants.RESET);
    }

    /**
     * Retrieves all the gyms owned by the given gym owner.
     *
     * @param gymOwnerEmail The gym owner's email for which the list of gyms is requested.
     * @return List of gyms owned by the given gym owner.
     */
    public List<Gym> getGymDetail(String gymOwnerEmail) {
        System.out.println(ColorConstants.GREEN +"\nFetched gym details successfully! " + gymOwnerEmail+ ColorConstants.RESET);
        List<Gym> gymList=null;
        try{
            gymList=gymOwnerDAO.getGymsOfGymOwner(gymOwnerEmail);
        }catch (GymNotFoundException ex){
            System.out.println("There is no gyms found");
        }
        return gymList;
    }

    /**
     * Allows a gym owner to add details of a slot.
     *
     * @param slot Slot object representing the slot details.
     */
    public void addSlot(Slot slot) {
        gymOwnerDAO.addSlot(slot);
        System.out.println(ColorConstants.GREEN + "\nAdded slot successfully!" + ColorConstants.RESET);
    }

    /**
     * Checks if the gym owner is verified or not.
     *
     * @param email The gym owner's email.
     * @return True if the gym owner is verified, false otherwise.
     */
    public boolean isApproved(String email) {
        return gymOwnerDAO.checkOwnerApproval(email);
    }

    /**
     * Checks if the gym is verified or not.
     *
     * @param gymId The gym id for which the verification status is requested.
     * @return True if the gym is verified, false otherwise.
     */
    public boolean isGymApproved(String gymId) {
        boolean approved = false;
        try {
            approved = gymOwnerDAO.checkGymApproval(gymId);
        } catch (GymOwnerNotApprovedExceptions ex) {
            System.out.println("Gym owner not approved");
        }
        return approved;
    }
}
