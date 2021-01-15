package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import GUI_Actions.*;
import domaine.ResponsableEtudes;
import service.JdbcService;

@SuppressWarnings("serial")
public class Accueil extends JFrame implements ActionListener {
	
	// Attributs de la barre menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Menu");
	protected JMenuItem creer_etudiant = new JMenuItem("Créer un étudiant");
	protected JMenuItem associer_cours = new JMenuItem("Associer un cours à un étudiant");
	protected JMenuItem lire_etudiant = new JMenuItem("Lire les informations d'un étudiant");
	protected JMenuItem modifier_etudiant = new JMenuItem("Modifier une des informations sur l'étudiant");
	protected JMenuItem supprimer_etudiant = new JMenuItem("Supprimer un étudiant");
	protected JMenuItem lister_etudiants = new JMenuItem("Lister l'ensemble des étudiants de l'école");


		
		public Accueil() {
			
			JPanel content = new JPanel();
			content.add(new JLabel("Bienvenue sur l'application !"));
			content.setBackground(Color.lightGray);
			
			// Paramètres de la fenêtre
			setTitle("Accueil");
			setSize(1200, 800);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			// ajout du menu au menuBar
			menuBar.add(menu);
			
			// ajout du sous-menu
			menu.add(creer_etudiant);
			menu.add(associer_cours);
			menu.add(lire_etudiant);	
			menu.add(modifier_etudiant);	
			menu.add(supprimer_etudiant);
			
			
			// ajout de la fonctionnalité "Lister les étudiants" pour les directeurs uniquement
			JdbcService service;
			service = new JdbcService();
			service.serviceAuthentification();
			ResponsableEtudes connBDD = service.serviceAuthentification();
			if (connBDD.getType()== true) {
				
				menu.add(lister_etudiants);
				
			}

			
			
			// ajout du menuBar
			setJMenuBar(menuBar);

			// liaison entre les fenêtres de GUI_Actions et le menu déroulant via Listener
			creer_etudiant.addActionListener(new ActionListener() {
							
			
					public void actionPerformed(ActionEvent e) {
							
						CreerEtudiant creerUnEtudiant = new CreerEtudiant();
						creerUnEtudiant.setVisible(true);
						dispose();
						}
				});
			
			associer_cours.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
						
					AssocierCours associerCours = new AssocierCours();
					associerCours.setVisible(true);
					dispose();
					}
			});
			
			lire_etudiant.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
						
					LireInfosEtudiant lireInfoEtudiant = new LireInfosEtudiant();
					lireInfoEtudiant.setVisible(true);
					dispose();
					}
			});
			
			modifier_etudiant.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
						
					ModifierEtudiant modifierEtudiant = new ModifierEtudiant();
					modifierEtudiant.setVisible(true);
					dispose();
					}
			});
		
			supprimer_etudiant.addActionListener(new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {
					
					SupprimerEtudiant supprimerEtudiant = new SupprimerEtudiant();
					supprimerEtudiant.setVisible(true);
					dispose();
					}
			});
		
			lister_etudiants.addActionListener(new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {
				
					ListerEtudiants lister_etudiants = new ListerEtudiants();
					lister_etudiants.setVisible(true);
						dispose();
					}
			});
 
	        getContentPane().add(content, BorderLayout.CENTER);
			//setContentPane(content_accueil);
			
		}

	
	/*	
		public void identifierirecteur() {
					
		JdbcService service;
		service = new JdbcService();
		
		service.serviceAuthentification();
		
		
		ResponsableEtudes connBDD = service.serviceAuthentification();
		
		if (connBDD.getType()== true) {
			
			menu.add(lister_etudiants);
			
		}
		
	}
	
	*/
		// Implementation entre la class Accueil et ActionListener
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}



}

