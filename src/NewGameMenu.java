import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * La classe qui gére l'interface utilisateur 
 * de la fenêtre de lancement d'une nouvelle partie.
 * @author TORO DAPP BOUCHER
 *
 */
public class NewGameMenu {
	/** Bouton pour lancer une partie ou revenir à l'accueil.	 */
	private JButton startButton, returnButton;
	/**	Nouvelle fenêtre pour la création d'un tamagotchi. */
	private JFrame newGameFrame = new JFrame();
	/**Nouveau layout pour la disposition des éléments.	 */
	private JPanel newGamePanel = new JPanel();
	/** Case à cocher correspondant aux choix de l'emplacement de sauvegardes ou au choix de la race */
	private JRadioButton demonRadio, bansheeRadio, save1Radio, save2Radio, save3Radio;
	/** Empeche de choisir plusieurs emplacement de sauvegarde en même temps ou plusieurs race.*/
	private ButtonGroup raceChoice, saveChoice;
	/**	Champs de saisie du nom. */
	private JTextField nameField;
	/**	Verification de L'OS sur lequel le jeux est lancé. */
	private static String OS = System.getProperty("os.name").toLowerCase();
	/**	Correction de la taille de la fenêtre. */
	private int windowSizeCorrection = 0;
	
	/**
	 * Constructeur d'un objet NewGameMenu
	 */
	public NewGameMenu() {
		
		if(isWindows()) {
			this.windowSizeCorrection = 30;
		}
		
		this.newGameFrame.setTitle("Tamagotchi");
	    this.newGameFrame.setSize(300, 240+windowSizeCorrection);
	    this.newGameFrame.setLocationRelativeTo(null);
	    this.newGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.newGameFrame.setResizable(false);
	    
	    this.demonRadio = new JRadioButton("Demon", true);
	    this.bansheeRadio = new JRadioButton("Banshee", false);
	    
	    this.raceChoice = new ButtonGroup();
	    this.raceChoice.add(demonRadio);
	    this.raceChoice.add(bansheeRadio);
	    
	    this.save1Radio = new JRadioButton("Slot 1", true);
	    this.save2Radio = new JRadioButton("Slot 2", true);
	    this.save3Radio = new JRadioButton("Slot 3", true);
	    
	    this.saveChoice = new ButtonGroup();
	    this.saveChoice.add(this.save1Radio);
	    this.saveChoice.add(this.save2Radio);
	    this.saveChoice.add(this.save3Radio);
	    
	    this.nameField = new JTextField("Name");
	    
	    this.startButton = new JButton("Start game");
		this.returnButton = new JButton("Return to menu");
		
		this.nameField.setBounds(10, 10, 100, 30);
		this.demonRadio.setBounds(10, 50, 100, 20);
		this.bansheeRadio.setBounds(10, 80, 100, 20);
		this.save1Radio.setBounds(190, 10, 100, 20);
		this.save2Radio.setBounds(190, 40, 100, 20);
		this.save3Radio.setBounds(190, 70, 100, 20);
		this.startButton.setBounds(10, 170, 130, 30);
		this.returnButton.setBounds(155, 170, 130, 30);
		
		this.newGamePanel.setLayout(null);
	    
	    this.newGamePanel.add(this.startButton);
	    this.newGamePanel.add(this.returnButton);
	    this.newGamePanel.add(this.demonRadio);
	    this.newGamePanel.add(this.bansheeRadio);
	    this.newGamePanel.add(this.save1Radio);
	    this.newGamePanel.add(this.save2Radio);
	    this.newGamePanel.add(this.save3Radio);
	    this.newGamePanel.add(this.nameField);
		
	    this.newGameFrame.setContentPane(this.newGamePanel);
	    
	    this.newGameFrame.setVisible(true);
		
		this.startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = "";
				
				if(save1Radio.isSelected())
					path = "save/save1.txt";
				else if(save2Radio.isSelected())
					path = "save/save2.txt";
				else if(save3Radio.isSelected())
					path = "save/save3.txt";
				
				if(demonRadio.isSelected())
					new Game(nameField.getText(), 1, path);
				else
					new Game(nameField.getText(), 2, path);
				newGameFrame.dispose();
			}
	    });
		
		this.returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Menu();
				newGameFrame.dispose();
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
