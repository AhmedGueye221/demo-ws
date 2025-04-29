package sn.courwebservice.demo_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import sn.courwebservice.demo_ws.models.Emprunt;
import sn.courwebservice.demo_ws.models.Livres;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    Optional<Emprunt> findByLivre(Livres livre);
     void deleteByLivre(Livres livre);
}