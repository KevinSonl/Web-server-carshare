package com.example.database_view.services;

import com.example.database_view.models.Renter;
import com.example.database_view.repositories.RenterRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RenterService {
  private RenterRepository renterRepository;

  @Autowired
  public RenterService(RenterRepository rr){
    renterRepository = rr;
  }

  public Renter createRenter(Renter renter){
    renterRepository.save(renter);
    return renter;
  }

  public int updateRenter(Integer rid, Renter renter){
    Renter r = renterRepository.findRenterById(rid);
    if(r == null){
      return 0;
    }
    renter.setId(r.getId());

    renterRepository.save(renter);
    return 1;
  }

  public int deleteRenter(Integer rid){
    Renter r = renterRepository.findRenterById(rid);
    if(r == null){
      return 0;
    }
    renterRepository.deleteById(rid);
    return 1;
  }

  public List<Renter> findAllRenters(){
    return renterRepository.findAllRenters();
  }

  public Renter findRenterById(Integer rid){
    return renterRepository.findRenterById(rid);
  }

  public Renter findRenterByName(String username){
    return renterRepository.findRenterByName(username);
  }


}
//  public List<Renter> findAllRenters(){
//    List<User> list = userRepository.findUsersByType("Renter");
//    List<Renter> result = new ArrayList<>();
//    for(int i = 0; i< list.size();i++){
//      result.add((Renter)list.get(i));
//    }
//    return result;
//  }
//  //
//  public Renter findRenterById(Integer uid){
//    User u = userRepository.findUserById(uid);
//    if(u.getType().equals("Renter")){
//      return (Renter)u;
//    }else{
//      return null;
//    }
//  }
////  public List<Widget> findAllWidgets(){
////    return widgetRepository.findAllWidgets();
////  }
//}
