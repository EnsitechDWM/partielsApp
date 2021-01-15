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
public class AssocierCours extends JFrame {
	JPanel pan_principal_AC = new JPanel();
	JLabel lb_cours = new JLabel("saisissez un cours");
	JTextField tf_cours = new JTextField("");
	JButton bt_retour = new JButton("retour");
	
	

	public AssocierCours() {
		// Param�tres de la fen�tre
		setTitle("Associer un cours � un �tudiant");
		setSize(800, 400);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		// ajout d'objets dans le conteneur
		pan_principal_AC.add(lb_cours);
		pan_principal_AC.add(tf_cours);
		pan_principal_AC.add(bt_retour);
		
		// Agencement du conteneur
		pan_principal_AC.setBounds(0,0,3,4);
		pan_principal_AC.setLayout(new BorderLayout());
		
        pan_principal_AC.setPreferredSize(new Dimension(360, 480));
        BoxLayout bl_AC = new BoxLayout(pan_principal_AC, BoxLayout.PAGE_AXIS);
        pan_principal_AC.setLayout(bl_AC);
        pan_principal_AC.setBackground(Color.lightGray);
		
		// Action du bouton
		bt_retour.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				// Instancier une fen�tre
				Accueil accueil = new Accueil();
				// Afficher la fen�tre suivante
				accueil.setVisible(true);
				dispose();

			}
		});

		
		// Afficher le conteneur
		setContentPane(pan_principal_AC);
	 
 
	}

}
