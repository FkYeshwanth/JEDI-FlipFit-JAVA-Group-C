package com.flipkart.DAO;

import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtils;

public class GymCustomerDAOImpl implements GymCustomerDAO{

    public List<Gym> fetchGymList() {
        Connection connection = null;
        List<Gym> gyms = new ArrayList<Gym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
        try {connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println(statement);
            // Step 3: Execute the query or update query
            ResultSet rs = statement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Gym gym = new Gym();
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setOwnerEmail(rs.getString("ownerEmail"));
                gym.setAddress(rs.getString("address"));
                gym.setSlotCount(rs.getInt("slotCount"));
                gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlotCount"));
                gym.setVerified(rs.getBoolean("isVerified"));
                gyms.add(gym);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return gyms;
    }

    public List<Slot> fetchSlotList(String gymId) throws NoSlotsFoundException {
        Connection connection = null;
        String query = "Select * From Slot Where gymId=?";
        try {connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,gymId);
//            System.out.println(statement);
            ResultSet output = statement.executeQuery();
            if (!output.next()) {
                throw new NoSlotsFoundException("No slot found");
            }
            System.out.println("SlotId \t GymId \t SlotStart \t SlotEnd \t Available Seats");
            do {
                System.out.printf("%-7s\t", output.getString(1));
                System.out.printf("  %-9s\t", output.getString(2));
                System.out.printf("  %-9s\t", output.getString(3));
                System.out.printf("  %-9s\t", output.getString(4));
                System.out.printf("  %-9s\t", Integer.parseInt(output.getString(6))-Integer.parseInt(output.getString(7)));

                System.out.println("");
            } while (output.next());
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
        return null;
    }

    public int getNumberOfSeatsBooked(String slotId){
        return 1;
    }

    public int getNumberOfSeats(String slotId){
        return 1;
    }
    public void fetchBookedSlots(String email) {
        Connection connection = null;
        String query = "Select * From Booking where customerEmail = ?";
        try {connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, email);
            ResultSet output = statement.executeQuery();
            System.out.println("BookingId \t Date \t    GymId");
            while (output.next()) {
                System.out.printf("%-12s\t", output.getInt(1));
                System.out.printf("  %-7s\t", output.getString(5));
                System.out.printf("%-8s\t", output.getString(3));
                System.out.println("");
            }
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

    public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail) {
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConstants.SQL_INSERT_BOOKING);
            statement.setString(1, bookingId);
            statement.setString(2, slotId);
            statement.setString(3, gymId);
            statement.setString(4, type);
            statement.setString(5, date);
            statement.setString(6, customerEmail);
            statement.executeUpdate();
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

    public boolean isFull(String slotId, java.util.Date date) {
        return false;
    }

    public boolean alreadyBooked(String slotId, String email, java.util.Date date) {
        return false;
    }

    public void cancelBooking(String slotId, String email, java.util.Date date) {

    }


    public void bookSlots(String bookingId, String slotId, String gymId, String type, Date date, String customerEmail) {
        Connection connection = null;
        String query = "INSERT INTO Booking (bookingId,slotId,gymId,type,date,customerEmail) values(?, ?, ?, ?, ?, ?)";
        try {connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bookingId);
            statement.setString(2, slotId);
            statement.setString(3, gymId);
            statement.setString(4, type);
            statement.setDate(5, (java.sql.Date)date);
            statement.setString(6, customerEmail);
            statement.executeUpdate();
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

//    @Override
//    public boolean isFull(String slotId, Date date) {
//        return false;
//    }

    public boolean updateNumOfSeats(String slotId, int seats)
    {
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_NUMBER_OF_BOOKED_SEATS);
            preparedStatement.setString(2, slotId);
            preparedStatement.setInt(1, seats);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException sqlExcep) {
//            printSQLException(sqlExcep);
        }
        return false;
    }

    public boolean isFull(String slotId, String date) {
        Connection connection = null;
        String query = "Select * from slot where (slotId=? and (numOfSeatsBooked>=numOfSeats))";
        try {connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, slotId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e)
        {
            printSQLException(e);
        }

        return false;
    }

//    @Override
//    public boolean alreadyBooked(String slotId, String email, Date date) {
//        return false;
//    }
//
//    @Override
//    public void cancelBooking(String slotId, String email, Date date) {
//
//    }

    public boolean alreadyBooked(String slotId, String email, String date) {
        Connection connection = null;
        String query = "select bookingId from Booking where slotId=? and customerEmail =  ?";
        try {connection = DBUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, email);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public void cancelBooking(String slotId, String email, String date) {
        Connection connection = null;
        String query = "Delete from Booking where email = ? and slotId = ? and date = ?";
        try {connection = DBUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, slotId);
            statement.setString(3, date);
            statement.executeUpdate();
            System.out.println("-----------------------------------------------");
        } catch (SQLException sqlExcep) {
            printSQLException(sqlExcep);
        }
    }

    public boolean checkSlotExists(String slotId, String gymId) {
        Connection connection = null;
        String query = "select isVerified from slot where slotId=? and gymId =  ?";
        try {connection = DBUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, gymId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public boolean checkGymApprove(String gymId) {
        Connection connection = null;
        String query = "select isVerified from gym where gymId =  ?";
        try {connection = DBUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
