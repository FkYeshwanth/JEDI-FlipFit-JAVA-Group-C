package com.flipkart.service;

/**
 * Interface defining operations related to booking confirmation and waitlisting in the FlipFit system.
 */
public interface BookingFlipFitInterface {

    /**
     * Checks if a booking with the given bookingId is confirmed.
     *
     * @param bookingId The unique identifier for the booking.
     * @return True if the booking is confirmed, false if it is waitlisted.
     */
    public boolean isConfirmed(String bookingId);

    /**
     * Retrieves the waitlist number for a booking.
     *
     * @return The waitlist number if the booking is in waitlist, or 0 if not waitlisted.
     */
    public int getWaitingList();
}
