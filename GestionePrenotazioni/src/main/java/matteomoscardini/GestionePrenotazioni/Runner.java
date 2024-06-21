package matteomoscardini.GestionePrenotazioni;


import lombok.extern.slf4j.Slf4j;
import matteomoscardini.GestionePrenotazioni.configurations.BookingConf;
import matteomoscardini.GestionePrenotazioni.configurations.BuildingConf;
import matteomoscardini.GestionePrenotazioni.configurations.UserConf;
import matteomoscardini.GestionePrenotazioni.configurations.WorkstationConf;
import matteomoscardini.GestionePrenotazioni.entities.User;
import matteomoscardini.GestionePrenotazioni.services.BookingService;
import matteomoscardini.GestionePrenotazioni.services.BuildingService;
import matteomoscardini.GestionePrenotazioni.services.UserService;
import matteomoscardini.GestionePrenotazioni.services.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class Runner implements ApplicationRunner {

    @Autowired
    BuildingService buildingService;
    @Autowired
    BuildingConf buildingConf;

    @Autowired
    BookingService bookingService;
    @Autowired
    BookingConf bookingConf;

    @Autowired
    UserService userService;
    @Autowired
    UserConf userConf;

    @Autowired
    WorkstationService workstationService;
    @Autowired
    WorkstationConf workstationConf;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application Started");


        //Creation of buildings with Workstations
        buildingService.create(buildingConf.building1());
        buildingService.create(buildingConf.building2());

        // Creation of users
        userService.create(userConf.user1());
        userService.create(userConf.user2());
        userService.create(userConf.user3());

        //User1 and User2 Bookings
        bookingService.create(bookingConf.booking1());
        bookingService.create(bookingConf.booking2());
        bookingService.create(bookingConf.booking3());


    }
}
