package com.flipkart.service;

import com.flipkart.bean.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service class providing functionality for booking operations in the FlipFit system.
 */
public class BookingFlipFitService implements BookingFlipFitInterface {

    // List to store bookings
    List<Booking> bookings = new ArrayList<>();

    // Current date
    Date currentDate = new Date();

//    Booking b1=new Booking("123","121","171","confirmed",d1,"c1@gmail.com","John");
//    Booking b2=new Booking("173","191","131","waitlisted",d1,"c2@gmail.com","Jack");
//    Booking b3=new Booking("113","129","173","confirmed",d1,"c3@gmail.com","Johnathon");
//    Booking b4=new Booking("193","127","971","waitlisted",d1,"c4@gmail.com","J");

    /**
     * Prepopulates bookings for testing purposes.
     */
    private void prepopulateBookings() {
        // Booking b1 = new Booking("123", "121", "171", "confirmed", currentDate, "c1@gmail.com", "John");
        // Booking b2 = new Booking("173", "191", "131", "waitlisted", currentDate, "c2@gmail.com", "Jack");
        // Booking b3 = new Booking("113", "129", "173", "confirmed", currentDate, "c3@gmail.com", "Johnathon");
        // Booking b4 = new Booking("193", "127", "971", "waitlisted", currentDate, "c4@gmail.com", "J");

        // bookings.add(b1);
        // bookings.add(b2);
        // bookings.add(b3);
        // bookings.add(b4);
    }

    /**
     * Checks if a booking with the given bookingId is confirmed.
     *
     * @param bookingId The unique identifier for the booking.
     * @return True if the booking is confirmed, false if it is not confirmed or not found.
     */
    public boolean isConfirmed(String bookingId) {

        for(Booking b:bookings)
        {
            if(b.getBookingId().equals(bookingId))
            {
                if(b.getType()=="confirmed")
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    /**
     * Retrieves the number of customers in the waiting list.
     *
     * @return The size of the waiting list.
     */
    public int getWaitingList() {
        return -1;
    }
}
