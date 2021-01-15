package service;

import DAO.Jdbc;
import domaine.Etudiant;
import domaine.ResponsableEtudes;

public class JdbcService {
	

	public Etudiant serviceListerLesEtudiants() {
		Jdbc bdd;
		bdd = new Jdbc();
		bdd.listerLesEtudiant();
		return bdd.listerLesEtudiant();
	}
	public void serviceSupprimerEtudiant(Etudiant etudiant1) {
		Jdbc bdd;
		bdd = new Jdbc();
		bdd.supprimerEtudiant(etudiant1);
	}
	public void serviceLireUnEtudiants(Etudiant etudiant1) {
		Jdbc bdd;
		bdd = new Jdbc();
		bdd.lireUnEtudiant(etudiant1);
	}
	public ResponsableEtudes serviceAuthentification() {
		Jdbc bdd;
		bdd = new Jdbc();
		bdd.authentification();
		return bdd.authentification();
		
	}
	public void serviceCreerEtudiant(Etudiant etudiant1) {
		Jdbc bdd;
		bdd = new Jdbc();
		bdd.creerEtudiant(etudiant1);
	}
	

}
