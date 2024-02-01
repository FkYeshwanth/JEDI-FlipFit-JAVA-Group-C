/**
 *
 */
package com.flipkart.bean;

/**
 *
 */
/**
 * The Slot class represents a time slot in a gym where users can book seats.
 */
public class Slot {
    private String slotId;
    private String gymId;
    private String startTime;
    private String endTime;
    private String trainer;
    private int numOfSeats;
    private int numOfSeatsBooked;

    /**
     * Default constructor for creating a Slot object.
     */
    public Slot() {
        // Default constructor
    }

    /**
     * Parameterized constructor to create a Slot object with specified details.
     *
     * @param slotId        The unique identifier for the time slot.
     * @param startTime     The start time of the slot.
     * @param endTime       The end time of the slot.
     * @param numOfSeats    The total number of seats available in the slot.
     * @param trainer       The name of the trainer associated with the slot.
     * @param gymId         The unique identifier of the gym to which the slot belongs.
     */
    public Slot(String slotId, String startTime, String endTime, int numOfSeats, String trainer, String gymId) {
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numOfSeats = numOfSeats;
        this.trainer = trainer;
        this.gymId = gymId;
        this.numOfSeatsBooked = 0; // Initializing the number of booked seats to 0
    }

    /**
     * Gets the unique identifier of the slot.
     *
     * @return The slotId.
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Sets the unique identifier of the slot.
     *
     * @param slotId The slotId to set.
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Gets the start time of the slot.
     *
     * @return The startTime.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the slot.
     *
     * @param startTime The startTime to set.
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time of the slot.
     *
     * @return The endTime.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the slot.
     *
     * @param endTime The endTime to set.
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the total number of seats available in the slot.
     *
     * @return The numOfSeats.
     */
    public int getNumOfSeats() {
        return numOfSeats;
    }

    /**
     * Sets the total number of seats available in the slot.
     *
     * @param numOfSeats The numOfSeats to set.
     */
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    /**
     * Gets the name of the trainer associated with the slot.
     *
     * @return The trainer.
     */
    public String getTrainer() {
        return trainer;
    }

    /**
     * Sets the name of the trainer associated with the slot.
     *
     * @param trainer The trainer to set.
     */
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    /**
     * Gets the unique identifier of the gym to which the slot belongs.
     *
     * @return The gymId.
     */
    public String getGymId() {
        return gymId;
    }

    /**
     * Sets the unique identifier of the gym to which the slot belongs.
     *
     * @param gymId The gymId to set.
     */
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the number of seats booked in the slot.
     *
     * @return The numOfSeatsBooked.
     */
    public int getNumOfSeatsBooked() {
        return numOfSeatsBooked;
    }

    /**
     * Sets the number of seats booked in the slot.
     *
     * @param numOfSeatsBooked The numOfSeatsBooked to set.
     */
    public void setNumOfSeatsBooked(int numOfSeatsBooked) {
        this.numOfSeatsBooked = numOfSeatsBooked;
    }
}
