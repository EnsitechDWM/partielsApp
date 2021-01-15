package domaine;


public class Etudiant extends Utilisateur {
	
	// Déclaration d'attributs
	protected String dateNaissance;
	protected String adresse;

	
	// Constructeur "Etudiant"
	public Etudiant(Integer id, String nom, String prenom, String adresseMail, String adresse, String numTel, String dateNaissance) {
		super(id, nom, prenom, adresseMail, numTel);
		// TODO Auto-generated constructor stub
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	// Getters et Setters de dateNaissance
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
