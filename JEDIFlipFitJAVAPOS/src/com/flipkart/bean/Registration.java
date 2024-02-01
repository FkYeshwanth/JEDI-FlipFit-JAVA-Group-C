/**
 *
 */
package com.flipkart.bean;

import java.util.Date;

/**
 *
 */
/**
 * The Registration class represents the registration information for a user in the system.
 */
public class Registration {

    // Attributes
    private String registrationId;    // Unique identifier for the registration
    private Date registrationDate;    // Date when the registration occurred
    private String email;             // Email associated with the registration

    /**
     * Gets the unique identifier for the registration.
     *
     * @return The registrationId.
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * Sets the unique identifier for the registration.
     *
     * @param registrationId The registrationId to set.
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * Gets the date when the registration occurred.
     *
     * @return The registrationDate.
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the date when the registration occurred.
     *
     * @param registrationDate The registrationDate to set.
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Gets the email associated with the registration.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email associated with the registration.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
