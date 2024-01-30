/**
 * Interface defining operations that a gym user can perform in the FlipFit system.
 */
package com.flipkart.service;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.Slot;
import com.flipkart.exception.NoSlotsFoundException;
import com.flipkart.exception.SeatsNotavailableException;

import java.util.Date;
import java.util.List;

/**
 * Interface defining operations that a gym user can perform in the FlipFit system.
 */
public interface GymUserFlipFitInterface {

    /**
     * Retrieves the profile of the gym user associated with the provided email.
     *
     * @param email The email of the gym user.
     * @return GymUser object representing the gym user's profile.
     */
    public GymUser getProfile(String email);

    /**
     * Allows the gym user to edit their profile.
     *
     * @param customer GymUser object representing the updated profile information.
     */
    public void editProfile(GymUser customer);

    /**
     * Retrieves the list of all bookings made by the gym user.
     *
     * @param email The email of the gym user.
     * @return List of Booking objects representing all bookings made by the gym user.
     * @throws SeatsNotavailableException If there are no available seats in the booking.
     */
    public List<Booking> getBookings(String email) throws SeatsNotavailableException;

    /**
     * Allows the gym user to cancel a booking.
     *
     * @param bookingId The id of the booking to be canceled.
     * @param email The email of the gym user.
     * @return True if the cancellation is successful, false otherwise.
     */
    public boolean cancelBooking(String bookingId, String email);

    /**
     * Retrieves the list of gyms in a specific city.
     *
     * @param city The city for which the list of gyms is requested.
     * @return List of Gym objects representing all gyms in the specified city.
     */
    public List<Gym> getGymInCity(String city);

    /**
     * Retrieves the list of slots available in a specific gym.
     *
     * @param gymId The id of the gym for which the list of slots is requested.
     * @return List of Slot objects representing all available slots in the specified gym.
     * @throws NoSlotsFoundException If there are no slots found in the specified gym.
     */
    public List<Slot> getSlotInGym(String gymId) throws NoSlotsFoundException;

    /**
     * Allows the gym user to book a slot in a specific gym.
     *
     * @param gymId The id of the gym for which the slot is to be booked.
     * @param slotId The id of the slot to be booked.
     * @param email The email of the gym user.
     * @param date The date for which the slot is to be booked.
     * @return The booking confirmation status (booking ID) or -1 if unsuccessful.
     */
    public int bookSlot(String gymId, String slotId, String email, String date);

    /**
     * Checks if a specific slot on a given date is fully booked.
     *
     * @param slotId The id of the slot to be checked.
     * @param date The date for which the check is to be made.
     * @return True if the slot is fully booked, false otherwise.
     */
    public boolean isSlotBooked(String slotId, Date date);

    /**
     * Checks if the gym user has already booked a slot with the given slotId on the specified date.
     *
     * @param slotId The id of the slot to be checked.
     * @param customerEmail The email of the gym user.
     * @param date The date for which the check is to be made.
     * @return True if the gym user has already booked the slot, false otherwise.
     */
    public boolean hasBookedSlotAlready(String slotId, String customerEmail, Date date);
}
