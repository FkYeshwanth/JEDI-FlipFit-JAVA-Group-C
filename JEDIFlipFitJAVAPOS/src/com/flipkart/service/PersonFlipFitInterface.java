package com.flipkart.service;

import com.flipkart.bean.*;

public interface PersonFlipFitInterface {

//    public boolean authenticatePerson(Person p);
    /*
   Registers a new customer
   @return boolean value indicating success of registration
   */
    public boolean registerCustomer(GymUser customer);

    /*
    Registers a new Gym Owner
    @return boolean value indicating success of registration
    */
    public boolean registerGymOwner(GymOwner gymOwner);

    /*
    Authenticates a user
    @return boolean value indicating if user is authenticated
    */
    public boolean authenticatePerson(Person user);

    /*
    Logs out a user
    @return boolean value indicating success of logout
    */
    public boolean logout(Person user);

}
