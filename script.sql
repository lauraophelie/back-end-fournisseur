CREATE database gestion_fournisseur;
CREATE ROLE gestion LOGIN PASSWORD 'gestion';
ALTER database gestion_fournisseur OWNER TO gestion;

\c gestion_fournisseur gestion;

CREATE  TABLE fourniseur ( 
	id_fournisseur       varchar(5)  NOT NULL ,
	nom                  varchar(13)  NOT NULL UNIQUE,
	contact              char(10)  NOT NULL UNIQUE,
	email                varchar(20)  NOT NULL UNIQUE,
	nom_responsable      varchar(20)  NOT NULL ,
	CONSTRAINT pk_fourniseur_id_fournisseur PRIMARY KEY ( id_fournisseur )
 );

CREATE  TABLE categorie ( 
	id_categorie         serial  NOT NULL ,
	nom_categorie        varchar(20)  NOT NULL ,
	CONSTRAINT pk_categorie_id_categorie PRIMARY KEY ( id_categorie )
 );

CREATE  TABLE article ( 
	id_article           varchar(10)  NOT NULL ,
	designation          varchar(20)  NOT NULL ,
	id_categorie         integer  NOT NULL ,
	CONSTRAINT pk_article_id_article PRIMARY KEY ( id_article )
 );

ALTER TABLE article ADD CONSTRAINT fk_article_categorie FOREIGN KEY ( id_categorie ) REFERENCES categorie( id_categorie );

CREATE  TABLE stock ( 
	id_stock             serial  NOT NULL ,
	id_fournisseur       varchar(5)  NOT NULL ,
	date_stockage        date DEFAULT current_date NOT NULL ,
	id_article           varchar(10)  NOT NULL ,
	quantite             varchar   ,
	CONSTRAINT pk_stock_id_stock PRIMARY KEY ( id_stock )
 );

ALTER TABLE stock ADD CONSTRAINT fk_stock_article FOREIGN KEY ( id_article ) REFERENCES article( id_article );

ALTER TABLE stock ADD CONSTRAINT fk_stock_fournisseur FOREIGN KEY ( id_fournisseur ) REFERENCES fourniseur( id_fournisseur );

--------------------------- données de test ----------------------------

INSERT INTO "public".unite
	(nom_unite) 
    VALUES ( 'nombre' ),( 'kg' ),( 'litre' );

INSERT INTO "public".categorie (nom_categorie)
VALUES 
  ('Fournitures de bureau'),
  ('Matériel informatique'),
  ('Équipement de cuisine'),
  ('Produits de nettoyage'),
  ('Outils et accessoires');

INSERT INTO "public".article (id_article, designation, id_categorie) VALUES 
  ('BS001', 'Stylo à bille', 1),
  ('BC001', 'Cahier à spirale', 1),
  ('BA001', 'Agrafeuse de bureau', 1),
  ('IS002', 'Souris sans fil', 2),
  ('IC001', 'Clavier mécanique', 2),
  ('IEL24', 'Écran LED 24 pouces', 2),
  ('CC005', 'Ensemble de couteaux', 3),
  ('CMG02', 'Moule à gâteau antiadhésif', 3),
  ('CM002', 'Mixeur électrique', 3),
  ('ND010', 'Détergent multi-usages', 4),
  ('NE003', 'Éponge abrasive', 4),
  ('NV001', 'Nettoyant pour vitres', 4),
  ('OTV11', 'Tournevis Phillips', 5),
  ('OMR01', 'Mètre ruban', 5),
  ('OPU01', 'Pince universelle', 5);

INSERT INTO "public".fournisseur (id_fournisseur, nom, contact, email, nom_responsable) VALUES 
  ('F001', 'Super U', '03', 'contact@superu.mg', 'Rakotobe Mario'),
  ('F002', 'Jumbo Score', '03', 'info@jumbo.mg', 'Andriantsoa Mariane'),
  ('F003', 'Leader Price', '03', 'contact@leaderprice.mg', 'Valison Pierre'),
  ('F004', 'KIBO', '03', 'info@kibo.mg', 'Rafarasoa Anderson'),
  ('F005', 'Cartin', '03', 'contact@cartin.mg', 'Rakotomalala Emma');
  
--INSERT INTO "public".stock
--	(id_fournisseur, date_stockage, id_article, quantite, prix_unitaire, id_unite) 
--    VALUES ( ?, ?, ?, ?, ?, ?, ? );