package com.flipkart.DAO;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.NoPendingGymOwnerRequest;
import com.flipkart.exception.NoPendingGymRequest;

public interface AdminDAO {
    public List<GymOwner> getAllGymOwners() throws GymOwnerNotFoundException;

    public List<Gym> getAllGyms() throws GymNotFoundException;

    public List<GymOwner> getPendingGymOwnerRequests() throws NoPendingGymOwnerRequest;

    public List<Gym> getPendingGymRequests() throws NoPendingGymRequest;

    public void approveSingleOwnerRequest(String gymOwnerEmail);

    public void approveAllOwnerRequest();

    public void approveSingleGymRequest(String gymId);

    public void approveAllGymRequest();
}
