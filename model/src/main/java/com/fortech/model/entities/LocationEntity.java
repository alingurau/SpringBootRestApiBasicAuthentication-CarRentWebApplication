package com.fortech.model.entities;

import com.fortech.model.dto.LocationDto;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String address;
    private String zipcode;

    public LocationDto locationDto(){
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry(this.country);
        locationDto.setCity(this.city);
        locationDto.setAddress(this.address);
        locationDto.setZipcode(this.zipcode);
        return locationDto;
    }

    public void update(LocationDto locationDto){
        this.country = locationDto.getCountry();
        this.city = locationDto.getCity();
        this.address = locationDto.getAddress();
        this.zipcode = locationDto.getZipcode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
