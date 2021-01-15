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


		// M�thode permettant de cr�er un �tudiant
		public void creerEtudiant(Etudiant etudiant1){
			
			// D�claration des attributs et affectation des variables
			String nomEtudiant = etudiant1.getNom();
			String prenomEtudiant = etudiant1.getPrenom();
			String emailEtudiant = etudiant1.getAdresseMail();
			String adresseEtudiant = etudiant1.getAdresse();
			String telEtudiant = etudiant1.getNumTel();
			String naissance = etudiant1.getDateNaissance();

			
			// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			String sql1 = "INSERT INTO `etudiant` (`nomEtudiant`, `prenomEtudiant`, `emailEtudiant`, `adresseEtudiant`, `telEtudiant`, `naissance`) VALUES ('"+ nomEtudiant +"','"+ prenomEtudiant +"','"+ emailEtudiant +"','"+adresseEtudiant+"','"+ telEtudiant +"','"+ naissance +"')";
			try {

				// on charge le driver
				Class.forName("com.mysql.jdbc.Driver");
				// on r�cup�re la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				PreparedStatement pst1 = cn.prepareStatement(sql1);
				
				// On �xecute la requ�te
				pst1.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// on lib�re les ressources en m�moire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
		

		
				// m�thode permettant d'afficher un seul �tudiant
				public void lireUnEtudiant(Etudiant etudiant1 ) {
					
			// D�claration des attributs et affectation des variables
			Integer idEtudiant = etudiant1.getId();
					
			// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			ResultSet rs = null;
			String sql2 = "SELECT * FROM etudiant WHERE `idEtudiant` = "+ idEtudiant +"";
			ArrayList<String> etudiants = new ArrayList<String>();
					
					
			try {
				// �tape 1 : Chargement du Driver
				Class.forName("com.mysql.jdbc.Driver");
				// �tape 2 : R�cup�ration de la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				// affectation de la requ�te au preparedStatement
				PreparedStatement pst2 = cn.prepareStatement(sql2);
				// �tape 4 : ex�cution de la requ�te
				rs = pst2.executeQuery();
				// �tape 5 : parcours ResultSet
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
					// on lib�re les ressources en m�moire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
				
				
				// m�thode d'authentification
				public ResponsableEtudes authentification() {
					
			// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM responsable";
			ArrayList<String> responsables = new ArrayList<String>();
			ResponsableEtudes resp = null;
					
					
			try {
				// �tape 1 : Chargement du Driver
				Class.forName("com.mysql.jdbc.Driver");
				// �tape 2 : R�cup�ration de la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				// affectation de la requ�te au preparedStatement
				PreparedStatement pst2 = cn.prepareStatement(sql);
				// �tape 4 : ex�cution de la requ�te
				rs = pst2.executeQuery();
				// �tape 5 : parcours ResultSet
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
					// on lib�re les ressources en m�moire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return resp;
		}
						
							
				
				
		// M�thode permettant de supprimer un �tudiant
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
				// on r�cup�re la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				PreparedStatement pst1 = cn.prepareStatement(sql3);
				
				// On �xecute la requ�te
				pst1.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// on lib�re les ressources en m�moire
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// m�thode permettant d'afficher tous les etudiants
		public Etudiant listerLesEtudiant() {
			
			// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost/ensup";
			String login = "root";
			String passwd = "";
			Connection cn = null;
			ResultSet rs = null;
			String sql2 = "SELECT * FROM etudiant";
			ArrayList<String> etudiants = new ArrayList<String>();
			Etudiant etu = null;
			
			try {
				// �tape 1 : Chargement du Driver
				Class.forName("com.mysql.jdbc.Driver");
				// �tape 2 : R�cup�ration de la connexion
				cn = DriverManager.getConnection(url, login, passwd);
				// affectation de la requ�te au preparedStatement
				PreparedStatement pst2 = cn.prepareStatement(sql2);
				// �tape 4 : ex�cution de la requ�te
				rs = pst2.executeQuery();
				// �tape 5 : parcours ResultSet
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
