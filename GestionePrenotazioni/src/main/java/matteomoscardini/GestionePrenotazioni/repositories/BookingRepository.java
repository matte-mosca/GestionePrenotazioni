package matteomoscardini.GestionePrenotazioni.repositories;

import matteomoscardini.GestionePrenotazioni.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query ("SELECT count (*) FROM Booking ele WHERE ele.user.id =:id AND ele.validity=:validity")
    public int findByUserAndValidity(Long id, LocalDate validity);

    @Query("SELECT count(*) FROM Booking ele WHERE ele.workStation.id =:id AND ele.validity =:validity")
    public int findByWorkstationAndValidity(Long id, LocalDate validity);
}
