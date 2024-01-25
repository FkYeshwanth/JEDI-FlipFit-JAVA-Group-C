package com.flipkart.DAO;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymUser;
import com.flipkart.bean.Person;

import java.util.HashMap;

public class PersonDAOImpl implements PersonDAO {
    public static HashMap<Integer,GymUser> gyu=new HashMap<>();
    public static int gyuid=101;






    public boolean authenticateUser(Person person){
        return true;
    }


    public boolean registerCustomer(GymUser gymUser){
        gyu.put(gyuid,gymUser);
        gyuid+=1;
        System.out.println(gyu.size());
        return true;
    }
    public boolean registerGymOwner(GymOwner gymOwner){
        return true;
    }
    public void updatePassword(Person person){
        return;
    }

}
