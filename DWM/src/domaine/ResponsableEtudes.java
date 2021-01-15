package domaine;

public class ResponsableEtudes extends Utilisateur {
	
	private String login;
	private String password;
	private Boolean type;

	// Constructeur "ResponsableEtudes"
	public ResponsableEtudes(Integer id, String nom, String prenom, String adresseMail, String numTel, String login, String password,Boolean type) {
		super(id, nom, prenom, adresseMail, numTel);
		// TODO Auto-generated constructor stub
		this.login = login;
		this.password = password;
		this.type = type;
		
	}

	// Getters et Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}



}
