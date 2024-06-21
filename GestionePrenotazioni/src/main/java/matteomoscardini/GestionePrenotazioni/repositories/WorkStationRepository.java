package matteomoscardini.GestionePrenotazioni.repositories;

import matteomoscardini.GestionePrenotazioni.entities.WorkStation;
import matteomoscardini.GestionePrenotazioni.enums.WorkStationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {

    @Query("SELECT ele FROM WorkStation ele where ele.building.city=:city AND ele.type =:type")
    public List <WorkStation> findByCityAndType (String city, WorkStationType type);
}
