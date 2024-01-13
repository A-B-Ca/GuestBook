package springbooot.databaseproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbooot.databaseproj.entities.Address;
import springbooot.databaseproj.repository.AddressRepo;
import springbooot.databaseproj.repository.GuestRepo;
import springbooot.databaseproj.entities.Guest;
import springbooot.databaseproj.service.GuestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class GuestController {
    /*@Autowired
    GuestRepo repo;*/
    @Autowired
    GuestService service;
    /*@Autowired
    AddressRepo addressRepo;*/
    @GetMapping("all")
    public List<Guest> hello(){
        List<Guest> allguest = service.all();
        return allguest;
    }
    @PostMapping("add")
    public Guest addorUpdate(@RequestBody Guest guest){
        Guest guest1 = service.add(guest);
        return guest1;
    }
    @GetMapping("byid/{id}")
    public Optional<Guest> byid(@PathVariable Integer id){
        Optional<Guest> guest = service.findbyId(id);
        return guest;
    }
    @GetMapping("name/{name}")
    public ResponseEntity<Guest> name(@PathVariable String name){
        ResponseEntity<Guest> byFName = service.findByFName(name);
        return byFName;
    }
    @PostMapping("del")
    public Optional<Guest> del(@RequestBody Guest guest){
        Optional<Guest> guest1 = service.deleteGuestById(guest);
        return guest1;
    }
    @PostMapping("delbyId/{id}")
    public ResponseEntity<Guest> delbyId(@PathVariable Integer id){
        ResponseEntity<Guest> guestResponseEntity = service.delbyId(id);
        return guestResponseEntity;
    }

}
