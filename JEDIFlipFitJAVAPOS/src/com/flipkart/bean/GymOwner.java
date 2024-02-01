package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * The GymOwner class represents an owner of a gym in the application, extending the Person class.
 */
public class GymOwner extends Person {
    // Attributes specific to GymOwner
    private String name;           // Owner's name
    private String phoneNumber;    // Owner's phone number
    private String aadharNumber;   // Owner's Aadhar number
    private String panNumber;      // Owner's PAN number
    private boolean isVerified;    // Verification status of the owner
    private List<Gym> centers = new ArrayList<>();  // List of gyms owned by the owner

    /**
     * Parameterized constructor for the GymOwner class.
     *
     * @param email         Email of the owner
     * @param password      Password of the owner
     * @param roleId        Role ID of the owner
     * @param name          Name of the owner
     * @param phoneNumber   Phone number of the owner
     * @param aadharNumber  Aadhar number of the owner
     * @param panNumber     PAN number of the owner
     */
    public GymOwner(String email, String password, String roleId, String name, String phoneNumber, String aadharNumber, String panNumber) {
        super(email, password, roleId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.isVerified = false;
    }

    /**
     * Default constructor for the GymOwner class.
     */
    public GymOwner() {
        super();
    }

    /**
     * Getter method for the owner's name.
     *
     * @return The name of the owner.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the owner's name.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the owner's phone number.
     *
     * @return The phone number of the owner.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for the owner's phone number.
     *
     * @param phoneNumber The new phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method for the owner's Aadhar number.
     *
     * @return The Aadhar number of the owner.
     */
    public String getAadharNumber() {
        return aadharNumber;
    }

    /**
     * Setter method for the owner's Aadhar number.
     *
     * @param aadharNumber The new Aadhar number to set.
     */
    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    /**
     * Getter method for the owner's PAN number.
     *
     * @return The PAN number of the owner.
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * Setter method for the owner's PAN number.
     *
     * @param panNumber The new PAN number to set.
     */
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * Getter method for the verification status of the owner.
     *
     * @return True if the owner is verified, false otherwise.
     */
    public boolean isVerified() {
        return isVerified;
    }

    /**
     * Setter method for the verification status of the owner.
     *
     * @param isVerified The new verification status to set.
     */
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * Getter method for the list of gyms owned by the owner.
     *
     * @return List of gyms owned by the owner.
     */
    public List<Gym> getCenters() {
        return centers;
    }

    /**
     * Setter method for the list of gyms owned by the owner.
     *
     * @param centers The new list of gyms to set.
     */
    public void setCenters(List<Gym> centers) {
        this.centers = centers;
    }
}
