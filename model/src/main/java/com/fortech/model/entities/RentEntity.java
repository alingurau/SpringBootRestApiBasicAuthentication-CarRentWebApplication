package com.fortech.model.entities;

import com.fortech.model.dto.RentDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "rent")
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private CarEntity carId;

    @ManyToOne
    private UserEntity userId;

    public RentDto toDto() {
        RentDto dto = new RentDto();
        dto.setStartDate(this.startDate);
        dto.setEndDate(this.endDate);
        return dto;
    }

    public void update(RentDto rentDto){
        this.startDate=rentDto.getStartDate();
        this.endDate = rentDto.getEndDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CarEntity getCarId() {
        return carId;
    }

    public void setCarId(CarEntity carId) {
        this.carId = carId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }
}
