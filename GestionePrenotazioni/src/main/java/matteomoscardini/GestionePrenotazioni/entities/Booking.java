package matteomoscardini.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate validity;

    @ManyToOne
    private WorkStation workStation;
    @ManyToOne
    private User user;

    public Booking(WorkStation workStation, User user, LocalDate validity) {
        this.workStation = workStation;
        this.user=user;
        this.validity = validity;
    }

}
