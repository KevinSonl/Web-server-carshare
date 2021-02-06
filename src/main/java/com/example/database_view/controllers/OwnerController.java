package com.example.database_view.controllers;

import com.example.database_view.models.Owner;
import com.example.database_view.models.Trip;
import com.example.database_view.models.Vehicle;
import com.example.database_view.repositories.OwnerRepository;
import com.example.database_view.repositories.TripRepository;
import com.example.database_view.repositories.VehicleRepository;
import com.example.database_view.services.OwnerService;
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
public class OwnerController {
  OwnerService ownerService;
  VehicleService vehicleService;
  TripService tripService;

  @Autowired
  public OwnerController(OwnerRepository owr, VehicleRepository vr, TripRepository tr){
    ownerService = new OwnerService(owr);
    vehicleService = new VehicleService(vr);
    tripService = new TripService(tr);
  }

  @PostMapping("/api/users/owners")
  public Owner createOwner(@RequestBody Owner owner){
    return ownerService.createOwner(owner);
  }

  @PutMapping("/api/users/owners/{oid}")
  public int updateOwner(@PathVariable("oid") Integer oid, @RequestBody Owner owner){
    return ownerService.updateOwner(oid,owner);
  }

  @DeleteMapping("/api/users/owners/{oid}")
  public int deleteOwner(@PathVariable("oid") Integer oid){
    return ownerService.deleteOwner(oid);
  }

  @GetMapping("/api/users/owners")
  public List<Owner> findAllOwners(){
    return  ownerService.findAllOwners();
  }

  @GetMapping("/api/users/owners/{oid}")
  public Owner findOwnerById(@PathVariable("oid") Integer oid){
    return ownerService.findOwnerById(oid);
  }

  @GetMapping("/api/users/owners/username/{username}")
  public Owner findOwnerByName(@PathVariable("username") String username){
    return ownerService.findOwnerByName(username);
  }

  @GetMapping("/api/users/owners/{oid}/vehicles")
  public List<Vehicle> findVehiclesByUser(@PathVariable("oid") Integer oid){
    Owner o = ownerService.findOwnerById(oid);

    List<Integer> list = splitString(o.getVehicles());
    List<Vehicle> result = new ArrayList<>();

    for(Integer i: list){
      result.add(vehicleService.findVehicleById(i));
    }

    return result;
  }

  @GetMapping("/api/users/owners/{oid}/rent_history")
  public List<Trip> findRentHistoryByUser(@PathVariable("oid") Integer oid){
    Owner o = ownerService.findOwnerById(oid);
    List<Integer> list = splitString(o.getRentHistory());
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

