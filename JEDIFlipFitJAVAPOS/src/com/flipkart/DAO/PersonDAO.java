package com.flipkart.DAO;

import com.flipkart.bean.GymUser;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Person;

import java.util.HashMap;

public interface PersonDAO {
    public boolean authenticatePerson(Person person);

    public boolean registerCustomer(GymUser gymUser);

    public boolean registerGymOwner(GymOwner gymOwner);

    //public void updatePassword(Person person);
}