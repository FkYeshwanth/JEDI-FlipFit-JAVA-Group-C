/**
 *
 */
package com.flipkart.bean;

/**
 *
 */
/**
 * The Role class represents the roles assigned to different users in the system.
 */
public class Role {

    // Attributes
    private int roleId;       // Unique identifier for the role
    private String roleName;  // Name of the role

    /**
     * Gets the unique identifier for the role.
     *
     * @return The roleId.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param roleId The roleId to set.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the name of the role.
     *
     * @return The roleName.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the name of the role.
     *
     * @param roleName The roleName to set.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
