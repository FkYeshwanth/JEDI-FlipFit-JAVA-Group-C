package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotApprovedExceptions;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.NoSlotsFoundException;

public interface GymOwnerDAO {
    public GymOwner getGymOwnerDetails(String gymOwnerEmailId) throws GymOwnerNotFoundException;

    public void addGymOwnerDetails(GymOwner gymOwnerDetails);

    public void editGymOwnerDetails(GymOwner gymOwnerDetails,GymOwner gymOwnerDetailsNew);

    public Gym getGym(String gymId) throws GymNotFoundException;

    public void addGym(Gym gymDetails);

    public void editGym(Gym gymDetails);

    public List<Gym> getGymsOfGymOwner(String gymOwnerId) throws GymNotFoundException;

    public List<Slot> getPossibleSlots(String gymId) throws NoSlotsFoundException;

    public void addSlot(Slot slot);

    public boolean checkOwnerApproval(String email) ;

    public boolean checkGymApproval(String gymId) throws GymOwnerNotApprovedExceptions;
}