package com.example.database_view.repositories;

import com.example.database_view.models.Trip;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Integer> {
  @Query("SELECT trip from Trip trip")
  public List<Trip> findAllTrips();
  @Query("SELECT trip from Trip trip where trip.id=:tid")
  public Trip findTripById(Integer tid);
}


//public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
//  @Query("SELECT vehicle from Vehicle vehicle")
//  public List<Vehicle> findAllVehicles();
//  @Query("SELECT vehicle from Vehicle vehicle where vehicle.id=:vid")
//  public Vehicle findVehicleById(Integer vid);
//  @Query("SELECT vehicle from Vehicle vehicle where vehicle.vin=:vin")
//  public Vehicle findVehicleByVin(String vin);
//
//}
