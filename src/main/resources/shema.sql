DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS livres;
DROP TABLE IF EXISTS utilisateurs;

CREATE TABLE utilisateurs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE livres (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE reservation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    utilisateur_id BIGINT,
    livre_id BIGINT,
    CONSTRAINT fk_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateurs(id),
    CONSTRAINT fk_livre FOREIGN KEY (livre_id) REFERENCES livres(id)
);