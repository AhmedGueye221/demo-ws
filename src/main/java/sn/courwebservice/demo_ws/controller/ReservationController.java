package sn.courwebservice.demo_ws.controller;

import org.apache.tomcat.jni.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.courwebservice.demo_ws.models.Reservation;
import sn.courwebservice.demo_ws.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    public final ReservationRepository reservationRepository;
    public final LibrarySOAP soapLibrary;


    public ReservationController(ReservationRepository reservationRepository, LibrarySOAP soapLibrary) {
        this.reservationRepository = reservationRepository;
        this.soapLibrary = soapLibrary;
    }

    // Suivi d'une réservation
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    
    

}
