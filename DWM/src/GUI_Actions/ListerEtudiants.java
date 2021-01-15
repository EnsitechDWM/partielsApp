package GUI_Actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUI.Accueil;
import domaine.Etudiant;
import service.JdbcService;

@SuppressWarnings("serial")
public class ListerEtudiants extends JFrame{
	
	JPanel pan_principal_LE = new JPanel();
	JButton bt_retour = new JButton("retour");

	
	public ListerEtudiants() {
		// Paramètres de la fenêtre
		setTitle("Liste des étudiants");
		setSize(800, 400);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Récuperation des informations en base
		JdbcService etuCall = new JdbcService();
		etuCall.serviceListerLesEtudiants();
		Etudiant etuBDD = etuCall.serviceListerLesEtudiants();
		
		String nom = etuBDD.getNom();
		String prenom = etuBDD.getPrenom();
		String email = etuBDD.getAdresseMail();
		String adresse = etuBDD.getAdresse();
		String numtel = etuBDD.getNumTel();
		String naissance = etuBDD.getDateNaissance();
		
		
		// Création de l'objet de type tableau
		Object [][] donnees = {
				
				{nom, prenom, email, adresse, numtel, naissance}
		};
		// Libellés du tableau
		String[] entetes = {"Nom", "Prenom", "E-mail", "Adresse", "Téléphone", "Date de naissance"  };
		
		JTable tableauEtudiants = new JTable(donnees, entetes);
		getContentPane().add(new JScrollPane(tableauEtudiants));

		
		// ajout d'objets dans le conteneur
		pan_principal_LE.add(tableauEtudiants);
		pan_principal_LE.add(bt_retour);
		
		// Agencement du conteneur
		pan_principal_LE.setBounds(0,0,3,4);
		pan_principal_LE.setLayout(new BorderLayout());
		
        pan_principal_LE.setPreferredSize(new Dimension(360, 480));
        BoxLayout bl_LE = new BoxLayout(pan_principal_LE, BoxLayout.PAGE_AXIS);
        pan_principal_LE.setLayout(bl_LE);
        pan_principal_LE.setBackground(Color.lightGray);
		
		// Action du bouton
		bt_retour.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				// Instancier une fenêtre
				Accueil accueil = new Accueil();
				// Afficher la fenêtre suivante
				accueil.setVisible(true);
				dispose();

			}
		});

		
		// Afficher le conteneur
		setContentPane(pan_principal_LE);
	 
	}


}
