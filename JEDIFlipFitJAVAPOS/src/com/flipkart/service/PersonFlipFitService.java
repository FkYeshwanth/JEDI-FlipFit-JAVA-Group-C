/**
 * Service class implementing operations related to persons (customers, gym owners) in the FlipFit system.
 */
package com.flipkart.service;

import com.flipkart.DAO.GymOwnerDAOImpl;
import com.flipkart.DAO.PersonDAOImpl;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.Person;

/**
 * Service class implementing operations related to persons (customers, gym owners) in the FlipFit system.
 */
public class PersonFlipFitService implements PersonFlipFitInterface {

    GymOwnerDAOImpl gymOwnerDao = new GymOwnerDAOImpl();
    PersonDAOImpl personDao = new PersonDAOImpl();

    /**
     * Registers a customer in the system.
     *
     * @param customer The GymUser object representing the customer data.
     * @return True if the registration is successful, false otherwise.
     */
    public boolean registerCustomer(GymUser customer) {
        boolean registerSuccess = personDao.registerCustomer(customer);
        return registerSuccess;
    }

    /**
     * Registers a gym owner in the system.
     *
     * @param gymOwner The GymOwner object representing the gym owner data.
     * @return True if the registration is successful, false otherwise.
     */
    public boolean registerGymOwner(GymOwner gymOwner) {
        boolean registerSuccess = personDao.registerGymOwner(gymOwner);
        return registerSuccess;
    }

    /**
     * Verifies a person's data.
     *
     * @param person The Person object representing the person data.
     * @return True if the person's data are valid, false otherwise.
     */
    public boolean authenticatePerson(Person person) {
        boolean authenticateSuccess = personDao.authenticatePerson(person);
        return authenticateSuccess;
    }

    /**
     * Logs out a person.
     *
     * @param person The Person object representing the person data.
     * @return True if the person is successfully logged out, false otherwise.
     */
    public boolean logout(Person person) {
        // Implementation for logging out a person (placeholder logic).
        return true;
    }
}
