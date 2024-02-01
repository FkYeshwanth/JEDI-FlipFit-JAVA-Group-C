package com.flipkart.service;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.util.List;

/**
 * Interface defining operations that a gym owner can perform in the FlipFit system.
 */
public interface GymOwnerFlipFitInterface {

    /**
     * Retrieves the profile of the gym owner associated with the provided email.
     *
     * @param email The email of the gym owner.
     * @return GymOwner object representing the gym owner's profile.
     */
    public GymOwner getProfile(String email);

    /**
     * Allows the gym owner to edit their profile.
     *
     * @param gymOwnerOlds Original GymOwner object representing the current profile.
     * @param gymOwnerNews Updated GymOwner object with the new profile information.
     */
    public void editProfile(GymOwner gymOwnerOlds, GymOwner gymOwnerNews);

    /**
     * Allows the gym owner to add a new gym.
     *
     * @param gym Gym object representing the new gym to be added.
     * @return True if the addition is successful, false otherwise.
     */
    public boolean addGym(Gym gym);

    /**
     * Allows the gym owner to edit the information of an existing gym.
     *
     * @param gym Gym object representing the updated information for the gym.
     */
    public void editGym(Gym gym);

    /**
     * Retrieves the details of all gyms owned by the gym owner associated with the provided email.
     *
     * @param gymOwnerEmail The email of the gym owner.
     * @return List of Gym objects representing all gyms owned by the gym owner.
     */
    public List<Gym> getGymDetail(String gymOwnerEmail);

    /**
     * Checks if the gym owner associated with the provided email is approved.
     *
     * @param email The email of the gym owner.
     * @return True if the gym owner is approved, false otherwise.
     */
    public boolean isApproved(String email);

    /**
     * Checks if the gym associated with the provided gymId is approved.
     *
     * @param gymId The ID of the gym.
     * @return True if the gym is approved, false otherwise.
     */
    public boolean isGymApproved(String gymId);
}
