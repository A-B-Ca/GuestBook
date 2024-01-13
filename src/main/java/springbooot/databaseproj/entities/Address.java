package springbooot.databaseproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String streetName;
}
