package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotApprovedExceptions;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.NoSlotsFoundException;
import com.flipkart.utils.DBUtils;

public class GymOwnerDAOImpl implements GymOwnerDAO{

    public GymOwner getGymOwnerDetails(String gymOwnerEmailId) throws GymOwnerNotFoundException{
        Connection connection = null;
        GymOwner gymOwner = new GymOwner();
        String query = "select email, name, phoneNumber, aadharNumber, panNumber from gymOwner where email = ?";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymOwnerEmailId);
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            if(rs==null){
                throw new GymOwnerNotFoundException(ColorConstants.RED+"There are no gym owners"+ColorConstants.RESET);
            }
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                gymOwner.setEmail(rs.getString("email"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setPhoneNumber(rs.getString("phoneNumber"));
                gymOwner.setAadharNumber(rs.getString("aadharNumber"));
                gymOwner.setPanNumber(rs.getString("panNumber"));

//                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gymOwner;
    }

    public void addGymOwnerDetails(GymOwner gymOwnerDetails) {
        Connection connection = null;
        String INSERT_USER_SQL = "INSERT INTO user" + " (email, password, role) VALUES " + "(?, ?, ?);";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, gymOwnerDetails.getEmail());
            preparedStatement.setString(2, gymOwnerDetails.getPassword());
            preparedStatement.setString(3, "3");

            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }

        String INSERT_GYM_OWNER_SQL = "INSERT INTO gymOwner"
                + "  (email, password, name, phoneNumber, aadharNumber, panNumber, isVerified) VALUES "
                + " (?, ?, ?, ?, ?, ?, ?);";
        System.out.println(INSERT_GYM_OWNER_SQL);
        // Step 1: Establishing a Connection
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_OWNER_SQL);
            preparedStatement.setString(1, gymOwnerDetails.getEmail());
            preparedStatement.setString(2, gymOwnerDetails.getPassword());
            preparedStatement.setString(3, gymOwnerDetails.getName());
            preparedStatement.setString(4, gymOwnerDetails.getPhoneNumber());
            preparedStatement.setString(5, gymOwnerDetails.getAadharNumber());
            preparedStatement.setString(6, gymOwnerDetails.getPanNumber());
            preparedStatement.setBoolean(7, gymOwnerDetails.isVerified());

            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }
    }

    public void editGymOwnerDetails(GymOwner oldgymOwnerDetails,GymOwner newgymOwnerDetails) {
        Connection connection = null;
        String UPDATE_USER_SQL = "update person set email = ?, password = ?, role = ?" + " where email = ?;";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, newgymOwnerDetails.getEmail());
            preparedStatement.setString(2, newgymOwnerDetails.getPassword());
            preparedStatement.setString(3, "3");
            preparedStatement.setString(4, oldgymOwnerDetails.getEmail());
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }

        String UPDATE_GYM_OWNER_SQL = "update gymowner set email = ?, name = ?, phoneNumber = ?, aadharNumber = ?, panNumber = ?, isVerified = ? "
                + "where email = ?;";
        System.out.println(UPDATE_GYM_OWNER_SQL);
        // Step 1: Establishing a Connection
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GYM_OWNER_SQL);
            preparedStatement.setString(1, newgymOwnerDetails.getEmail());
            preparedStatement.setString(2, newgymOwnerDetails.getName());
            preparedStatement.setString(3, newgymOwnerDetails.getPhoneNumber());
            preparedStatement.setString(4, newgymOwnerDetails.getAadharNumber());
            preparedStatement.setString(5, newgymOwnerDetails.getPanNumber());
            preparedStatement.setBoolean(6, newgymOwnerDetails.isVerified());
            preparedStatement.setString(7, oldgymOwnerDetails.getEmail());
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }
    }

    public Gym getGym(String gymId) throws GymNotFoundException {
        Connection connection = null;
        Gym gym = new Gym();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym where gymId = ?";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new GymNotFoundException(ColorConstants.RED+"There is no gyms available"+ColorConstants.RESET);
            }

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setOwnerEmail(rs.getString("gymOwnerEmail"));
                gym.setAddress(rs.getString("address"));
                gym.setSlotCount(rs.getInt("slotCount"));
                gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlot"));
                gym.setVerified(rs.getBoolean("isVerified"));

//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gym;
    }

    public void addGym(Gym gymDetails) {
        Connection connection = null;
        String INSERT_GYM_SQL = "INSERT INTO gym"
                + "  (gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified) VALUES "
                + " (?, ?, ?, ?, ?, ?, ?);";
        System.out.println(INSERT_GYM_SQL);
        // Step 1: Establishing a Connection
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_SQL);
            preparedStatement.setString(1, gymDetails.getGymId());
            preparedStatement.setString(2, gymDetails.getGymName());
            preparedStatement.setString(3, gymDetails.getOwnerEmail());
            preparedStatement.setString(4, gymDetails.getAddress());
            preparedStatement.setInt(5, gymDetails.getSlotCount());
            preparedStatement.setInt(6, gymDetails.getSeatsPerSlotCount());
            preparedStatement.setBoolean(7, gymDetails.isVerified());

            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }
    }

    public void editGym(Gym gymDetails) {
        Connection connection = null;
        String INSERT_GYM_SQL = "update gym"
                + "  set gymId = ?, gymName = ?, ownerEmail = ?, address = ?, slotCount = ?, seatsPerSlotCount = ?, isVerified = ? where gymId = ?;";
        System.out.println(INSERT_GYM_SQL);
        // Step 1: Establishing a Connection
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_SQL);
            preparedStatement.setString(1, gymDetails.getGymId());
            preparedStatement.setString(2, gymDetails.getGymName());
            preparedStatement.setString(3, gymDetails.getOwnerEmail());
            preparedStatement.setString(4, gymDetails.getAddress());
            preparedStatement.setInt(5, gymDetails.getSlotCount());
            preparedStatement.setInt(6, gymDetails.getSeatsPerSlotCount());
            preparedStatement.setBoolean(7, gymDetails.isVerified());
            preparedStatement.setString(8, gymDetails.getGymId());

            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }
    }

    public List<Gym> getGymsOfGymOwner(String gymOwnerId) throws GymNotFoundException{
        Connection connection = null;
        List<Gym> gyms = new ArrayList<Gym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym where ownerEmail =  ?";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymOwnerId);
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new GymNotFoundException(ColorConstants.RED+"There is no gyms available"+ColorConstants.RESET);
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
            //System.out.println("There is an issue with the SQL code");
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gyms;
    }

    public List<Slot> getPossibleSlots(String gymId) throws NoSlotsFoundException {
        Connection connection = null;
        List<Slot> slots = new ArrayList<Slot>();
        String query = "select slotId, gymId, startTime, endTime, trainer, numOfSeats, numOfSeatsBooked from slot where gymId =  ?";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new NoSlotsFoundException(ColorConstants.RED+"There are no slots found"+ColorConstants.RESET);
            }

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Slot slot = new Slot();
                slot.setSlotId(rs.getString("slotId"));
                slot.setGymId(rs.getString("gymId"));
                slot.setStartTime(rs.getString("startTime"));
                slot.setEndTime(rs.getString("endTime"));
                slot.setTrainer(rs.getString("trainer"));
                slots.add(slot);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return slots;
    }

    public void addSlot(Slot slot) {
        Connection connection = null;
        String INSERT_SLOT_SQL = "INSERT INTO slot" + "  (slotId, gymId, startTime, endTime, trainer, numOfSeats, numOfSeatsBooked) VALUES "
                + " (?, ?, ?, ?, ?, ?, ?);";
        System.out.println(INSERT_SLOT_SQL);
        // Step 1: Establishing a Connection
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SLOT_SQL);
            preparedStatement.setString(1, slot.getSlotId());
            preparedStatement.setString(2, slot.getGymId());
            preparedStatement.setString(3, slot.getStartTime());
            preparedStatement.setString(4, slot.getEndTime());
            preparedStatement.setString(5, slot.getTrainer());
            preparedStatement.setInt(6, slot.getNumOfSeats());
            preparedStatement.setInt(7, slot.getNumOfSeatsBooked());

            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            //System.out.println("There is an issue with the SQL code");
        }
    }

    public boolean checkOwnerApproval(String email) {
        Connection connection = null;
        String query = "select isVerified from gymOwner where email =  ?";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            return rs.next();
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return false;
    }

    public boolean checkGymApproval(String gymId) throws GymOwnerNotApprovedExceptions {
        Connection connection = null;
        String query = "select isVerified from gym where gymId =  ?";
        try {connection = DBUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
            //System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new GymOwnerNotApprovedExceptions(ColorConstants.RED+"Gym owner not approved"+ColorConstants.RESET);
            }

            // Step 4: Process the ResultSet object.
            return rs.next();
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }
        // Step 4: try-with-resource statement will auto close the connection.
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