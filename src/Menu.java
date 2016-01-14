import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * La classe qui gére l'interface utilisateur 
 * de la fenêtre d'accueil de l'application.
 * @author TORO DAPP BOUCHER
 *
 */
public class Menu {
	/**	Bouton pour lancer une nouvelle partie, en charger une ou quitter l'application. */
	private JButton newGameButton, loadButton, exitButton;
	/**	Nouvelle fenêtre pour l'affichage du menu d'accueil */
	private JFrame menuFrame = new JFrame();
	/**	 Nouveau layout pour la disposition des éléments*/
	private JPanel menuPanel = new JPanel();
	/**	 Vérification de L'OS sur lequel le jeux est lancé.*/
	private static String OS = System.getProperty("os.name").toLowerCase();
	/**	Correction de la taille de la fenêtre. */
	private int windowSizeCorrection = 0;
	
	/**	 
	 * Constructeur d'objet de la classe Menu.
	 */
	public Menu() {
		
		if(isWindows()) {
			this.windowSizeCorrection = 30;
		}
		
		this.menuFrame.setTitle("Tamagotchi");
	    this.menuFrame.setSize(220, 220+windowSizeCorrection);
	    this.menuFrame.setLocationRelativeTo(null);
	    this.menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.menuFrame.setResizable(false);
	    
	    this.newGameButton = new JButton("New game");
	    this.loadButton = new JButton("Load saved game");
	    this.exitButton = new JButton("Exit");
	    
	    this.newGameButton.setBounds(30, 30, 160, 30);
	    this.loadButton.setBounds(30, 90, 160, 30);
	    this.exitButton.setBounds(30, 150, 160, 30);
	    
	    this.menuPanel.setLayout(null);
	    
	    this.menuPanel.add(this.newGameButton);
	    this.menuPanel.add(this.loadButton);
	    this.menuPanel.add(this.exitButton);
		
	    this.menuFrame.setContentPane(this.menuPanel);
	    
	    this.menuFrame.setVisible(true);
	    
		this.newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewGameMenu();
				menuFrame.dispose();
			}
	    });
		
		this.loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoadGameMenu();
				menuFrame.dispose();
			}
	    });
		
		this.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
			}
	    });
		
	}
	
	/**	
	 * Vérifie l'OS sur lequel est lancé le jeu.
	 * @return
	 * 		True si on est sur windows , false sinon.
	 */
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}
	
}
