package domaine;

public class Enseignant extends Utilisateur{

		// Déclaration d'attributs
	    private String matiereEnseignee;
	    
	    // Constructeur "Enseignant"
	    public Enseignant(Integer id, String nom, String prenom, String adresseMail, String numTel, String matiereEnseignee) {
			super(id, nom, prenom, adresseMail, numTel);
			// TODO Auto-generated constructor stub
			this.matiereEnseignee = matiereEnseignee;
		}

	    public String getMatiereEnseignee() {
	        return matiereEnseignee;
	    }

	    public void setMatiereEnseignee(String matiereEnseignee) {
	        this.matiereEnseignee = matiereEnseignee;
	    }

}
