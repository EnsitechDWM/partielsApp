package domaine;

public class Utilisateur {
	
	// Déclaration des attributs
	protected Integer id;
	protected String nom;
	protected String prenom;
	protected String adresseMail;
	protected String numTel;
	
	
	// Constructeur "Utilisateur"
	public Utilisateur(Integer id, String nom, String prenom, String adresseMail, String numTel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.numTel = numTel;
	}
	
	
	// Getters et Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

}
