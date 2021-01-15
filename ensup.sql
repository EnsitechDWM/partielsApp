-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 15 jan. 2021 à 18:27
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ensup`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `idCours` int(11) NOT NULL,
  `themeCours` text NOT NULL,
  `nombreHeures` varchar(25) NOT NULL,
  `idEnseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`idCours`, `themeCours`, `nombreHeures`, `idEnseignant`) VALUES
(1, 'Mathématiques', '2 heures', 1),
(2, 'Informatique', '4 heures', 2),
(3, 'Droit', '3 heures', 3),
(4, 'Anglais', '2 heure', 4);

-- --------------------------------------------------------

--
-- Structure de la table `coursetudiant`
--

CREATE TABLE `coursetudiant` (
  `idCours` int(11) NOT NULL,
  `idEtudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `idEnseignant` int(11) NOT NULL,
  `nomEnseignant` text NOT NULL,
  `prenomEnseignant` text NOT NULL,
  `emailEnseignant` varchar(50) NOT NULL,
  `adresseEnseignant` varchar(50) NOT NULL,
  `telEnseignant` varchar(25) NOT NULL,
  `matiere` text NOT NULL,
  `idCours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`idEnseignant`, `nomEnseignant`, `prenomEnseignant`, `emailEnseignant`, `adresseEnseignant`, `telEnseignant`, `matiere`, `idCours`) VALUES
(1, 'Mr.Martin', 'Cedric', 'cedric.martin@gmail.com', '37 rue des additions', '0302040105', 'Mathématiques', 1),
(2, 'Mr.Mdianbou', 'Douglas', 'objis@gmail.com', '37 rue des affectations', '0302042136', 'Informatiques', 2),
(3, 'Mr.Juge', 'Bertrand', 'gregoire.juge@gmail.com', '37 rue des tribunaux', '0602089726', 'Droit', 3),
(4, 'Mr.this', 'Quentin', 'quentin.this@gmail.com', '37 rue des langages', '0616736446', 'Anglais', 4);

-- --------------------------------------------------------

--
-- Structure de la table `ensitech`
--

CREATE TABLE `ensitech` (
  `nomENSITECH` text NOT NULL,
  `emailENSITECH` varchar(50) NOT NULL,
  `adresseENSITECH` varchar(100) NOT NULL,
  `telENSITECH` varchar(25) NOT NULL,
  `nomDirecteur` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ensitech`
--

INSERT INTO `ensitech` (`nomENSITECH`, `emailENSITECH`, `adresseENSITECH`, `telENSITECH`, `nomDirecteur`) VALUES
('ENSUP', 'ecole@ensup.eu', 'EQUINOXE 2, 1 bis Avenue du 8 Mai 1945, 78280 Guyancourt', '01 61 38 05 75', 'Agromayor');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `idEtudiant` int(11) NOT NULL,
  `nomEtudiant` text NOT NULL,
  `prenomEtudiant` text NOT NULL,
  `emailEtudiant` varchar(50) NOT NULL,
  `adresseEtudiant` varchar(50) NOT NULL,
  `telEtudiant` varchar(25) NOT NULL,
  `naissance` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`idEtudiant`, `nomEtudiant`, `prenomEtudiant`, `emailEtudiant`, `adresseEtudiant`, `telEtudiant`, `naissance`) VALUES
(20, 'TEST', 'test', 'test@mail.fr', '5 rue blalba', '05 73 73 47 65', '11.06.2041');

-- --------------------------------------------------------

--
-- Structure de la table `responsable`
--

CREATE TABLE `responsable` (
  `idAdministrateur` int(11) NOT NULL,
  `nomResponsable` text NOT NULL,
  `prenomResponsable` text NOT NULL,
  `emailResponsable` varchar(50) NOT NULL,
  `telResponsable` varchar(25) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `Type` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `responsable`
--

INSERT INTO `responsable` (`idAdministrateur`, `nomResponsable`, `prenomResponsable`, `emailResponsable`, `telResponsable`, `login`, `password`, `Type`) VALUES
(1, 'Admin', '', '', '', 'admin', 'Ensup@2021!', NULL),
(2, 'Directeur', '', '', '', 'Directeur', 'Partiels@Ensup2021!', 1),
(3, 'Responsable', '', '', '', 'Responsable', 'Ensup!Partiels2021@', 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`idCours`),
  ADD KEY `idEnseignant` (`idEnseignant`);

--
-- Index pour la table `coursetudiant`
--
ALTER TABLE `coursetudiant`
  ADD KEY `idCours` (`idCours`),
  ADD KEY `idEtudiant` (`idEtudiant`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`idEnseignant`),
  ADD KEY `idCours` (`idCours`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`idEtudiant`);

--
-- Index pour la table `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`idAdministrateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `idCours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `idEnseignant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `idEtudiant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `responsable`
--
ALTER TABLE `responsable`
  MODIFY `idAdministrateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `coursetudiant`
--
ALTER TABLE `coursetudiant`
  ADD CONSTRAINT `coursetudiant_ibfk_2` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`idEtudiant`),
  ADD CONSTRAINT `coursetudiant_ibfk_3` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`);

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`idEnseignant`) REFERENCES `cours` (`idEnseignant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
