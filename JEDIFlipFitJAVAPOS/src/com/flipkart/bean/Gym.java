package com.flipkart.bean;

/**
 * The Gym class represents a gym in the application.
 */
public class Gym {
    // Attributes of the Gym
    private String gymId;               // Unique identifier for the gym
    private String gymName;             // Name of the gym
    private String ownerEmail;          // Email of the gym owner
    private String address;             // Address of the gym
    private int slotCount;              // Number of slots available in the gym
    private int seatsPerSlotCount;      // Number of seats available per slot in the gym
    private boolean isVerified;         // Verification status of the gym

    /**
     * Default constructor for the Gym class.
     */
    public Gym() {
        // Default constructor
    }

    /**
     * Parameterized constructor for the Gym class.
     *
     * @param gymId             Unique identifier for the gym
     * @param gymName           Name of the gym
     * @param ownerEmail        Email of the gym owner
     * @param address           Address of the gym
     * @param slotCount         Number of slots available in the gym
     * @param seatsPerSlotCount Number of seats available per slot in the gym
     * @param isVerified        Verification status of the gym
     */
    public Gym(String gymId, String gymName, String ownerEmail, String address, int slotCount, int seatsPerSlotCount, boolean isVerified) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.ownerEmail = ownerEmail;
        this.address = address;
        this.slotCount = slotCount;
        this.seatsPerSlotCount = seatsPerSlotCount;
        this.isVerified = isVerified;
    }

    // Getter and Setter methods for the attributes

    /**
     * Getter method for gymId.
     *
     * @return The unique identifier for the gym.
     */
    public String getGymId() {
        return gymId;
    }

    /**
     * Setter method for gymId.
     *
     * @param gymId The new unique identifier to set.
     */
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    /**
     * Getter method for gymName.
     *
     * @return The name of the gym.
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Setter method for gymName.
     *
     * @param gymName The new name to set.
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Getter method for ownerEmail.
     *
     * @return The email of the gym owner.
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Setter method for ownerEmail.
     *
     * @param ownerEmail The new email to set.
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    /**
     * Getter method for address.
     *
     * @return The address of the gym.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param address The new address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method for slotCount.
     *
     * @return The number of slots available in the gym.
     */
    public int getSlotCount() {
        return slotCount;
    }

    /**
     * Setter method for slotCount.
     *
     * @param slotCount The new number of slots to set.
     */
    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    /**
     * Getter method for seatsPerSlotCount.
     *
     * @return The number of seats available per slot in the gym.
     */
    public int getSeatsPerSlotCount() {
        return seatsPerSlotCount;
    }

    /**
     * Setter method for seatsPerSlotCount.
     *
     * @param seatsPerSlotCount The new number of seats per slot to set.
     */
    public void setSeatsPerSlotCount(int seatsPerSlotCount) {
        this.seatsPerSlotCount = seatsPerSlotCount;
    }

    /**
     * Getter method for isVerified.
     *
     * @return True if the gym is verified, false otherwise.
     */
    public boolean isVerified() {
        return isVerified;
    }

    /**
     * Setter method for isVerified.
     *
     * @param isVerified The new verification status to set.
     */
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * toString method to provide a string representation of the Gym object.
     *
     * @return A string representation of the Gym object.
     */
    public String toString() {
        return "Gym Id: " + gymId +
                "\nGym Name: " + gymName +
                "\nGym Owner Email: " + ownerEmail +
                "\nGym Address: " + address +
                "\nGym Slotcount: " + slotCount +
                "\nSeat per slot count: " + seatsPerSlotCount +
                "\nVerification: " + (isVerified ? "Yes" : "No");
    }
}
