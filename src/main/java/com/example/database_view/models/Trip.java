package com.example.database_view.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trips")
public class Trip {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer vehicleId;
  private Integer renterId;
  private String startDate = "";
  private String endDate = "";
  private String make = "";
  private String model = "";
  private double fee = 0;
  private int days = 0;
  private int miles = 0;
  private double rate= 0;
  private boolean renterStatus=true;
  private boolean ownerStatus=true;
  private boolean renterFinishStatus=false;
  private boolean ownerFinishStatus=false;
  private boolean pending = true;

  public Trip() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Integer getRenterId() {
    return renterId;
  }

  public void setRenterId(Integer renterId) {
    this.renterId = renterId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public double getFee() {
    return fee;
  }

  public void setFee(double fee) {
    this.fee = fee;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }

  public int getMiles() {
    return miles;
  }

  public void setMiles(int miles) {
    this.miles = miles;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public boolean isRenterStatus() {
    return renterStatus;
  }

  public void setRenterStatus(boolean renterStatus) {
    this.renterStatus = renterStatus;
  }

  public boolean isOwnerStatus() {
    return ownerStatus;
  }

  public void setOwnerStatus(boolean ownerStatus) {
    this.ownerStatus = ownerStatus;
  }

  public boolean isRenterFinishStatus() {
    return renterFinishStatus;
  }

  public void setRenterFinishStatus(boolean renterFinishStatus) {
    this.renterFinishStatus = renterFinishStatus;
  }

  public boolean isOwnerFinishStatus() {
    return ownerFinishStatus;
  }

  public void setOwnerFinishStatus(boolean ownerFinishStatus) {
    this.ownerFinishStatus = ownerFinishStatus;
  }

  public boolean isPending() {
    return pending;
  }

  public void setPending(boolean pending) {
    this.pending = pending;
  }
}
