package matteomoscardini.GestionePrenotazioni.services;


import lombok.extern.slf4j.Slf4j;
import matteomoscardini.GestionePrenotazioni.entities.Booking;
import matteomoscardini.GestionePrenotazioni.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> searchAllBookings(){
        return (List<Booking>) bookingRepository.findAll();
    }

    public int searchByUserAndValidity(Long id, LocalDate validity) {
        int retList = bookingRepository.findByUserAndValidity(id, validity);
        log.info("@@@ The user has booked " + retList+ "workstation/s");
        return retList;
    }

    public int searchByWorkStationAndValidity(Long id, LocalDate validity){
        return bookingRepository.findByWorkstationAndValidity(id, validity);
    }

    public void create ( Booking booking ){
        int bookingsXUser = searchByUserAndValidity(booking.getUser().getId(), booking.getValidity());
        int bookingsXStation =searchByWorkStationAndValidity(booking.getWorkStation().getId(), booking.getValidity());

        if (bookingsXUser == 0) {
            if (bookingsXStation < booking.getWorkStation().getCapacity()) {
                bookingRepository.save(booking);

                log.info("*** " +booking.getUser().getUsername()+ " has booked his workstation." );
            } else {
                log.error("Sorry the workstation is already full");
            }
        } else {
            log.error("You have already booked a work station today");
        }
    }

    public Booking read (Long id) {
        return bookingRepository.findById(id).get();
    }

    public void update (Booking booking) {
        bookingRepository.save(booking);
    }

    public void delete (Long id) {
        bookingRepository.deleteById(id);
    }
}
