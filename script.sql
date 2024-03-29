CREATE database gestion_fournisseur;
CREATE ROLE gestion LOGIN PASSWORD 'gestion';
ALTER database gestion_fournisseur OWNER TO gestion;

\c gestion_fournisseur gestion;

CREATE  TABLE fourniseur ( 
	id_fournisseur       varchar(8)  NOT NULL ,
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
	id_article           varchar(8)  NOT NULL ,
	designation          varchar(20)  NOT NULL ,
	id_categorie         integer  NOT NULL ,
	CONSTRAINT pk_article_id_article PRIMARY KEY ( id_article )
 );

CREATE  TABLE entreprise ( 
	id_entreprise        varchar(8) DEFAULT concat('SOC', nextval('entreprise_id_seq'::regclass)) NOT NULL ,
	nom_entreprise       varchar(20)  NOT NULL ,
	NIF					 varchar(10) NOT NULL,
	STAT				 varchar(10) NOT NULL,
	CONSTRAINT pk_entreprise_id_entreprise PRIMARY KEY ( id_entreprise )
 );


ALTER TABLE article ADD CONSTRAINT fk_article_categorie FOREIGN KEY ( id_categorie ) REFERENCES categorie( id_categorie );

CREATE  TABLE stock ( 
	id_stock             serial NOT NULL ,
	id_fournisseur       varchar(8)  NOT NULL ,
	date_stockage        date DEFAULT current_date NOT NULL ,
	id_article           varchar(8)  NOT NULL ,
	quantite             varchar   ,
	CONSTRAINT pk_stock_id_stock PRIMARY KEY ( id_stock )
 );

ALTER TABLE stock ADD CONSTRAINT fk_stock_article FOREIGN KEY ( id_article ) REFERENCES article( id_article );

ALTER TABLE stock ADD CONSTRAINT fk_stock_fournisseur FOREIGN KEY ( id_fournisseur ) REFERENCES fourniseur( id_fournisseur );

--------------------------- données de test ----------------------------

INSERT INTO unite
	(nom_unite) 
    VALUES ( 'nombre' ),( 'boite' ),( 'paquet' );

INSERT INTO categorie (nom_categorie)
VALUES 
  ('Fournitures de bureau'),
  ('Matériel informatique'),
  ('Equipement de cuisine'),
  ('Produits de nettoyage'),
  ('Outils et accessoires');

INSERT INTO fournisseur (nom, contact, email, nom_responsable,adresse) VALUES 
  ('Super U', '0340100101', 'contact@superu.mg', 'Rakotobe Mario','Akorondrano'),
  ('Jumbo Score', '0320202202', 'info@jumbo.mg', 'Andriantsoa Mariane','Tanjombato'),
  ('Leader Price', '0333030033', 'contact@leaderprice.mg', 'Valison Pierre','Tanjombato'),
  ('KIBO', '0344440044', 'info@kibo.mg', 'Rafarasoa Anderson','Tanjombato'),
  ('Cartin', '0325505500', 'contact@cartin.mg', 'Rakotomalala Emma','Analakely');

INSERT INTO article(designation,id_categorie) VALUES
('Stylo',1), ('Crayon',1),('Gomme',1),('Agraphe',1),
('RAM DDR4 8GB',2),('Disque dur 1To',2),('Clé USB 32Go',2),
('Détergent',3),('Balai',3),('Chiffon',3),
('Clé à molette',4),('Pince multifonction',4);

INSERT INTO stock
(id_fournisseur, date_stockage, id_article, quantite, prix_unitaire, id_unite) VALUES 
( 'FRS4', now(), 'ART1', 70, 1200, 1 ),
( 'FRS5', now(), 'ART1', 50, 1300, 1 ),
( 'FRS6', now(), 'ART1', 35, 1250, 1 ),
( 'FRS8', now(), 'ART1', 30, 1190, 1 ),
( 'FRS4', now(), 'ART2', 70, 1000, 1 ),
( 'FRS5', now(), 'ART2', 50, 1100, 1 ),
( 'FRS6', now(), 'ART2', 35, 1050, 1 ),
( 'FRS8', now(), 'ART2', 30, 1090, 1 ),
( 'FRS4', now(), 'ART9', 10, 2200, 1 ),
( 'FRS5', now(), 'ART9', 15, 2300, 1 ),
( 'FRS6', now(), 'ART9', 25, 2250, 1 ),
( 'FRS8', now(), 'ART9', 20, 2090, 1 );

CREATE SEQUENCE article_id_seq;
CREATE SEQUENCE fournisseur_id_seq;
CREATE SEQUENCE entreprise_id_seq;

ALTER TABLE article  ALTER column id_article set DEFAULT CONCAT('ART', nextval('article_id_seq'));
ALTER TABLE fournisseur  ALTER column id_fournisseur set DEFAULT CONCAT('FRS', nextval('fournisseur_id_seq'));

CREATE SEQUENCE role_id_seq;
CREATE SEQUENCE service_id_seq;
CREATE SEQUENCE utilisateur_id_seq;

CREATE  TABLE roles ( 
	id                   varchar(8) DEFAULT CONCAT('ROL', nextval('role_id_seq')) NOT NULL ,
	nom                  text   ,
	CONSTRAINT pk_roles_id PRIMARY KEY ( id )
 );

CREATE  TABLE service ( 
	id                   varchar(8) DEFAULT CONCAT('SER', nextval('service_id_seq')) NOT NULL ,
	nom_service          text   ,
	CONSTRAINT pk_service_id PRIMARY KEY ( id )
 );

CREATE  TABLE utilisateur ( 
	id                   varchar(8) DEFAULT CONCAT('UTI', nextval('utilisateur_id_seq')) NOT NULL ,
	email                text   ,
	mdp                  varchar(12)  NOT NULL ,
	id_service           varchar(8)   ,
	id_role              varchar(8)   ,
	CONSTRAINT pk_utilisateur_id PRIMARY KEY ( id )
 );

ALTER TABLE utilisateur ADD CONSTRAINT cns_email_utilisateur CHECK ( UNIQUE(email) );

ALTER TABLE utilisateur ADD CONSTRAINT fk_utilisateur_service FOREIGN KEY ( id_service ) REFERENCES service( id );

ALTER TABLE utilisateur ADD CONSTRAINT fk_utilisateur_roles FOREIGN KEY ( id_role ) REFERENCES roles( id );

CREATE  TABLE proforma ( 
	id_proforma          serial  NOT NULL ,
	id_mail              integer   ,
	date_emis            date DEFAULT CURRENT_DATE NOT NULL ,
	CONSTRAINT pk_proformat_id_proformat PRIMARY KEY ( id_proforma )
 );

ALTER TABLE proforma ADD CONSTRAINT fk_mail_proforma_mail FOREIGN KEY ( id_mail ) REFERENCES mail( id_mail );

CREATE  TABLE details_proforma ( 
	id_d_proforma        serial  NOT NULL ,
	id_article           varchar   ,
	prix_unitaire        float8  NOT NULL ,
	quantite             float8  NOT NULL ,
	id_proforma          integer  NOT NULL ,
	CONSTRAINT pk_details_proforma_id_d_proforma PRIMARY KEY ( id_d_proforma )
 );

ALTER TABLE details_proforma ADD CONSTRAINT fk_details_proforma_article FOREIGN KEY ( id_article ) REFERENCES article( id_article );

ALTER TABLE details_proforma ADD CONSTRAINT fk_details_proforma_proforma FOREIGN KEY ( id_proforma ) REFERENCES proforma( id_proforma );

CREATE  TABLE bon_livraison ( 
	id_b_livraison       integer  NOT NULL ,
	id_bc                integer  NOT NULL ,
	date_emis            date DEFAULT CURRENT_DATE NOT NULL ,
	id_fournisseur       integer  NOT NULL ,
	id_entreprise        integer  NOT NULL ,
	CONSTRAINT pk_bon_livraison_id_b_livraison PRIMARY KEY ( id_b_livraison )
 );

CREATE  TABLE details_b_livraison ( 
	id_d_bl              serial  NOT NULL ,
	id_article           varchar   ,
	quantite             float8  NOT NULL ,
	remarque             text   ,
	id_b_livraison       integer  NOT NULL ,
	CONSTRAINT pk_details_proforma_id_d_proforma_0 PRIMARY KEY ( id_d_bl )
 );

ALTER TABLE details_b_livraison ADD CONSTRAINT fk_details_proforma_article_0 FOREIGN KEY ( id_article ) REFERENCES article( id_article );

ALTER TABLE details_b_livraison ADD CONSTRAINT fk_details_b_livraison FOREIGN KEY ( id_b_livraison ) REFERENCES bon_livraison( id_b_livraison );

CREATE  TABLE facture ( 
	id_facture           integer  NOT NULL ,
	id_bc                integer  NOT NULL ,
	date_emis            date DEFAULT CURRENT_DATE NOT NULL ,
	id_fournisseur       integer  NOT NULL ,
	id_entreprise        integer  NOT NULL ,
	CONSTRAINT pk_bon_livraison_id_b_livraison_0 PRIMARY KEY ( id_facture )
 );

CREATE  TABLE details_facture ( 
	id_d_facture         serial  NOT NULL ,
	id_article           varchar   ,
	prix_unitaire        float8  NOT NULL ,
	quantite             float8  NOT NULL ,
	id_facture           integer  NOT NULL ,
	CONSTRAINT pk_details_proforma_id_d_proforma_1 PRIMARY KEY ( id_d_facture )
 );

ALTER TABLE details_facture ADD CONSTRAINT fk_details_proforma_article_1 FOREIGN KEY ( id_article ) REFERENCES article( id_article );

ALTER TABLE details_facture ADD CONSTRAINT fk_details_proforma_0_facture FOREIGN KEY ( id_facture ) REFERENCES facture( id_facture );

