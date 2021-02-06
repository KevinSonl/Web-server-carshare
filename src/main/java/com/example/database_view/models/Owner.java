package com.example.database_view.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owners")
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String email;
  private String password;
  private String firstName = "";
  private String lastName = "";
  private String gender = "";
  private double rate = 0;
  private String vehicles = "";
  private String rentHistory = "";
  private String type="Owner";

  public Owner(){

  }

//  public Owner(String username, String email, String password){
//    this.username = username;
//    this.email = email;
//    this.password = password;
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

  public String getVehicles() {
    return vehicles;
  }

  public void setVehicles(String vehicles) {
    this.vehicles = vehicles;
  }

  public String getRentHistory() {
    return rentHistory;
  }

  public void setRentHistory(String rentHistory) {
    this.rentHistory = rentHistory;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
