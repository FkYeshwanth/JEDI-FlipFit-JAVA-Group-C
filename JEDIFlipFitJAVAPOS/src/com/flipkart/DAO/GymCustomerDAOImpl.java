package com.flipkart.DAO;

import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.Slot;
import com.flipkart.constants.ColorConstants;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtils;

public class GymCustomerDAOImpl implements GymCustomerDAO{



    public List<Booking> getBookings(String email) {
        return fetchBookedSlots(email);
    }

    public int editGymUserDetails(GymUser customer) {
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_USER);


            preparedStatement.setString(1, customer.getEmail());


            preparedStatement.setString(2, customer.getPassword());


            preparedStatement.setString(3, "Customer");


            preparedStatement.setString(4, customer.getEmail());


            // Step 3: Execute the query or update query


            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"
            // There is an issue with the SQL code"+ColorConstants.RESET);
        }


        try {


            connection = DBUtils.getConnection();






            // Step 2:Create a statement using connection object


            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_CUSTOMER);


            PreparedStatement preparedStatement2 = connection.prepareStatement(SQLConstants.SQL_UPDATE_USER);






            preparedStatement.setString(1, customer.getName());


            preparedStatement.setString(2, customer.getPhoneNumber());


            preparedStatement.setInt(3,customer.getAge());


            preparedStatement.setString(4, customer.getAddress());


            preparedStatement.setString(5, customer.getEmail());






            preparedStatement2.setString(1, customer.getEmail());


            preparedStatement2.setString(2, customer.getPassword());


            preparedStatement2.setString(3, customer.getRoleId());


            preparedStatement2.setString(4, customer.getEmail());

            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement2.executeUpdate();
            return  preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);

        }

        // Step 1: Establishing a Connection
        return 0;
    }

    public GymUser getGymUserDetails(String email) throws UserNotFoundException {
        Connection connection = null;
        GymUser customer = new GymUser();
        try {
            connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_VIEW_CUSTOMER);
            preparedStatement.setString(1, email);
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new UserNotFoundException(ColorConstants.RED+ "User not found"+ColorConstants.RESET);
            }
            if (!rs.next())
                return null;
            // Step 4: Process the ResultSet object.
            do {
                customer.setEmail(rs.getString("email"));
                customer.setName(rs.getString("name"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setAge(rs.getInt("age"));
                customer.setAddress(rs.getString("address"));

//                customer.setAadharNumber(rs.getString("aadharNum"));
//                gymOwner.setPanNumber(rs.getString("panNum"));

                // System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            } while (rs.next());
        } catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return customer;
    }



    public List<Gym> fetchGymList() throws GymNotFoundException{
        Connection connection = null;
        List<Gym> gyms = new ArrayList<Gym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
        try {connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement(query);
            //System.out.println(statement);
            // Step 3: Execute the query or update query
            ResultSet rs = statement.executeQuery();
            if(rs==null){
                throw new GymNotFoundException(ColorConstants.RED+ "Gym not found"+ ColorConstants.RESET);
            }

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
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ ColorConstants.RESET);
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
            //printSQLException(sqlExcep);
        }
        return null;
    }

    public int getNumberOfSeatsBooked(String slotId){
        return 1;
    }

    public int getNumberOfSeats(String slotId){
        return 1;
    }
    public List<Booking> fetchBookedSlots(String email) {
//        System.out.println("fetch booked slots");
        Connection connection = null;
        List<Booking> bookings=new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConstants.SQL_SELECT_BOOKED_SLOTS_BY_CUSTOMER);

            statement.setString(1, email);
//            System.out.println("state: "+statement);
            ResultSet rs = statement.executeQuery();
//            System.out.println("result: "+rs);
            if (!rs.next()) {
                throw new SeatsNotavailableException(ColorConstants.RED+"No seats available"+ColorConstants.RESET);
            }

            while (rs.next()) {
                Booking b=new Booking();
                b.setBookingId(rs.getString("bookingId"));
                b.setCustomerEmail(rs.getString("customerEmail"));
                b.setSlotId(rs.getString("slotId"));
                b.setGymId(rs.getString("gymId"));
                b.setType(rs.getString("type"));
                b.setDate(rs.getString("date"));
                bookings.add(b);
//                System.out.println("booking "+bookings.get(0).getBookingId());
            }
        } catch (SQLException sqlExcep) {
//            System.out.println("There is an issue with the SQL code");
        } catch (SeatsNotavailableException e) {
            throw new RuntimeException(e);
        }
//        System.out.println("booking");
//        System.out.println(bookings);
//        for(Booking b : bookings)  {
//            System.out.println(b);
//        }
        return bookings;
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
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
    }

//    public void bookSlots(String bookingId, String slotId, String gymId, String type, Date date, String customerEmail) {
//        Connection connection = null;
//        String query = "INSERT INTO Booking (bookingId,slotId,gymId,type,date,customerEmail) values(?, ?, ?, ?, ?, ?)";
//        try {connection = DBUtils.getConnection();
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, bookingId);
//            statement.setString(2, slotId);
//            statement.setString(3, gymId);
//            statement.setString(4, type);
//            statement.setDate(5, (java.sql.Date)date);
//            statement.setString(6, customerEmail);
//            statement.executeUpdate();
//            System.out.println("-----------------------------------------------");
//        } catch (SQLException sqlExcep) {
//            printSQLException(sqlExcep);
//        }
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
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
        return false;
    }

    public boolean isFull(String slotId, String date) {
        Connection connection = null;
        String query = "Select * from slot where (slotId=? and (numOfSeatsBooked>=numOfSeats))";
        try {connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, slotId);
            //System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e)
        {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
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

    public boolean cancelBooking(String slotId, String email) {
        Connection connection = null;
//        String query = "Delete from Booking where email = ? and slotId = ? and date = ?";
//        try {connection = DBUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(query);
            try {
                connection = DBUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQLConstants.SQL_DELETE_BOOKING);
//                statement.setString(2, bookingId);
                statement.setString(1, email);
                statement.setString(2, slotId);
//                statement.setString(3, date);
                statement.executeUpdate();
                System.out.println("-----------------------------------------------");
                return true;
            } catch (SQLException sqlExcep) {
                //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
            }
            return false;
        }

    public boolean alreadyBooked(String slotId, String email, String date) {
        Connection connection = null;
//        String query = "select bookingId from Booking where slotId=? and customerEmail =  ?";
        try {connection = DBUtils.getConnection();

            PreparedStatement statement = connection.prepareStatement(SQLConstants.SQL_CHECK_ALREADY_BOOKED);
            statement.setString(1,slotId);
            statement.setString(2, email);
            //System.out.println(statement);

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }

        return false;
    }

//    public void cancelBooking(String slotId, String email) {
//        Connection connection = null;
//        String query = "Delete from Booking where email = ? and slotId = ? and date = ?";
//        try {connection = DBUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, email);
//            statement.setString(2, slotId);
//            statement.setString(3, date);
//            statement.executeUpdate();
//            System.out.println("-----------------------------------------------");
//        } catch (SQLException sqlExcep) {
//            printSQLException(sqlExcep);
//        }
//    }

    public boolean checkSlotExists(String slotId, String gymId) throws NoSlotsFoundException{
        Connection connection = null;
        String query = "select isVerified from slot where slotId=? and gymId =  ?";
        try {connection = DBUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, gymId);
            //System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new NoSlotsFoundException(ColorConstants.RED+"No slots available"+ColorConstants.RESET);
            }

            return rs.next();
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }

        return false;
    }

    public boolean checkGymApprove(String gymId) throws GymNotApprovedExceptions {
        Connection connection = null;
        String query = "select isVerified from gym where gymId =  ?";
        try {connection = DBUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
            //System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new GymNotApprovedExceptions(ColorConstants.RED+"Gym not approved"+ColorConstants.RESET);
            }

            return rs.next();
        } catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }

        return false;
    }

//    public static void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }

}
