package com.example.database_view.services;

import com.example.database_view.models.Owner;
import com.example.database_view.models.Renter;
import com.example.database_view.repositories.OwnerRepository;
import com.example.database_view.repositories.RenterRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OwnerService {
  private OwnerRepository ownerRepository;

  @Autowired
  public OwnerService(OwnerRepository owr){
    ownerRepository = owr;
  }

  public Owner createOwner(Owner owner){
    ownerRepository.save(owner);
    return owner;
  }

  public int updateOwner(Integer oid, Owner owner){
    Owner o = ownerRepository.findOwnerById(oid);
    if(o == null){
      return 0;
    }

    owner.setId(o.getId());
    ownerRepository.save(owner);
    return 1;
  }

  public int deleteOwner(Integer oid){
    Owner o = ownerRepository.findOwnerById(oid);
    if(o == null){
      return 0;
    }
    ownerRepository.deleteById(oid);
    return 1;
  }

  public List<Owner> findAllOwners(){
    return ownerRepository.findAllOwners();
  }

  public Owner findOwnerById(Integer oid){
    return ownerRepository.findOwnerById(oid);
  }

  public Owner findOwnerByName(String username){
    return ownerRepository.findOwnerByName(username);
  }
}
