package matteomoscardini.GestionePrenotazioni.configurations;

import matteomoscardini.GestionePrenotazioni.entities.Building;
import matteomoscardini.GestionePrenotazioni.entities.WorkStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BuildingConf {

    @Autowired @Qualifier("workstation1") WorkStation w1;
    @Autowired @Qualifier("workstation2") WorkStation w2;
    @Autowired @Qualifier("workstation3") WorkStation w3;

    @Bean("building1")
    @Scope("singleton")
    public Building building1() {
        Building b1 = new Building("Sede Roma", "via dell'Areonautica, 134", "Roma");
        b1.addWorkStation(w1);
        b1.addWorkStation(w2);
        return b1;
    }
    @Bean("building2")
    @Scope("singleton")
    public Building building2() {
        Building b2 = new Building("Sede Milano", "viale Blignì, 98", "Milano");
        b2.addWorkStation(w3);
        return b2;
    }

}
