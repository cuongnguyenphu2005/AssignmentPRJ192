/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuongnp.registration;

import java.io.Serializable;

/**
 *
 * @author Cuong
 */
public class RegistrationDTO implements Serializable {

    private String username;
    private String password;
    private String lastName;
    private boolean isAdmin;

    public RegistrationDTO(String username, String password, String lastName, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }

    public RegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
