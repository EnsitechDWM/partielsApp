package GUI;

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

@SuppressWarnings("serial")
public class Debut extends JFrame {
	
	JPanel pan_principal_debut = new JPanel();
	JLabel lb_hello = new JLabel("Bienvenue, veuillez vous connecter pour accéder à l'application");
	JButton bt_connect = new JButton("Se connecter");
	
	
	public Debut() {
		// Paramètres de la fenêtre
		setTitle("Application de gestion d'étudiants");
		setSize(800, 400);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		// ajout d'objets dans le conteneur
		pan_principal_debut.add(lb_hello);
		pan_principal_debut.add(bt_connect);
		
		// Agencement du conteneur
		pan_principal_debut.setBounds(0,0,3,4);
		pan_principal_debut.setLayout(new BorderLayout());
		
        pan_principal_debut.setPreferredSize(new Dimension(360, 480));
        BoxLayout bl_debut = new BoxLayout(pan_principal_debut, BoxLayout.PAGE_AXIS);
        pan_principal_debut.setLayout(bl_debut);
        pan_principal_debut.setBackground(Color.GRAY);
		
		// Action du bouton
		bt_connect.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				// Instancier une fenêtre
				Connexion connexion = new Connexion();
				// Afficher la fenêtre suivante
				connexion.setVisible(true);
				pan_principal_debut.setVisible(false);
				dispose();

			}
		});

		
		// Afficher le conteneur
		setContentPane(pan_principal_debut);
	 
 
	}
	

}
