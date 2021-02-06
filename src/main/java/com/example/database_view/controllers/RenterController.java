package com.example.database_view.controllers;

import com.example.database_view.models.Renter;
import com.example.database_view.models.Trip;
import com.example.database_view.models.Vehicle;
import com.example.database_view.repositories.RenterRepository;
import com.example.database_view.repositories.TripRepository;
import com.example.database_view.repositories.VehicleRepository;
import com.example.database_view.services.RenterService;
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
public class RenterController {
  RenterService renterService;
  VehicleService vehicleService;
  TripService tripService;

  @Autowired
  public RenterController(RenterRepository rr, VehicleRepository vr, TripRepository tr){

    renterService = new RenterService(rr);
    vehicleService = new VehicleService(vr);
    tripService = new TripService(tr);
  }

  @PostMapping("/api/users/renters")
  public Renter createRenter(@RequestBody Renter renter){
    return renterService.createRenter(renter);
  }

  @PutMapping("/api/users/renters/{rid}")
  public int updateRenter(@PathVariable("rid") Integer rid, @RequestBody Renter renter){
    return renterService.updateRenter(rid,renter);
  }

  @DeleteMapping("/api/users/renters/{rid}")
  public int deleteRenter(@PathVariable("rid") Integer rid){
    return renterService.deleteRenter(rid);
  }

  @GetMapping("/api/users/renters")
  public List<Renter> findAllRenters(){
    return renterService.findAllRenters();
  }

  @GetMapping("/api/users/renters/{rid}")
  public Renter findRenterById(@PathVariable("rid") Integer rid){
    return renterService.findRenterById(rid);
  }

  @GetMapping("/api/users/renters/username/{username}")
  public Renter findRenterByName(@PathVariable("username") String username){
    return renterService.findRenterByName(username);
  }

  @GetMapping("/api/users/renters/{rid}/trip_history")
  public List<Trip> findTripHistoryByUser(@PathVariable("rid") Integer rid){
    Renter r = renterService.findRenterById(rid);
    List<Integer> list = splitString(r.getTripHistory());
    List<Trip> result = new ArrayList<>();
    for(Integer i: list){
      result.add(tripService.findTripById(i));
    }
    return result;
  }

  @GetMapping("/api/users/renters/{rid}/vehicle_history")
  public List<Vehicle> findVehicleHistoryByUser(@PathVariable("rid") Integer rid){
    Renter r = renterService.findRenterById(rid);
    List<Integer> list = splitString(r.getVehicleHistory());
    List<Vehicle> result = new ArrayList<>();

    for(Integer i: list){
      result.add(vehicleService.findVehicleById(i));
    }

    return result;
  }

  @GetMapping("/api/users/renters/{rid}/like")
  public List<Vehicle> findLikeListByUser(@PathVariable("rid") Integer rid){
    Renter r = renterService.findRenterById(rid);
    List<Integer> list = splitString(r.getLikeList());
    List<Vehicle> result = new ArrayList<>();

    for(Integer i: list){
      Vehicle v = vehicleService.findVehicleById(i);
      if(v != null){
        result.add(v);
      }
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
