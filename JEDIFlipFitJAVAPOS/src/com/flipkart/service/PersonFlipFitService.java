/**
 *
 */
package com.flipkart.service;

import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.DAO.PersonDAOImpl;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Person;

/**
 *
 */
public class PersonFlipFitService implements PersonFlipFitInterface{

    GymOwnerDAOImpl gymOwnerDao = new GymOwnerDAOImpl();
    PersonDAOImpl PersonDao = new PersonDAOImpl();
    /**
     Registers a customer in the system.
     @param customer The Customer object representing the customer data
     */
    public boolean registerCustomer(GymUser customer) {
        boolean registerSuccess = false;
        registerSuccess = PersonDao.registerCustomer(customer);
        return registerSuccess;
    }
    /**
     Registers a gym owner in the system.
     @param gymOwner The gym owner object representing the gym owner data
     */
    public boolean registerGymOwner(GymOwner gymOwner) {
        boolean registerSuccess = false;
        registerSuccess = PersonDao.registerGymOwner(gymOwner);
        return registerSuccess;
    }
    /**
     Verifies a Person's data.
     @param Person The Person object representing the Person data
     @return true if the Person's data are valid else returns false
     */
    public boolean authenticatePerson(Person Person) {
        boolean authenticateSuccess = false;
        authenticateSuccess = PersonDao.authenticatePerson(Person);
        return authenticateSuccess;
    }
    /**
     Logs out a Person.
     @param Person The Person object representing the Person data
     @return true if the Person is successfully logged out else returns false
     */
    public boolean logout(Person Person) {
        return true;
    }
}