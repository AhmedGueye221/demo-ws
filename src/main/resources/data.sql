INSERT INTO LIVRES (titre, auteur, isbn, disponible) VALUES
('Le Petit Prince', 'Antoine de Saint-Exupéry', '978-2-07-040850-4', true),
('1984', 'George Orwell', '978-2-07-036822-8', true),
('L''Étranger', 'Albert Camus', '978-2-07-036002-4', false);

INSERT INTO UTILISATEURS (nom, email, role) VALUES
('John Doe', 'john@universite.edu', 'ETUDIANT'),
('Jane Smith', 'jane@universite.edu', 'PROFESSEUR');

INSERT INTO RESERVATION (date_debut, date_fin, utilisateur_id, livre_id) VALUES
('2025-05-01', '2025-05-15', 1, 1);