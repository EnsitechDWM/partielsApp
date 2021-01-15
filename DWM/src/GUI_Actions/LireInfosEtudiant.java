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
import javax.swing.JTextField;

import GUI.Accueil;

@SuppressWarnings("serial")
public class LireInfosEtudiant extends JFrame {
	JPanel pan_principal_LIE = new JPanel();
	JLabel lb_cours = new JLabel("saisissez un cours");
	JTextField tf_cours = new JTextField("");
	JButton bt_retour = new JButton("retour");
	
	

	public LireInfosEtudiant() {
		// Paramètres de la fenêtre
		setTitle("Lire les informations d'un étudiant");
		setSize(800, 400);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		// ajout d'objets dans le conteneur
		pan_principal_LIE.add(lb_cours);
		pan_principal_LIE.add(tf_cours);
		pan_principal_LIE.add(bt_retour);
		
		// Agencement du conteneur
		pan_principal_LIE.setBounds(0,0,3,4);
		pan_principal_LIE.setLayout(new BorderLayout());
		
        pan_principal_LIE.setPreferredSize(new Dimension(360, 480));
        BoxLayout bl_LIE = new BoxLayout(pan_principal_LIE, BoxLayout.PAGE_AXIS);
        pan_principal_LIE.setLayout(bl_LIE);
        pan_principal_LIE.setBackground(Color.lightGray);
		
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
		setContentPane(pan_principal_LIE);
	}
}
