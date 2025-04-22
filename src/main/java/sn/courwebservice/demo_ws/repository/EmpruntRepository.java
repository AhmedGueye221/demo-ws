package sn.courwebservice.demo_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.courwebservice.demo_ws.models.Emprunt;

public interface EmpruntRepository  extends JpaRepository<Emprunt, Long> {
    

}
