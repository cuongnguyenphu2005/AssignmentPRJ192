/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cuongnp.models.userContact;

import java.io.Serializable;

/**
 *
 * @author Cuong
 */
public class UserContactDTO implements Serializable{
    private int contactId;
    private String username;
    private int phone;
    private String address;
    private String email;

    public UserContactDTO() {
    }

    public UserContactDTO(String username, int phone, String address) {
        this.username = username;
        this.phone = phone;
        this.address = address;
    }

    
    
    public UserContactDTO(int contactId, String username, int phone, String address, String email) {
        this.contactId = contactId;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
