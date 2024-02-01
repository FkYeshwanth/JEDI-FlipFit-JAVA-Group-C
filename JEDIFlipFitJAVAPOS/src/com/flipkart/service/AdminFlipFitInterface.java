package com.flipkart.service;

import java.util.List;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * Interface defining operations that an admin can perform in the FlipFit system.
 */
public interface AdminFlipFitInterface {

    /**
     * Returns the list of all gym owners.
     *
     * @return List of GymOwner objects.
     */
    public List<GymOwner> getGymOwners();

    /**
     * Returns the list of all gyms.
     *
     * @return List of Gym objects.
     */
    public List<Gym> getGym();

    /**
     * Returns the list of all gym owners whose requests are pending.
     *
     * @return List of GymOwner objects with pending requests.
     */
    public List<GymOwner> viewAllPendingGymOwnerRequests();

    /**
     * Approves the gym owner request whose email is passed.
     *
     * @param gymOwnerEmail Email of the gym owner to be approved.
     * @return True if the approval is successful, false otherwise.
     */
    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail);

    /**
     * Approves all the pending gym owner requests.
     *
     * @return True if all approvals are successful, false otherwise.
     */
    public boolean approveAllPendingGymOwnerRequests();

    /**
     * Returns the list of all gyms whose requests are pending.
     *
     * @return List of Gym objects with pending requests.
     */
    public List<Gym> viewAllPendingGymRequests();

    /**
     * Approves a single gym request based on the provided gymId.
     *
     * @param gymId ID of the gym to be approved.
     * @return True if the approval is successful, false otherwise.
     */
    public boolean approveSingleGymRequest(String gymId);

    /**
     * Approves all the pending gym requests.
     *
     * @return True if all approvals are successful, false otherwise.
     */
    public boolean approveAllPendingGymRequests();
}

