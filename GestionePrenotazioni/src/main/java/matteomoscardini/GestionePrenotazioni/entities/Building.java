package matteomoscardini.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "building_id")
    private List<WorkStation> workStations = new ArrayList<>();

    public Building (String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

}
