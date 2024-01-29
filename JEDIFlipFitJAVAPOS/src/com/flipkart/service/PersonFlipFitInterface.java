package com.flipkart.service;

import com.flipkart.bean.*;

public interface PersonFlipFitInterface {

//    public boolean authenticatePerson(Person p);

    public boolean registerCustomer(GymUser customer);

    public boolean registerGymOwner(GymOwner gymOwner);

    public boolean authenticatePerson(Person user);

    public boolean logout(Person user);

}
