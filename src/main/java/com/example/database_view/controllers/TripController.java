package com.example.database_view.controllers;


import com.example.database_view.models.Trip;
import com.example.database_view.repositories.TripRepository;
import com.example.database_view.services.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins={"*"})
public class TripController {
  TripService tripService;

  @Autowired
  public TripController(TripRepository tr){
    tripService = new TripService(tr);
  }

  @PostMapping("/api/trips")
  public Trip createTrip(@RequestBody Trip trip){
    return tripService.createTrip(trip);
  }

  @PutMapping("/api/trips/{tid}")
  public int updateTrip(@PathVariable("tid") Integer tid,@RequestBody Trip trip){
    return tripService.updateTrip(tid,trip);
  }

  @DeleteMapping("/api/trips/{tid}")
  public int deleteTrip(@PathVariable("tid") Integer tid){
    return tripService.deleteTrip(tid);
  }

  @GetMapping("/api/trips")
  public List<Trip> findAllTrips(){
    return tripService.findAllTrips();
  }

  @GetMapping("/api/trips/{tid}")
  public Trip findTripById(@PathVariable("tid") Integer tid){
    return tripService.findTripById(tid);
  }
}
