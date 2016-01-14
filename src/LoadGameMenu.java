import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * La classe qui gére l'interface utilisateur 
 * de la fenêtre de chargement d'une partie.
 * 
 * @author TORO DAPP BOUCHER
 *
 */

public class LoadGameMenu {
	/** Bouton pour charger une partie ou pour retourner à l'écran d'accueil	 */
	private JButton loadButton, returnButton;
	/**	Nouvelle Fenêtre pour afficher les options de chargement d'une partie */
	private JFrame loadGameFrame = new JFrame();
	/**	Nouveau layout pour la disposition des éléments. */
	private JPanel loadGamePanel = new JPanel();
	/** Case à cocher correspondant aux choix de l'emplacement de sauvegardes.	 */
	private JRadioButton save1Radio, save2Radio, save3Radio;
	/** Empeche de choisir plusieurs emplacement de sauvegarde en même temps.	 */
	private ButtonGroup saveChoice;
	/** Verification de L'OS sur lequel le jeux est lancé. */
	private static String OS = System.getProperty("os.name").toLowerCase();
	/** Correction de la taille de la fenêtre. */
	private int windowSizeCorrection = 0;
	
	/**	 
	 * Constructeur de l'objet LoadGameMenu
	 */
	public LoadGameMenu() {
		
		if(isWindows()) {
			this.windowSizeCorrection = 30;
		}
		
		this.loadGameFrame.setTitle("Tamagotchi");
	    this.loadGameFrame.setSize(330, 160+windowSizeCorrection);
	    this.loadGameFrame.setLocationRelativeTo(null);
	    this.loadGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.loadGameFrame.setResizable(false);
	    
	    this.save1Radio = new JRadioButton("Slot 1", true);
	    this.save2Radio = new JRadioButton("Slot 2", false);
	    this.save3Radio = new JRadioButton("Slot 3", false);
	    
	    this.saveChoice = new ButtonGroup();
	    this.saveChoice.add(save1Radio);
	    this.saveChoice.add(save2Radio);
	    this.saveChoice.add(save3Radio);
	    
	    this.loadButton = new JButton("Load");
	    this.returnButton = new JButton("Return to menu");
	    
	    this.save1Radio.setBounds(10, 10, 150, 20);
	    this.save2Radio.setBounds(10, 40, 150, 20);
	    this.save3Radio.setBounds(10, 70, 150, 20);
	    this.loadButton.setBounds(10, 120, 150, 30);
	    this.returnButton.setBounds(170, 120, 150, 30);
	    
	    this.loadGamePanel.setLayout(null);
	    
	    this.loadGamePanel.add(save1Radio);
	    this.loadGamePanel.add(save2Radio);
	    this.loadGamePanel.add(save3Radio);
	    this.loadGamePanel.add(loadButton);
	    this.loadGamePanel.add(returnButton);
	    
	    this.loadGameFrame.setContentPane(this.loadGamePanel);
	    
	    this.loadGameFrame.setVisible(true);
	    
	    this.loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = "";
				
				if(save1Radio.isSelected())
					path = "save/save1.txt";
				else if(save2Radio.isSelected())
					path = "save/save2.txt";
				else if(save3Radio.isSelected())
					path = "save/save3.txt";
				
				new Game(path);
				
				loadGameFrame.dispose();
				
			}
	    });
		
		this.returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu();
				loadGameFrame.dispose();
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
