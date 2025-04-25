package sn.courwebservice.demo_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sn.courwebservice.demo_ws.models.Livres;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livres, Long> {

    @Query("SELECT l FROM Livres l WHERE l.disponible = true")
    List<Livres> findAvailableLivres();
}
