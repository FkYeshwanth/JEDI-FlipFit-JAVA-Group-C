package com.flipkart.bean;

/**
 * The Person class represents a generic person in the system with basic attributes like email, password, and role.
 */
public class Person {
    // Attributes
    private String email;       // Email of the person
    private String password;    // Password of the person
    private String roleId;      // Role identifier associated with the person

    /**
     * Constructor to initialize a person with email, password, and role.
     *
     * @param email    The email of the person.
     * @param password The password of the person.
     * @param roleId   The role identifier associated with the person.
     */
    public Person(String email, String password, String roleId) {
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    /**
     * Default constructor for the Person class.
     */
    public Person() {

    }

    /**
     * Gets the email of the person.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the person.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the person.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the person.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role identifier associated with the person.
     *
     * @return The roleId.
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role identifier associated with the person.
     *
     * @param roleId The roleId to set.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
