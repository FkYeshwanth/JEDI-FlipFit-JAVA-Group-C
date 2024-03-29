/**
 *
 */
package com.flipkart.DAO;
import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.constants.ColorConstants;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.NoPendingGymOwnerRequest;
import com.flipkart.exception.NoPendingGymRequest;
import com.flipkart.utils.DBUtils;


/**
 *
 */
public class AdminDAOImpl implements AdminDAO {

    Connection connection = null;
    public List<GymOwner> getAllGymOwners() throws GymOwnerNotFoundException{
        List<GymOwner> gymOwners = new ArrayList<GymOwner>();
        String query = "select name, phoneNumber, aadharNumber, panNumber, isVerified from gymOwner";
        try {connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
           PreparedStatement preparedStatement = connection.prepareStatement(query);
//            System.out.println(preparedStatement);
////            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new GymOwnerNotFoundException(ColorConstants.RED+"There are no gym owners"+ColorConstants.RESET);
            }
////
////            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setName(rs.getString("name"));
                gymOwner.setPhoneNumber(rs. getString("phoneNumber"));
                gymOwner.setAadharNumber(rs.getString("aadharNumber"));
                gymOwner.setPanNumber(rs.getString("panNumber"));
                gymOwner.setVerified(rs.getBoolean("isVerified"));
                gymOwners.add(gymOwner);
//	                System.out.println(gymOwner.getName());
//                System.out.println("doneee");
            }
        }
        catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gymOwners;
    };

    public List<Gym> getAllGyms() throws GymNotFoundException{
        Connection connection = null;
        List<Gym> gyms = new ArrayList<Gym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
        try {connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new GymNotFoundException(ColorConstants.RED+"There are no gyms in this location"+ColorConstants.RESET);
            }
//
//            // Step 4: Process the ResultSet object.
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
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
//        // Step 4: try-with-resource statement will auto close the connection.
        return gyms;
    };

    public List<GymOwner> getPendingGymOwnerRequests() throws NoPendingGymOwnerRequest{
        Connection connection = null;
        List<GymOwner> gymOwners = new ArrayList<GymOwner>();
        String query = "select name, phoneNumber, aadharNumber, panNumber, isVerified from gymOwner where isVerified = ?;";
        try {connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
            preparedStatement.setBoolean(1, false);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new NoPendingGymOwnerRequest(ColorConstants.RED+"There are no pending gym owner request"+ColorConstants.RESET);
            }
//
//            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                GymOwner gymOwner = new GymOwner();
//                gymOwner.setEmail(rs.getString("email"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setPhoneNumber(rs.getString("phoneNumber"));
                gymOwner.setAadharNumber(rs.getString("aadharNumber"));
                gymOwner.setPanNumber(rs.getString("panNumber"));
                gymOwner.setVerified(rs.getBoolean("isVerified"));
                gymOwners.add(gymOwner);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
                System.out.println(gymOwner.getName());

            }
        } catch (SQLException e) {
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gymOwners;

    };

    public List<Gym> getPendingGymRequests() throws NoPendingGymRequest {
        Connection connection = null;
        List<Gym> gyms = new ArrayList<Gym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym where isVerified = ?;";
        try {connection = DBUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
            preparedStatement.setBoolean(1, false);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs==null){
                throw new NoPendingGymRequest(ColorConstants.RED+"There is no pending gym request"+ColorConstants.RESET);
            }

//            // Step 4: Process the ResultSet object.
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
            //System.out.println(ColorConstants.RED+"There is an issue with the SQL code"+ColorConstants.RESET);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gyms;

    };

    public void approveSingleOwnerRequest(String gymOwnerEmail) {
        Connection connection = null;
        String SQL_APPROVE_GYM_OWNER_BY_ID="update gymOwner set isVerified=1 WHERE email=?;";
        try {connection = DBUtils.getConnection();
//            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_APPROVE_GYM_OWNER_BY_ID);
            //System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
            preparedStatement.setString(1, gymOwnerEmail);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //System.out.println("There is an issue with the SQL code");
        }
    };

    public void approveAllOwnerRequest() {
        Connection connection = null;
        String SQL_APPROVE_ALL_GYMS="update gymOwner set isVerified=1;";
        try {connection = DBUtils.getConnection();
//            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_APPROVE_ALL_GYMS);
           // System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
          //  System.out.println("There is an issue with the SQL code");
        }
    };

    public void approveSingleGymRequest(String gymId) {
        Connection connection = null;
        String SQL_APPROVE_GYM_BY_ID="update gym set isVerified=1 where gymId = ?;";
        try {connection = DBUtils.getConnection();
//            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_APPROVE_GYM_BY_ID);
            //System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
            preparedStatement.setString(1, gymId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           // System.out.println("There is an issue with the SQL code");
        }
    };

    public void approveAllGymRequest() {
        Connection connection = null;
        String SQL_APPROVE_ALL_GYMS="update gym set isVerified=1;";
        try {connection = DBUtils.getConnection();
//            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_APPROVE_ALL_GYMS);
            //System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        //    System.out.println("There is an issue with the SQL code");
        }
    };

//    public static void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
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
