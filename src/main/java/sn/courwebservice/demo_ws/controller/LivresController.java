package sn.courwebservice.demo_ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.repository.LivreRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livres")
public class LivresController {

    @Autowired
    private LivreRepository livreRepository;

    // GET /livres : liste de tous les livres
    @GetMapping
    public List<Livres> getAllLivres() {
        return livreRepository.findAll();
    }

    // GET /livres/{id} : détails d'un livre
    @GetMapping("/{id}")
    public Livres getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    // GET /livres/disponibles : livres disponibles
    @GetMapping("/disponibles")
    public List<Livres> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }
}
