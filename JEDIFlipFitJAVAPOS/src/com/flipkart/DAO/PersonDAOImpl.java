package com.flipkart.DAO;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.Person;
import com.flipkart.DAO.GymOwnerDAOImpl;
import java.util.HashMap;
import java.util.Map;

public class PersonDAOImpl implements PersonDAO {
    public static HashMap<String,GymUser> gymUserHashMap=new HashMap<>();

    public static int gyuid=101;






    public boolean authenticateUser(Person person){
        String roleId= person.getRoleId();
        if(roleId.equals("1")){



        }else if(roleId.equals("2")){
            String emailId =person.getEmail();
            String password= person.getPassword();

            System.out.println("Final size is "+ GymOwnerDAOImpl.gymOwnerHash.size());
            if(!GymOwnerDAOImpl.gymOwnerHash.isEmpty() && GymOwnerDAOImpl.gymOwnerHash.containsKey(emailId) && GymOwnerDAOImpl.gymOwnerHash.get(emailId).getPassword().equals(password) ) {
                System.out.println("You have been authorized. You are a gym owner");
                System.out.println("Hello "+emailId);
                return true;
            }
            else{
                System.out.println("You have not authorized");
            }

        }else if(roleId.equals("3")){
            String emailId =person.getEmail();
            String password= person.getPassword();

            if(!gymUserHashMap.isEmpty() && gymUserHashMap.containsKey(emailId) && gymUserHashMap.get(emailId).getPassword().equals(password)) {
                System.out.println("You have been authorized. You are a gym customer");
                System.out.println("Hello "+emailId);
                return true;
            }
            else{
                System.out.println("You have not authorized");
            }
        }
        return false;
    }


    public boolean registerCustomer(GymUser gymUser){
        gymUserHashMap.put(gymUser.getEmail(),gymUser);
        return true;
    }
    public boolean registerGymOwner(GymOwner gymOwner){

        return true;
    }
    public void updatePassword(Person person){
        return;
    }

}