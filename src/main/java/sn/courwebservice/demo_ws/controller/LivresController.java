package sn.courwebservice.demo_ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.repository.LivreRepository;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivresController {

    private final LivreRepository livreRepository;

    @Autowired
    public LivresController(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @GetMapping
    public List<Livres> getAllLivres() {
        return livreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livres getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));
    }

    @GetMapping("/disponibles")
    public List<Livres> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }
}