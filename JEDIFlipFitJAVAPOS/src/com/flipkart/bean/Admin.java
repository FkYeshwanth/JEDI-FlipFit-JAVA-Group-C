/**
 * 
 */
package com.flipkart.bean;
/**
 * The Admin class represents an administrator in the FlipFit application.
 * It extends the Person class and inherits properties such as email, password, and roleName.
 */
public class Admin extends Person {
    // Additional attributes specific to the Admin class
    private String name;
    private String phoneNumber;

    /**
     * Parameterized constructor to create an Admin object with specified details.
     *
     * @param email       The email of the administrator.
     * @param password    The password of the administrator.
     * @param roleName    The role name (should be "Admin" for Admin objects).
     * @param name        The name of the administrator.
     * @param phoneNumber The phone number of the administrator.
     */
    public Admin(String email, String password, String roleName, String name, String phoneNumber) {
        // Call the constructor of the superclass (Person) with common attributes
        super(email, password, roleName);

        // Set the additional attributes specific to the Admin class
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Default constructor for the Admin class.
     */
    public Admin() {
        // Call the default constructor of the superclass (Person)
        super();
    }

    /**
     * Gets the name of the administrator.
     *
     * @return The name of the administrator.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the administrator.
     *
     * @param name The name to set for the administrator.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone number of the administrator.
     *
     * @return The phone number of the administrator.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the administrator.
     *
     * @param phoneNumber The phone number to set for the administrator.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
