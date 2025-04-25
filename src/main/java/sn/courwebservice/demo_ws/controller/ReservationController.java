package sn.courwebservice.demo_ws.controller;

import org.springframework.web.bind.annotation.*;
import sn.courwebservice.demo_ws.models.Reservation;
import sn.courwebservice.demo_ws.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
}
