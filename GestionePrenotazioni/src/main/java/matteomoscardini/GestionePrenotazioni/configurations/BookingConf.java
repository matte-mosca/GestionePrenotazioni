package matteomoscardini.GestionePrenotazioni.configurations;

import matteomoscardini.GestionePrenotazioni.entities.Booking;
import matteomoscardini.GestionePrenotazioni.entities.User;
import matteomoscardini.GestionePrenotazioni.entities.WorkStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class BookingConf {

    @Autowired @Qualifier("workstation1")
    WorkStation w1;
    @Autowired @Qualifier("workstation2")
    WorkStation w2;
    @Autowired @Qualifier("workstation3")
    WorkStation w3;

    @Autowired @Qualifier("user1")
    User u1;
    @Autowired @Qualifier("user2")
    User u2;
    @Autowired @Qualifier("user3")
    User u3;

    @Bean("booking1")
    @Scope("singleton")
    public Booking booking1(){
        return new Booking(w1, u1, LocalDate.now());
    }

    @Bean("booking1")
    @Scope("singleton")
    public Booking booking2() {
        return new Booking(w2, u2, LocalDate.now());
    }

    @Bean("booking1")
    @Scope("singleton")
    public Booking booking3() {
        return new Booking(w3, u3, LocalDate.now());
    }

}
