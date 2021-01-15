package GUI;

import service.JdbcService;
import domaine.ResponsableEtudes;

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



@SuppressWarnings("serial")
public class Connexion extends JFrame {
	
	JPanel pan_principal_connexion = new JPanel();
	JLabel lb_login = new JLabel("Nom d'utilisateur");
	JTextField tf_login = new JTextField("");
	JLabel lb_password = new JLabel("Mot de passe");
	JTextField tf_password = new JTextField("");
	JButton bt_valider = new JButton("Valider");
	JLabel error_conn = new JLabel("Votre nom d'utilisateur ou mot de passe sont incorrects. Veuillez réessayer.");

	
	String login = "";
	String password = "";
	Boolean connecte = false;
	Boolean type = false;
	int size;

	
	
	public Connexion() {
		
	// Paramètres de la fenêtre
		setTitle("Connexion");
		setSize(400, 200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

        // Ajout des composants dans le conteneur
		pan_principal_connexion.add(lb_login);
		pan_principal_connexion.add(tf_login);
		pan_principal_connexion.add(lb_password);
		pan_principal_connexion.add(tf_password);
		pan_principal_connexion.add(bt_valider);
		
		// Agencement du conteneur
		pan_principal_connexion.setBounds(0,0,3,4);
		pan_principal_connexion.setLayout(new BorderLayout());
	    pan_principal_connexion.setPreferredSize(new Dimension(360, 480));
	    BoxLayout bl_connexion = new BoxLayout(pan_principal_connexion, BoxLayout.PAGE_AXIS);
	    pan_principal_connexion.setLayout(bl_connexion);
	    pan_principal_connexion.setBackground(Color.LIGHT_GRAY);

        
		// Action du bouton
	    bt_valider.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				JdbcService service;
				service = new JdbcService();
				
				service.serviceAuthentification();
				
				
				ResponsableEtudes connBDD = service.serviceAuthentification();
					
				login = tf_login.getText();
				password = tf_password.getText();

				
				if (login.equals(connBDD.getLogin()) && password.equals(connBDD.getPassword())) {
					connecte = true;
					if (connBDD.getType()) {
						type = true;
					}else {
						type = false;
					}
				}
				
				
				// Instancier une fenêtre
				Accueil accueil = new Accueil();
				// Afficher les fenêtres suivantes selon la connection de l'utilisateur
				
				if (connecte == false) {

					pan_principal_connexion.add(error_conn);
					pan_principal_connexion.setVisible(true);
					setContentPane(pan_principal_connexion);
						
				}else {
					accueil.setVisible(true);
					dispose();
				}

			}
		});
	
		// Afficher le conteneur
		setContentPane(pan_principal_connexion);
		
		
	}

}
