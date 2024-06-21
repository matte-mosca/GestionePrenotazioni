package matteomoscardini.GestionePrenotazioni.services;

import matteomoscardini.GestionePrenotazioni.entities.User;
import matteomoscardini.GestionePrenotazioni.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> searchAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void create (User user) {
        userRepository.save(user);
    }

    public User read (Long id) {
        return userRepository.findById(id).get();
    }
    public void update(User user) {
        userRepository.save(user);
    }
    public void delete (Long id){
        userRepository.deleteById(id);
    }
}
