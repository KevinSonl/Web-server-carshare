package com.example.database_view.services;

import com.example.database_view.models.Vehicle;
import com.example.database_view.repositories.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {
  private VehicleRepository vehicleRepository;

  @Autowired
  public VehicleService(VehicleRepository vr){
    vehicleRepository = vr;
  }

  public Vehicle createVehicle(Vehicle vehicle){
    vehicleRepository.save(vehicle);
    return vehicle;
  }

  public int updateVehicle(Integer vid, Vehicle vehicle){
    Vehicle v = vehicleRepository.findVehicleById(vid);
    if(v == null){
      return 0;
    }

    vehicle.setId(v.getId());
    vehicleRepository.save(vehicle);
    return 1;
  }

  public int deleteVehicle(Integer vid){
    Vehicle v = vehicleRepository.findVehicleById(vid);
    if(v == null){
      return 0;
    }
    vehicleRepository.deleteById(vid);
    return 1;
  }

  public List<Vehicle> findAllVehicles(){
    return vehicleRepository.findAllVehicles();
  }

  public Vehicle findVehicleById(Integer vid){
    return vehicleRepository.findVehicleById(vid);
  }

  public Vehicle findVehicleByVin(String vin){
    return vehicleRepository.findVehicleByVin(vin);
  }

  public List<Vehicle> findVehiclesByStyle(String style){
    return vehicleRepository.findVehiclesByStyle(style);
  }

  public List<Vehicle> findVehiclesByMake(String make){
    return vehicleRepository.findVehiclesByMake(make);
  }

  public List<Vehicle> findLatestVehicles(){
    List<Vehicle> list = vehicleRepository.findAllVehicles();
    List<Vehicle> result = new ArrayList<>();

    for(int i = list.size() - 1; i>=0; i--){
      result.add(list.get(i));
      if(result.size() >=8){
        break;
      }
    }

    return result;
  }

}

