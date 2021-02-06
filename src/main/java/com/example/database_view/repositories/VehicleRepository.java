package com.example.database_view.repositories;

import com.example.database_view.models.Vehicle;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
  @Query("SELECT vehicle from Vehicle vehicle")
  public List<Vehicle> findAllVehicles();
  @Query("SELECT vehicle from Vehicle vehicle where vehicle.id=:vid")
  public Vehicle findVehicleById(Integer vid);
  @Query("SELECT vehicle from Vehicle vehicle where vehicle.vin=:vin")
  public Vehicle findVehicleByVin(String vin);
  @Query("SELECT vehicle from Vehicle vehicle where vehicle.style=:style")
  public List<Vehicle> findVehiclesByStyle(String style);
  @Query("SELECT vehicle from Vehicle vehicle where vehicle.make=:make")
  public List<Vehicle> findVehiclesByMake(String make);
}
