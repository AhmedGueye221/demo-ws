package sn.courwebservice.demo_ws.soap;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import sn.courwebservice.demo_ws.*;
import sn.courwebservice.demo_ws.repository.LivreRepository;
import sn.courwebservice.demo_ws.repository.EmpruntRepository;
import sn.courwebservice.demo_ws.repository.UtilisateurRepository;
import sn.courwebservice.demo_ws.models.Emprunt;
import sn.courwebservice.demo_ws.models.Livres;

@Endpoint
public class BibliothequeEndpoint {

    private static final String NAMESPACE_URI = "http://courwebservice.sn/demo-ws";

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ajouterLivreRequest")
    @ResponsePayload
    public AjouterLivreResponse ajouterLivre(@RequestPayload AjouterLivreRequest request) {
        // Convertir le Livre SOAP en Livres JPA
        Livres nouveauLivre = new Livres();
        nouveauLivre.setTitre(request.getLivre().getTitre());
        nouveauLivre.setAuteur(request.getLivre().getAuteur());
        nouveauLivre.setIsbn(request.getLivre().getIsbn());
        nouveauLivre.setDisponible(request.getLivre().isDisponible());

        // Sauvegarder dans la base de données
        Livres livreSauvegarde = livreRepository.save(nouveauLivre);

        // Créer la réponse
        AjouterLivreResponse response = new AjouterLivreResponse();
        Livre livreResponse = new Livre();
        livreResponse.setId(livreSauvegarde.getId());
        livreResponse.setTitre(livreSauvegarde.getTitre());
        livreResponse.setAuteur(livreSauvegarde.getAuteur());
        livreResponse.setIsbn(livreSauvegarde.getIsbn());
        livreResponse.setDisponible(livreSauvegarde.isDisponible());
        response.setLivre(livreResponse);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "modifierLivreRequest")
    @ResponsePayload
    public ModifierLivreResponse modifierLivre(@RequestPayload ModifierLivreRequest request) {
        ModifierLivreResponse response = new ModifierLivreResponse();
        
        try {
            // Rechercher le livre existant
            Livres livreExistant = livreRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));

            // Mettre à jour les données
            livreExistant.setTitre(request.getLivre().getTitre());
            livreExistant.setAuteur(request.getLivre().getAuteur());
            livreExistant.setIsbn(request.getLivre().getIsbn());
            livreExistant.setDisponible(request.getLivre().isDisponible());

            // Sauvegarder les modifications
            Livres livreMisAJour = livreRepository.save(livreExistant);

            // Préparer la réponse
            Livre livreResponse = new Livre();
            livreResponse.setId(livreMisAJour.getId());
            livreResponse.setTitre(livreMisAJour.getTitre());
            livreResponse.setAuteur(livreMisAJour.getAuteur());
            livreResponse.setIsbn(livreMisAJour.getIsbn());
            livreResponse.setDisponible(livreMisAJour.isDisponible());
            
            response.setLivre(livreResponse);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la modification du livre: " + e.getMessage());
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "supprimerLivreRequest")
    @ResponsePayload
   public SupprimerLivreResponse supprimerLivre(@RequestPayload SupprimerLivreRequest request) {
    SupprimerLivreResponse response = new SupprimerLivreResponse();
    try {
        // Supprimer d'abord les emprunts associés
        Livres livre = livreRepository.findById(request.getId())
            .orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        empruntRepository.deleteByLivre(livre);
        
        // Puis supprimer le livre
        livreRepository.deleteById(request.getId());
        response.setSuccess(true);
    } catch (Exception e) {
        response.setSuccess(false);
    }
    return response;
}
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "preterLivreRequest")
    @ResponsePayload
    public PreterLivreResponse preterLivre(@RequestPayload PreterLivreRequest request) {
        PreterLivreResponse response = new PreterLivreResponse();
        try {
            // Vérifier le livre
            Livres livre = livreRepository.findById(request.getLivreId())
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));

            if (!livre.isDisponible()) {
                throw new RuntimeException("Le livre n'est pas disponible");
            }

            // Créer l'emprunt
            Emprunt emprunt = new Emprunt();
            emprunt.setLivre(livre);
            emprunt.setDateEmprunt(LocalDate.now());
            emprunt.setUtilisateur(utilisateurRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé")));

            // Marquer le livre comme non disponible
            livre.setDisponible(false);
            livreRepository.save(livre);

            // Sauvegarder l'emprunt
            empruntRepository.save(emprunt);
            
            response.setSuccess(true);
        } catch (Exception e) {
            response.setSuccess(false);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "retournerLivreRequest")
    @ResponsePayload
 public RetournerLivreResponse retournerLivre(@RequestPayload RetournerLivreRequest request) {
    RetournerLivreResponse response = new RetournerLivreResponse();
    try {
        // Chercher et mettre à jour le livre
        Livres livre = livreRepository.findById(request.getLivreId())
            .orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        livre.setDisponible(true);
        livreRepository.save(livre);

        // Mettre à jour l'emprunt
        Emprunt emprunt = empruntRepository.findByLivre(livre)
            .orElseThrow(() -> new RuntimeException("Emprunt non trouvé"));
        emprunt.setDateRetour(LocalDate.now());
        empruntRepository.save(emprunt);

        response.setSuccess(true);
    } catch (Exception e) {
        response.setSuccess(false);
    }
    return response;
}
}