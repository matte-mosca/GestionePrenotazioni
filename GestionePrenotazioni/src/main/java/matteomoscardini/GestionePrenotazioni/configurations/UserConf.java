package matteomoscardini.GestionePrenotazioni.configurations;

import matteomoscardini.GestionePrenotazioni.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserConf {

    @Bean("user1")
    @Scope("singleton")
    public User user1(){
        return new User("user1", "Giovanni Paolini", "giovannip@gmail.com");
    }

    @Bean("user2")
    @Scope("singleton")
    public User user2(){
        return new User("user2", "Pietro Spanedda", "pietros@gmail.com");
    }

    @Bean("user3")
    @Scope("singleton")
    public User user3 (){
        return new User("user3", "Simone Colanti", "simonec@gmail.com");
    }

}

