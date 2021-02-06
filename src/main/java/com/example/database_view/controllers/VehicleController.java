package com.example.database_view.controllers;

import com.example.database_view.models.Trip;
import com.example.database_view.models.Vehicle;
import com.example.database_view.repositories.TripRepository;
import com.example.database_view.repositories.VehicleRepository;
import com.example.database_view.services.TripService;
import com.example.database_view.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins={"*"})
public class VehicleController {
  VehicleService vehicleService;
  TripService tripService;

  @Autowired
  public VehicleController(VehicleRepository vr, TripRepository tr){
    vehicleService = new VehicleService(vr);
    tripService = new TripService(tr);
  }

  @PostMapping("/api/vehicles")
  public Vehicle createVehicle(@RequestBody Vehicle vehicle){
    return vehicleService.createVehicle(vehicle);
  }

  @PutMapping("/api/vehicles/{vid}")
  public int updateVehicle(@PathVariable("vid") Integer vid, @RequestBody Vehicle vehicle){
    return vehicleService.updateVehicle(vid, vehicle);
  }

  @DeleteMapping("/api/vehicles/{vid}")
  public int deleteVehicle(@PathVariable("vid") Integer vid){
    return vehicleService.deleteVehicle(vid);
  }
  @GetMapping("/api/vehicles")
  public List<Vehicle> findAllVehicles(){
    return vehicleService.findAllVehicles();
  }
  @GetMapping("/api/vehicles/{vid}")
  public Vehicle findVehicleById(@PathVariable("vid") Integer vid){
    return vehicleService.findVehicleById(vid);
  }

  @GetMapping("/api/vehicles/vin/{vin}")
  public Vehicle findVehicleByVin(@PathVariable("vin") String vin){
    return vehicleService.findVehicleByVin(vin);
  }

  @GetMapping("/api/vehicles/style/{style}")
  public List<Vehicle> findVehicleByStyle(@PathVariable("style") String style){
    return vehicleService.findVehiclesByStyle(style);
  }

  @GetMapping("/api/vehicles/make/{make}")
  public List<Vehicle> findVehicleByMake(@PathVariable("make") String make){
    return vehicleService.findVehiclesByMake(make);
  }

  @GetMapping("/api/vehicles/latest")
  public List<Vehicle> findLatestVehicles(){
    return vehicleService.findLatestVehicles();
  }

  @GetMapping("/api/vehicles/{vid}/renter_history")
  public List<Trip> findRenterHistoryByVehicle(@PathVariable("vid") Integer vid){
    Vehicle v = vehicleService.findVehicleById(vid);
    List<Integer> list = splitString(v.getRenterHistory());

    List<Trip> result = new ArrayList<>();
    for(Integer i: list){
      result.add(tripService.findTripById(i));
    }
    return result;
  }

  private List<Integer> splitString(String s){
    List<Integer> result = new ArrayList<>();
    if(s.equals("")){
      return result;
    }
    String[] list = s.split("/");
    for(int i = 0; i< list.length;i++){
      result.add(Integer.parseInt(list[i]));
    }
    return result;
  }
}
