package springbooot.databaseproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springbooot.databaseproj.entities.Address;
import springbooot.databaseproj.repository.AddressRepo;
import springbooot.databaseproj.repository.GuestRepo;
import springbooot.databaseproj.entities.Guest;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    GuestRepo repo;
    @Autowired
    AddressRepo addressRepo;
    public Optional<Guest> getG(Integer id){
        return repo.findById(id);
    }

    public Optional<Guest> deleteGuestById(Guest guest){
        Optional<Guest> guestById = getG(guest.getId());
        if(guestById.isPresent()){
            repo.deleteById(guest.getId());
            return guestById;
        }
        return Optional.empty();
    }
    public Guest add(Guest guest){
        /*Address address = addressRepo.save(guest.getAddress());
        guest.setAddress(address);*/

        return repo.save(guest);
    }
    public List<Guest> all(){
        return repo.findAll();
    }
    public Optional<Guest> findbyId(Integer  id){
        return repo.findById(id);
    }
    public ResponseEntity<Guest> findByFName(String fName){
        Optional<Guest> byfName = repo.findByfName(fName);
        if (byfName.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).header("Content Found","Displaying Content").body(byfName.get());

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Error Message","Not Found").build();
    }
    public ResponseEntity<Guest> delbyId(Integer id){
        Optional<Guest> byId = repo.findById(id);
        if (byId.isPresent()) {



           // addressRepo.deleteAddressByAddressId(byId.get().getAddress().getAddressId());
            repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).header("Content Deleted","Deleted Guest with ID:"+id).body(byId.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Content not found","Cannot find Guest with GuestID"+id).build();
        }

    }
}
