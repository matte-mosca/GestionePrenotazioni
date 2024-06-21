package matteomoscardini.GestionePrenotazioni.configurations;

import matteomoscardini.GestionePrenotazioni.entities.WorkStation;
import matteomoscardini.GestionePrenotazioni.enums.WorkStationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WorkstationConf {
    @Bean("workstation1")
    @Scope("singleton")
    public WorkStation workStation1(){
        return new WorkStation("Digital Marketing Meeting Room", WorkStationType.MEETING_ROOM, 30);
    }

    @Bean("workstation2")
    @Scope("singleton")
    public WorkStation workStation2 (){
        return new WorkStation("Management Office", WorkStationType.PRIVATE, 1 );
    }

    @Bean("workstation3")
    @Scope("singleton")
    public WorkStation workStation3(){
        return new WorkStation("Morning Brainstorming Room", WorkStationType.OPENSPACE, 40);
    }

}
