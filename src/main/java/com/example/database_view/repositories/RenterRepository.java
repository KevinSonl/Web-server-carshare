package com.example.database_view.repositories;

import com.example.database_view.models.Renter;
import com.example.database_view.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RenterRepository extends CrudRepository<Renter,Integer> {
  @Query("SELECT renter from Renter renter")
  public List<Renter> findAllRenters();
  @Query("SELECT renter from Renter renter where renter.id=:rid")
  public Renter findRenterById(Integer rid);
  @Query("SELECT renter from Renter renter where renter.username=:username")
  public Renter findRenterByName(String username);

}
