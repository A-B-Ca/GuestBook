package springbooot.databaseproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbooot.databaseproj.entities.Guest;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Integer> {
    public Optional<Guest> findByfName(String fName);
    public void deleteById(Integer id);


}
