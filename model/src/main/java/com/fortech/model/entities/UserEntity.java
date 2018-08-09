package com.fortech.model.entities;

import com.fortech.model.dto.UserDto;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setFirstName(this.firstName);
        dto.setLastName(this.lastName);
        dto.setEmail(this.email);
        dto.setUsername(this.username);
        dto.setPassword(this.password);
        return dto;
    }

    public void update(UserDto userDto){
        this.firstName = userDto.getFirstName();
        this.lastName=userDto.getLastName();
        this.email=userDto.getEmail();
        this.username=userDto.getUsername();
        this.password=userDto.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
