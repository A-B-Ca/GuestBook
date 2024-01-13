package springbooot.databaseproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbooot.databaseproj.entities.Address;
import springbooot.databaseproj.entities.Guest;

import java.util.Optional;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    public Optional<Address> deleteAddressByAddressId(Integer id);

}
