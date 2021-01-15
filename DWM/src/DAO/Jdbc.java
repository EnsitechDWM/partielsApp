package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domaine.Etudiant;
import domaine.ResponsableEtudes;

public class Jdbc {


		// Méthode permettant de créer un étudiant
		public void creerEtudiant(Etudiant etudiant1){
			
			// Déclaration des attributs et affectation des variables
			String nomEtudiant = etudiant1.getNom();
			String prenomEtudiant = etudiant1.getPrenom();
			String emailEtudiant = etudiant1.getAdresseMail();
			String adresseEtudiant = etudiant1.getAdresse();
			String telEtudiant = etudiant1.getNumTel();
			String naissance = etudiant1.getDateNaissance();

			
			// Information d'accès à la base de données
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			String sql1 = "INSERT INTO `etudiant` (`nomEtudiant`, `prenomEtudiant`, `emailEtudiant`, `adresseEtudiant`, `telEtudiant`, `naissance`) VALUES ('"+ nomEtudiant +"','"+ prenomEtudiant +"','"+ emailEtudiant +"','"+adresseEtudiant+"','"+ telEtudiant +"','"+ naissance +"')";
			try {

				// on charge le driver
				Class.forName("com.mysql.jdbc.Driver");
				// on récupère la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				PreparedStatement pst1 = cn.prepareStatement(sql1);
				
				// On éxecute la requête
				pst1.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// on libère les ressources en mémoire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
		

		
				// méthode permettant d'afficher un seul étudiant
				public void lireUnEtudiant(Etudiant etudiant1 ) {
					
			// Déclaration des attributs et affectation des variables
			Integer idEtudiant = etudiant1.getId();
					
			// Information d'accès à la base de données
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			ResultSet rs = null;
			String sql2 = "SELECT * FROM etudiant WHERE `idEtudiant` = "+ idEtudiant +"";
			ArrayList<String> etudiants = new ArrayList<String>();
					
					
			try {
				// étape 1 : Chargement du Driver
				Class.forName("com.mysql.jdbc.Driver");
				// étape 2 : Récupération de la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				// affectation de la requête au preparedStatement
				PreparedStatement pst2 = cn.prepareStatement(sql2);
				// étape 4 : exécution de la requête
				rs = pst2.executeQuery();
				// étape 5 : parcours ResultSet
				while (rs.next()) {
							
					// Insertion des informations dans le tableau
					etudiants.add(rs.getString("idEtudiant"));
					etudiants.add(rs.getString("nomEtudiant"));
					etudiants.add(rs.getString("prenomEtudiant"));
					etudiants.add(rs.getString("emailEtudiant"));
					etudiants.add(rs.getString("adresseEtudiant"));
					etudiants.add(rs.getString("telEtudiant"));
					etudiants.add(rs.getString("naissance"));
							
			}
				for (String etudiant : etudiants) {
					System.out.print(etudiant +"\n");
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// on libère les ressources en mémoire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
				
				
				// méthode d'authentification
				public ResponsableEtudes authentification() {
					
			// Information d'accès à la base de données
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM responsable";
			ArrayList<String> responsables = new ArrayList<String>();
			ResponsableEtudes resp = null;
					
					
			try {
				// étape 1 : Chargement du Driver
				Class.forName("com.mysql.jdbc.Driver");
				// étape 2 : Récupération de la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				// affectation de la requête au preparedStatement
				PreparedStatement pst2 = cn.prepareStatement(sql);
				// étape 4 : exécution de la requête
				rs = pst2.executeQuery();
				// étape 5 : parcours ResultSet
				while (rs.next()) {
						
					resp = new ResponsableEtudes(rs.getInt("idAdministrateur"), rs.getString("nomResponsable"), rs.getString("prenomResponsable"), rs.getString("emailResponsable"), rs.getString("telResponsable"), rs.getString("login"), rs.getString("password"), rs.getBoolean("type"));

                    responsables.add(rs.getString("login"));
                    responsables.add(rs.getString("password"));
                    
                    
			}
				for (@SuppressWarnings("unused") String responsable : responsables) {
					//System.out.print(responsable);
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// on libère les ressources en mémoire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return resp;
		}
						
							
				
				
		// Méthode permettant de supprimer un étudiant
		public void supprimerEtudiant(Etudiant etudiant1) {
			
			Integer idEtudiant = etudiant1.getId();

			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			String sql3 = "DELETE FROM `etudiant` WHERE `idEtudiant` = "+idEtudiant+"";
			try {
				
				// on charge le driver
				Class.forName("com.mysql.jdbc.Driver");
				// on récupère la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				PreparedStatement pst1 = cn.prepareStatement(sql3);
				
				// On éxecute la requête
				pst1.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// on libère les ressources en mémoire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// méthode permettant d'afficher tous les etudiants
		public Etudiant listerLesEtudiant() {
			
			// Information d'accès à la base de données
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			ResultSet rs = null;
			String sql2 = "SELECT * FROM etudiant";
			ArrayList<String> etudiants = new ArrayList<String>();
			Etudiant etu = null;
			
			try {
				// étape 1 : Chargement du Driver
				Class.forName("com.mysql.jdbc.Driver");
				// étape 2 : Récupération de la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				// affectation de la requête au preparedStatement
				PreparedStatement pst2 = cn.prepareStatement(sql2);
				// étape 4 : exécution de la requête
				rs = pst2.executeQuery();
				// étape 5 : parcours ResultSet
				while (rs.next()) {
					
					// Insertion des informations dans le tableau
					etudiants.add(rs.getString("idEtudiant"));
					etudiants.add(rs.getString("nomEtudiant"));
					etudiants.add(rs.getString("prenomEtudiant"));
					etudiants.add(rs.getString("emailEtudiant"));
					etudiants.add(rs.getString("adresseEtudiant"));
					etudiants.add(rs.getString("telEtudiant"));
					etudiants.add(rs.getString("naissance"));
					
					etu = new Etudiant(rs.getInt("idEtudiant"), rs.getString("nomEtudiant"), rs.getString("prenomEtudiant"), rs.getString("emailEtudiant"), rs.getString("adresseEtudiant"), rs.getString("telEtudiant"), rs.getString("naissance") );
					
			}
				for (String etudiant : etudiants) {
					System.out.print(etudiant +"\n");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return etu;
		}

}
