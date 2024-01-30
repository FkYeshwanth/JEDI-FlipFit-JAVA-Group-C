/**
 * Interface defining operations related to persons (customers, gym owners) in the FlipFit system.
 */
package com.flipkart.service;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.Person;

/**
 * Interface defining operations related to persons (customers, gym owners) in the FlipFit system.
 */
public interface PersonFlipFitInterface {

    /**
     * Registers a new customer in the system.
     *
     * @param customer GymUser object representing the customer to be registered.
     * @return True if the registration is successful, false otherwise.
     */
    public boolean registerCustomer(GymUser customer);

    /**
     * Registers a new gym owner in the system.
     *
     * @param gymOwner GymOwner object representing the gym owner to be registered.
     * @return True if the registration is successful, false otherwise.
     */
    public boolean registerGymOwner(GymOwner gymOwner);

    /**
     * Authenticates a person in the system.
     *
     * @param user Person object representing the person to be authenticated.
     * @return True if the authentication is successful, false otherwise.
     */
    public boolean authenticatePerson(Person user);

    /**
     * Logs out a person from the system.
     *
     * @param user Person object representing the person to be logged out.
     * @return True if the logout is successful, false otherwise.
     */
    public boolean logout(Person user);

}
