package com.flipkart.bean;

/**
 * The GymUser class represents a user of the gym application, extending the Person class.
 */
public class GymUser extends Person {
    // Attributes specific to GymUser
    private String name;           // User's name
    private String phoneNumber;    // User's phone number
    private int age;               // User's age
    private String address;        // User's address

    /**
     * Parameterized constructor for the GymUser class.
     *
     * @param email       Email of the user
     * @param password    Password of the user
     * @param roleName    Role name of the user
     * @param name        Name of the user
     * @param phoneNumber Phone number of the user
     * @param age         Age of the user
     * @param address     Address of the user
     */
    public GymUser(String email, String password, String roleName, String name, String phoneNumber, int age, String address) {
        super(email, password, roleName);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
    }

    /**
     * Default constructor for the GymUser class.
     */
    public GymUser() {
        super();
    }

    /**
     * Getter method for the user's name.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the user's name.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the user's phone number.
     *
     * @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for the user's phone number.
     *
     * @param phoneNumber The new phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method for the user's age.
     *
     * @return The age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for the user's age.
     *
     * @param age The new age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for the user's address.
     *
     * @return The address of the user.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for the user's address.
     *
     * @param address The new address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
