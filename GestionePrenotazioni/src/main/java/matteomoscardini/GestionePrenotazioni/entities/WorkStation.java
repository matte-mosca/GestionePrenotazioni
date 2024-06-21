package matteomoscardini.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import matteomoscardini.GestionePrenotazioni.enums.WorkStationType;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class WorkStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private WorkStationType type;
    private int capacity;

    @ManyToOne
    private Building building;

    public WorkStation(String description, WorkStationType type, int capacity) {
        this.description = description;
        this.type = type;
        this.capacity = capacity;
    }



}
