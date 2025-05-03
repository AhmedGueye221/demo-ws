package sn.courwebservice.demo_ws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.courwebservice.demo_ws.dto.LivresDTO;
import sn.courwebservice.demo_ws.service.LivresServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivresController {

    private final LivresServiceImpl livresService;

    public LivresController(LivresServiceImpl livresService) {
        this.livresService = livresService;
    }

    @GetMapping
    public ResponseEntity<List<LivresDTO>> getAllLivres() {
        List<LivresDTO> livres = livresService.getAllLivres();
        return ResponseEntity.ok(livres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivresDTO> getLivreById(@PathVariable Long id) {
        LivresDTO livre = livresService.getLivreById(id);
        return ResponseEntity.ok(livre);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<LivresDTO>> getLivresDisponibles() {
        List<LivresDTO> livresDisponibles = livresService.getLivresDisponibles();
        return ResponseEntity.ok(livresDisponibles);
    }
}