package com.example.database_view.repositories;

import com.example.database_view.models.Owner;
import com.example.database_view.models.Renter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Integer> {
  @Query("SELECT owner from Owner owner")
  public List<Owner> findAllOwners();
  @Query("SELECT owner from Owner owner where owner.id=:oid")
  public Owner findOwnerById(Integer oid);
  @Query("SELECT owner from Owner owner where owner.username=:username")
  public Owner findOwnerByName(String username);

//  @Query("SELECT renter from Renter renter where renter.id=:rid")
//  public Renter findRenterById(Integer rid);
//  @Query("SELECT renter from Renter renter where renter.username=:username")
//  public Renter findRenterByName(String username);

}
