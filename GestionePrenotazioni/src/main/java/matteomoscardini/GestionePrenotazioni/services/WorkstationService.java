package matteomoscardini.GestionePrenotazioni.services;

import matteomoscardini.GestionePrenotazioni.entities.WorkStation;
import matteomoscardini.GestionePrenotazioni.enums.WorkStationType;
import matteomoscardini.GestionePrenotazioni.repositories.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationService {

    @Autowired
    private WorkStationRepository workStationRepository;

    public List<WorkStation> searchWorkStation(String city, WorkStationType type) {
        return workStationRepository.findByCityAndType(city,type);
    }
    public List<WorkStation> searchAllWorkstations() {
        return (List<WorkStation>) workStationRepository.findAll();
    }

    public void create (WorkStation workStation) {
        workStationRepository.save(workStation);
    }

    public WorkStation read (Long id) {
       return workStationRepository.findById(id).get();
    }

    public void update (WorkStation workStation) {
        workStationRepository.save(workStation);
    }

    public void delete(Long id){
        workStationRepository.deleteById(id);
    }
}
