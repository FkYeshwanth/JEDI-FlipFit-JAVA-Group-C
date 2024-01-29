package com.flipkart.DAO;

import java.util.Date;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.exception.NoSlotsFoundException;
//import com.flipkart.exception.NoSlotsFoundException;

public interface GymCustomerDAO {
    public List<Gym> fetchGymList();

    public List<Slot> fetchSlotList(String gymId) throws NoSlotsFoundException;

    public List<Booking> fetchBookedSlots(String email);


    public boolean isFull(String slotId, String date);

    public boolean alreadyBooked(String slotId, String email, String date);

    public void cancelBooking(String slotId, String email, String date);

    public boolean checkSlotExists(String slotId, String gymId);

    public boolean checkGymApprove(String gymId);

    public int getNumberOfSeatsBooked(String slotId);

    public int getNumberOfSeats(String slotId);

    public boolean updateNumOfSeats(String slotId, int seats);

    public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail);
}
