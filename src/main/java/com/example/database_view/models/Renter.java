package com.example.database_view.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="renters")
public class Renter{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username = "";
  private String email = "";
  private String password = "";
  private String dateOfBirth = "";
  private String firstName = "";
  private String lastName = "";
  private String gender = "";
  private String license = "";
  private double rate = 0;
  private String tripHistory = "";
  private String vehicleHistory = "";
  private String likeList = "";
  private String type="Renter";


  public Renter() {
  }

//  public Renter(String username, String email,String password, String dateOfBirth,
//                String firstName, String lastName, String license){
//    this.username = username;
//    this.email = email;
//    this.password = password;
//    this.dateOfBirth = dateOfBirth;
//    this.firstName = firstName;
//    this.lastName = lastName;
//    this.license = license;
//  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getTripHistory() {
    return tripHistory;
  }

  public void setTripHistory(String tripHistory) {
    this.tripHistory = tripHistory;
  }

  public String getVehicleHistory() {
    return vehicleHistory;
  }

  public void setVehicleHistory(String vehicleHistory) {
    this.vehicleHistory = vehicleHistory;
  }

  public String getLikeList() {
    return likeList;
  }

  public void setLikeList(String likeList) {
    this.likeList = likeList;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
