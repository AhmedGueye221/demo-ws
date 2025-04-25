package sn.courwebservice.demo_ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.repository.LivreRepository;



@RestController
@RequestMapping("/api/livres")
public class LivresController {

    
    final LivreRepository livreRepository ;

    public LivresController(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

     @GetMapping("/disponibles")
    public List<Livres> getLivresDisponibles() {
        return livreRepository.findAvailableLivres();
    }
    @GetMapping
    public List<Livres> getAllLivres() {
        return livreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livres getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id).orElse(null);
    }
    @PostMapping
    public ResponseEntity<Livres> createLivre(@RequestBody Livres livre) {
    Livres savedLivre = livreRepository.save(livre);
    return ResponseEntity.ok(savedLivre);
}


    public ResponseEntity<Livres> addLivre(@RequestBody Livres livre) {
    Livres savedLivre = livreRepository.save(livre);
    return ResponseEntity.ok(savedLivre);
}
}
