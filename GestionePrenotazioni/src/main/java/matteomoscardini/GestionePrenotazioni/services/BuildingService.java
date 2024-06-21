package matteomoscardini.GestionePrenotazioni.services;

import matteomoscardini.GestionePrenotazioni.entities.Building;
import matteomoscardini.GestionePrenotazioni.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> searchAllBuildings () {
        return (List<Building>) buildingRepository.findAll();
    }

    public void  create (Building building) {
        buildingRepository.save(building);
    }

    public Building read (Long id) {
        return buildingRepository.findById(id).get();
    }

    public void update (Building building){
        buildingRepository.save(building);
    }

    public void delete (Long id) {
        buildingRepository.deleteById(id);
    }

}
