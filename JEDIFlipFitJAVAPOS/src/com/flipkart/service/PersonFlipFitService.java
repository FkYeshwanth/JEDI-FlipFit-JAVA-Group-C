package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.DAO.*;

public class PersonFlipFitService {
    public boolean authenticatePerson(Person p) {
        return true;
    }
    public boolean registerCustomer(GymUser customer) {
        boolean registerSuccess = false;
        PersonDAOImpl temp = new PersonDAOImpl();
        registerSuccess = temp.registerCustomer(customer);
        return registerSuccess;
    }
}