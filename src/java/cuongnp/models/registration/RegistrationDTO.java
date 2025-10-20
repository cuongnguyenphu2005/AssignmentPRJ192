/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuongnp.models.registration;

import java.io.Serializable;

/**
 *
 * @author Cuong
 */
public class RegistrationDTO implements Serializable {

    private String username;
    private String password;
    private String lastName;
    private boolean role;
    private int phone;
    private String address;
    private String email;

    public RegistrationDTO() {
    }
    public RegistrationDTO(String username, String password, String lastName, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.role = isAdmin;
    }

    public RegistrationDTO(String username, int phone, String address, String email) {
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.email = email;
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

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
