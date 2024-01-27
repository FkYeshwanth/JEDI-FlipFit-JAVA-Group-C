package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.DAO.*;

public class PersonFlipFitService implements PersonFlipFitInterface {
    GymOwnerDAOImpl gymOwnerDao = new GymOwnerDAOImpl();
    PersonDAOImpl userDao = new PersonDAOImpl();
    /**
     Registers a customer in the system.
     @param customer The Customer object representing the customer data
     */
    public boolean registerCustomer(GymUser customer) {
        boolean registerSuccess = false;
        registerSuccess = userDao.registerCustomer(customer);
        return registerSuccess;
    }
    /**
     Registers a gym owner in the system.
     @param gymOwner The gym owner object representing the gym owner data
     */
    public boolean registerGymOwner(GymOwner gymOwner) {
        boolean registerSuccess = false;
        registerSuccess = userDao.registerGymOwner(gymOwner);
        return registerSuccess;
    }
    /**
     Verifies a user's data.
     @param user The user object representing the user data
     @return true if the user's data are valid else returns false
     */
    public boolean authenticateUser(Person user) {
        boolean authenticateSuccess = false;
        authenticateSuccess = userDao.authenticateUser(user);
        return authenticateSuccess;
    }
    /**
     Logs out a user.
     @param user The User object representing the user data
     @return true if the user is successfully logged out else returns false
     */
    public boolean logout(Person user) {
        return true;
    }
}