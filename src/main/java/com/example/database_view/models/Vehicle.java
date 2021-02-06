package com.example.database_view.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String vin = "";
  private Integer ownerId;
  private double dailyPrice = 0;
  private String make = "";
  private String model;
  private String description;
  private String transmission;
  private int year = 0;
  private int seat = 0;
  private int mileage;
  private String renterHistory = "";
  private String style="";

  public Vehicle(){

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public double getDailyPrice() {
    return dailyPrice;
  }

  public void setDailyPrice(double dailyPrice) {
    this.dailyPrice = dailyPrice;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTransmission() {
    return transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getSeat() {
    return seat;
  }

  public void setSeat(int seat) {
    this.seat = seat;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public String getRenterHistory() {
    return renterHistory;
  }

  public void setRenterHistory(String renterHistory) {
    this.renterHistory = renterHistory;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }
}
