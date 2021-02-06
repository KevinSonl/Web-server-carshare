package com.example.database_view.services;


import com.example.database_view.models.Trip;
import com.example.database_view.repositories.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TripService {
  private TripRepository tripRepository;

  @Autowired
  public TripService(TripRepository tr){
    tripRepository = tr;
  }

  public Trip createTrip(Trip trip){
    tripRepository.save(trip);
    return trip;
  }

  public int updateTrip(Integer tid, Trip trip){
    Trip t = tripRepository.findTripById(tid);
    if(t == null){
      return 0;
    }

    trip.setId(t.getId());
    tripRepository.save(trip);
    return 1;
  }

  public int deleteTrip(Integer tid){
    Trip t = tripRepository.findTripById(tid);
    if(t == null){
      return 0;
    }
    tripRepository.deleteById(tid);
    return 1;
  }

  public List<Trip> findAllTrips(){
    return tripRepository.findAllTrips();
  }

  public Trip findTripById(Integer tid){
    return tripRepository.findTripById(tid);
  }
}
