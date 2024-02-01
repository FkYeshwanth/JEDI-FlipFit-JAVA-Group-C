package com.flipkart.bean;

import java.util.Date;

/**
 * The Booking class represents a booking made by a customer for a gym slot.
 */
public class Booking {
    // Attributes of the Booking
    private String bookingId;       // Unique identifier for the booking
    private String slotId;          // ID of the slot booked
    private String gymId;           // ID of the gym for which the booking is made
    private String type;            // Type of booking (e.g., regular, premium)
    private String date;            // Date of the booking
    private String customerEmail;   // Email of the customer who made the booking


    /**
     * Default constructor for the Booking class.
     */
    public Booking() {
        super();
    }

    /**
     * Parameterized constructor for the Booking class.
     *
     * @param bookingId      Unique identifier for the booking
     * @param slotId         ID of the slot booked
     * @param gymId          ID of the gym for which the booking is made
     * @param type           Type of booking (e.g., regular, premium)
     * @param date           Date of the booking
     * @param customerEmail  Email of the customer who made the booking
     * @param trainer        Trainer information (not used in the class)
     */
    public Booking(String bookingId, String slotId, String gymId, String type, String date, String customerEmail, String trainer) {
        this.bookingId = bookingId;
        this.slotId = slotId;
        this.gymId = gymId;
        this.type = type;
        this.date = date;
        this.customerEmail = customerEmail;
    }

    // Getter and Setter methods for the attributes

    /**
     * Getter method for bookingId.
     *
     * @return The unique identifier for the booking.
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Setter method for bookingId.
     *
     * @param bookingId The new unique identifier to set.
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Getter method for slotId.
     *
     * @return The ID of the slot booked.
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Setter method for slotId.
     *
     * @param slotId The new slot ID to set.
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Getter method for gymId.
     *
     * @return The ID of the gym for which the booking is made.
     */
    public String getGymId() {
        return gymId;
    }

    /**
     * Setter method for gymId.
     *
     * @param gymId The new gym ID to set.
     */
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    /**
     * Getter method for type.
     *
     * @return The type of booking (e.g., regular, premium).
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for type.
     *
     * @param type The new booking type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter method for date.
     *
     * @return The date of the booking.
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param date The new booking date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Getter method for customerEmail.
     *
     * @return The email of the customer who made the booking.
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Setter method for customerEmail.
     *
     * @param customerEmail The new customer email to set.
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}

