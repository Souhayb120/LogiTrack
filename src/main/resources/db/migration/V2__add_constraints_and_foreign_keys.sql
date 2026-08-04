-- V2: Add NOT NULL / UNIQUE constraints and foreign keys
-- Target: MySQL syntax (adjust MODIFY -> ALTER COLUMN ... SET NOT NULL for PostgreSQL)

-- client
ALTER TABLE client
    MODIFY nom VARCHAR(255) NOT NULL,
    MODIFY email VARCHAR(255) NOT NULL,
    ADD CONSTRAINT uq_client_email UNIQUE (email);

ALTER TABLE produit
    MODIFY nom VARCHAR(255) NOT NULL,
    MODIFY prix DOUBLE NOT NULL,
    MODIFY quantite_stock INT NOT NULL DEFAULT 0;

ALTER TABLE commande
    MODIFY status VARCHAR(50) NOT NULL,
    MODIFY client_id INT NOT NULL,
    ADD CONSTRAINT fk_commande_client
    FOREIGN KEY (client_id) REFERENCES client(id)
    ON DELETE CASCADE;

ALTER TABLE ligne_commande
    MODIFY quantite INT NOT NULL,
    MODIFY produit_id INT NOT NULL,
    MODIFY commande_id INT NOT NULL,
    ADD CONSTRAINT fk_lignecommande_produit
    FOREIGN KEY (produit_id) REFERENCES produit(id)
    ON DELETE CASCADE,
    ADD CONSTRAINT fk_lignecommande_commande
        FOREIGN KEY (commande_id) REFERENCES commande(id)
        ON DELETE CASCADE;


ALTER TABLE user_entity
    MODIFY user_name VARCHAR(255) NOT NULL,
    MODIFY email VARCHAR(255) NOT NULL,
    MODIFY password VARCHAR(255) NOT NULL,
    MODIFY role VARCHAR(50) NOT NULL,
    ADD CONSTRAINT uq_user_email UNIQUE (email),
    ADD CONSTRAINT uq_user_username UNIQUE (user_name);

ALTER TABLE admin
    ADD CONSTRAINT fk_admin_user
        FOREIGN KEY (id)
            REFERENCES user_entity(id)
            ON DELETE CASCADE;

ALTER TABLE manager
    ADD CONSTRAINT fk_manager_user
        FOREIGN KEY (id)
            REFERENCES user_entity(id)
            ON DELETE CASCADE;

ALTER TABLE agent
    ADD CONSTRAINT fk_agent_user
        FOREIGN KEY (id)
            REFERENCES user_entity(id)
            ON DELETE CASCADE;