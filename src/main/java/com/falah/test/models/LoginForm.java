package com.falah.test.models;

public class LoginForm {

    /*
    {
  "phoneNumber": "string",
  "password": "string"
}
    * */

    private String phoneNumber;
    private String password;


    public LoginForm() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
