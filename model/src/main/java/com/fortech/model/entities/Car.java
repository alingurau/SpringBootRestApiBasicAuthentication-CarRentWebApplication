package com.fortech.model.entities;

import com.fortech.model.dto.CarDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "model_year")
    private String modelYear;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "description")
    private String description;
    @Column(name = "tariff")
    private double tariff;

    public CarDto carDto(){
        CarDto car = new CarDto();
        car.setModel(this.model);
        car.setModelYear(this.modelYear);
        car.setFuel(this.fuel);
        car.setTransmission(this.transmission);
        car.setDescription(this.description);
        car.setTariff(this.tariff);
        return car;
    }

    public void update(CarDto carDto){
        this.model = carDto.getModel();
        this.modelYear = carDto.getModelYear();
        this.fuel = carDto.getFuel();
        this.transmission = carDto.getTransmission();
        this.description = carDto.getDescription();
        this.tariff=carDto.getTariff();
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
