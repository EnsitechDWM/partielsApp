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
import domaine.Etudiant;
import service.JdbcService;

@SuppressWarnings("serial")
public class CreerEtudiant extends JFrame {
	
	JPanel pan_principal_CE = new JPanel();
	JLabel lb_nom = new JLabel("saisissez un nom d'utilisateur");
	JTextField tf_nom = new JTextField("");
	
	JLabel lb_prenom = new JLabel("saisissez un prénom");
	JTextField tf_prenom = new JTextField("");
	
	JLabel lb_email = new JLabel("saisissez un email");
	JTextField tf_email = new JTextField("");
	
	JLabel lb_adresse = new JLabel("saisissez une adresse postale");
	JTextField tf_adresse = new JTextField("");
	
	JLabel lb_tel = new JLabel("saisissez un numéro de téléphone");
	JTextField tf_tel = new JTextField("");
	
	JLabel lb_naissance = new JLabel("saisissez une date de naissance(JJ.MM.AAAA)");
	JTextField tf_naissance = new JTextField("");
	
	JButton bt_retour = new JButton("retour");
	JButton bt_valider = new JButton("valider");
	
	
	public CreerEtudiant() {
		// Paramètres de la fenêtre
		setTitle("Créer un étudiant");
		setSize(800, 400);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pan_principal_CE.setLayout(new BorderLayout());
		
		// ajout d'objets dans le conteneur
		pan_principal_CE.add(lb_nom);
		pan_principal_CE.add(tf_nom);
		
		pan_principal_CE.add(lb_prenom);
		pan_principal_CE.add(tf_prenom);
		
		pan_principal_CE.add(lb_email);
		pan_principal_CE.add(tf_email);
		
		pan_principal_CE.add(lb_adresse);
		pan_principal_CE.add(tf_adresse);
		
		pan_principal_CE.add(lb_tel);
		pan_principal_CE.add(tf_tel);
		
		pan_principal_CE.add(lb_naissance);
		pan_principal_CE.add(tf_naissance);
		
		pan_principal_CE.add(bt_retour, BorderLayout.LINE_START);
		pan_principal_CE.add(bt_valider, BorderLayout.LINE_END);
		
		// Agencement du conteneur
		pan_principal_CE.setBounds(0,0,3,4);
		pan_principal_CE.setLayout(new BorderLayout());
		
        pan_principal_CE.setPreferredSize(new Dimension(360, 480));
        BoxLayout bl_CE = new BoxLayout(pan_principal_CE, BoxLayout.PAGE_AXIS);
        pan_principal_CE.setLayout(bl_CE);
        pan_principal_CE.setBackground(Color.lightGray);
		
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
				
				Etudiant etudiantCree = new Etudiant(1, tf_nom.getText(), tf_prenom.getText(), tf_email.getText(), tf_adresse.getText(), tf_tel.getText(), tf_naissance.getText());

				JdbcService service = new JdbcService();
				service.serviceCreerEtudiant(etudiantCree);
				
				

			}
		});

		
		// Afficher le conteneur
		setContentPane(pan_principal_CE);
	 
	}
}
