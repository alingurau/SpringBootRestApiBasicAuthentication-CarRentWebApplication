package com.fortech.model.dto;

import com.fortech.model.entities.RoleEntity;

import java.util.Set;

public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Set<RoleEntity> roleName;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public Set<RoleEntity> getRoleName() {
        return roleName;
    }

    public void setRoleName(Set<RoleEntity> roleName) {
        this.roleName = roleName;
    }
}
