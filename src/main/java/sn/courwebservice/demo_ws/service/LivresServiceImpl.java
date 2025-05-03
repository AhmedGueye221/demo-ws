package sn.courwebservice.demo_ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import sn.courwebservice.demo_ws.dto.LivresDTO;
import sn.courwebservice.demo_ws.mapper.LivresMapper;
import sn.courwebservice.demo_ws.models.Livres;
import sn.courwebservice.demo_ws.repository.LivreRepository;

@Service
public class LivresServiceImpl {
    private final LivresMapper mapper = LivresMapper.INSTANCE;
    private final LivreRepository livreRepository ;


    public LivresServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public LivresDTO toLivreDTO(Livres livre) {
        return mapper.toDto(livre);
    }

    public Livres toLivre(LivresDTO livreDTO) {
        return mapper.toEntity(livreDTO);
    }

    public LivresDTO getLivreById(Long id) {
        // Récupérer le livre par son ID de la base de données
        Livres livre = livreRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        // Mapper l'entité Livre en LivresDTO
        return mapper.toDto(livre);
    }

    public List<LivresDTO> getAllLivres() {
        // Récupérer tous les livres de la base de données
        // et les mapper en LivresDTO       
        return livreRepository.findAll().stream()
                .map(livre -> mapper.toDto(livre))
                .collect(Collectors.toList());
    }

    public List<LivresDTO> getLivresDisponibles() {
        // Récupérer les livres disponibles de la base de données
        List<Livres> livresDisponibles = livreRepository.findByDisponibleTrue();
        // Mapper les livres disponibles en LivresDTO
        return livresDisponibles.stream()
                .map(livre -> mapper.toDto(livre))
                .collect(Collectors.toList());
    }
}