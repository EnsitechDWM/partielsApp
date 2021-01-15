package GUI_Actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import GUI.Accueil;
import domaine.Etudiant;
import service.JdbcService;

@SuppressWarnings("serial")
public class ModifierEtudiant extends JFrame {
	
	JPanel pan_principal_ME = new JPanel();
	JLabel lb_cours = new JLabel("Modifier un étudiant");
	JTextField tf_cours = new JTextField("");
	JButton bt_retour = new JButton("retour");
	JButton bt_valider = new JButton("Valider");

	public ModifierEtudiant() {
		// Paramètres de la fenêtre
		setTitle("Modifier les informations d'un étudiant");
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
		pan_principal_ME.add(tableauEtudiants);		
		pan_principal_ME.add(bt_valider);	
		pan_principal_ME.add(bt_retour);
		
		// Agencement du conteneur
		pan_principal_ME.setBounds(0,0,3,4);
		pan_principal_ME.setLayout(new BorderLayout());
		
        pan_principal_ME.setPreferredSize(new Dimension(360, 480));
        BoxLayout bl_ME = new BoxLayout(pan_principal_ME, BoxLayout.PAGE_AXIS);
        pan_principal_ME.setLayout(bl_ME);
        pan_principal_ME.setBackground(Color.lightGray);
		
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
		
		bt_valider.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				/*				
				JdbcService etuCall = new JdbcService();
				etuCall.serviceListerLesEtudiants();
				Etudiant etuBDD2 = etuCall.serviceListerLesEtudiants();
				

				Etudiant etudiantCree = new Etudiant(1, etuBDD2.getNom(), etuBDD2.getPrenom(), etuBDD2.getAdresseMail(), etuBDD2.getAdresse(), etuBDD2.getNumTel(), etuBDD2.getDateNaissance());
				Etudiant etudiantModifier = new Etudiant(1, nom.toString(), prenom.toString(), email.toString(), adresse.toString(), numtel.toString(), naissance.toString());

				
				JdbcService service = new JdbcService();
				service.serviceCreerEtudiant(etudiantModifier);
				service.serviceSupprimerEtudiant(etudiantCree);
				
				*/
				

			}
		});

		
		// Afficher le conteneur
		setContentPane(pan_principal_ME);
	 
	}

}
