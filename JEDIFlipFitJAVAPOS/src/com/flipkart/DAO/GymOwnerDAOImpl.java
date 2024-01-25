package com.flipkart.DAO;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GymOwnerDAOImpl implements GymOwnerDAO{

    public static HashMap<String, GymOwner> gymOwnerHash = new HashMap<String, GymOwner>();

    public void addGymOwnerDetails(String name, String email, String password, String phoneNum,String pan,String aadhar){
        GymOwner gymOwner = new GymOwner(email,password, "GymOwner", name,phoneNum,aadhar,pan);
        gymOwnerHash.put(email,gymOwner);
        System.out.println("The name of the gymOwner is  "+ gymOwnerHash.get(email).getName());
        System.out.println("Initial size is "+ gymOwnerHash.size());
    }

    public GymOwner getGymOwnerDetails(String gymOwnerEmail){
        if(!gymOwnerHash.isEmpty()){
            return gymOwnerHash.get(gymOwnerEmail);
        }
        return null;

    }

    @Override
    public void addGymOwnerDetails(GymOwner gymOwnerDetails) {

    }

    @Override
    public void editGymOwnerDetails(GymOwner gymOwnerDetails) {


    }

    @Override
    public Gym getGym(String gymId) {
        return null;
    }

    @Override
    public void addGym(Gym gymDetails) {

    }

    @Override
    public void editGym(Gym gymDetails) {

    }

    @Override
    public List<Gym> getGymsOfGymOwner(String gymOwnerId) {
        return null;
    }

    @Override
    public List<Slot> getPossibleSlots(String gymId) {
        return null;
    }

    @Override
    public void addSlot(Slot slot) {

    }

    @Override
    public boolean checkOwnerApproval(String email) {
        return false;
    }

    @Override
    public boolean checkGymApproval(String gymId) {
        return false;
    }

}
