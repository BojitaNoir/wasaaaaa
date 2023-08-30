package com.example.wasaaaaa.models;

public class User {
    private Long userId;
    private Long personId;
    private String firstName;
    private String lastName;
    private String curp;
    private String  birthdate;
    private String email;
    private String password;
    private String status;
    private Long roleId;

    public User() {
    }

    public User(Long userId, Long personId, String firstName, String lastName, String curp, String birthdate, String email, String password, String status, Long roleId) {
        this.userId = userId;
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.curp = curp;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
