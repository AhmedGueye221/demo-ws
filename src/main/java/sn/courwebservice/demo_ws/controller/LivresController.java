package sn.courwebservice.demo_ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.repository.LivreRepository;

@RestController
@RequestMapping("/api/livres")
public class LivresController {

    
    final LivreRepository livreRepository ;

    public LivresController(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @GetMapping
    public List<Livres> getAllLivres() {
        return livreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livres getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id).orElse(null);
    }
}
