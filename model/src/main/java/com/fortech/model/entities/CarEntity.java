package com.fortech.model.entities;

import com.fortech.model.dto.CarDto;
import com.fortech.model.dto.UserDto;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private String modelYear;
    private String fuel;
    private String transmission;
    private String description;
    private double tariff;

    public CarDto toDto() {
        CarDto dto = new CarDto();
        dto.setModel(this.model);
        dto.setModelYear(this.modelYear);
        dto.setFuel(this.fuel);
        dto.setTransmission(this.transmission);
        dto.setDescription(this.description);
        dto.setTariff(this.tariff);
        return dto;
    }

    public void update(CarDto carDto) {
        this.model = carDto.getModel();
        this.modelYear = carDto.getModelYear();
        this.fuel = carDto.getFuel();
        this.description = carDto.getDescription();
        this.transmission = carDto.getTransmission();
        this.tariff = carDto.getTariff();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }
}
