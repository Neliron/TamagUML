import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La classe qui va gérer le moteur graphique du jeu, 
 * c'est à dire l'affichage qu'il va y avoir une fois la partie lancé.
 * 
 * @author TORO DAPP BOUCHER
 *
 */
public class Engine {
	
	/**	Bouton pour augmenter la variable hunger. */
	private JButton feed;
	/**	Bouton pour augmenter la variable morale. */
	private JButton raiseMorale;
	/**	Bouton pour augmenter la variable focus. */
	private JButton pray;
	/**	Différents texte affiché à l'écran */
	private JLabel img, hungerText, moraleText, focusText, status, name;
	/**	La fenêtre du jeu */
	private JFrame frame = new JFrame();
	/**	Le layout de la fenêtre */
	private JPanel panel = new JPanel();
	/**	Le tamagotchi */
	private Creature pet;
	/** Verification de L'OS sur lequel le jeux est lancé. */
	private static String OS = System.getProperty("os.name").toLowerCase();
	/** Correction de la taille de la fenêtre. */
	private int windowSizeCorrection = 0;
	
	/**
	 * Constructeur de l'objet Engine.
	 * @param creature
	 * 		Le tamagotchi que le joueur à crée /choisis.
	 */
	public Engine(Creature creature) {
		
		if(isWindows()) {
			this.windowSizeCorrection = 30;
		}

	    this.frame.setTitle("Tamagotchi");
	    this.frame.setSize(800, 640+windowSizeCorrection);
	    this.frame.setLocationRelativeTo(null);
	    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.frame.setResizable(false);
		
		this.pet = creature;
		
		if(this.pet.getRaceId() == 1) {
			this.feed = new JButton("Hunt humans");
			this.raiseMorale = new JButton("Fight Angels");
			this.pray = new JButton("Worship Satan");
			this.img = new JLabel(new ImageIcon("res/demon.png"));
		} else if(this.pet.getRaceId() == 2) {
			this.feed = new JButton("Reap souls");
			this.raiseMorale = new JButton("Possess human");
			this.pray = new JButton("Haunt crypt");
			this.img = new JLabel(new ImageIcon("res/banshee.png"));
		}
		
		
		this.img.setBounds(this.frame.getWidth()/2-this.img.getIcon().getIconWidth()/2, 0, 300, 300);
		
		this.hungerText = new JLabel("Hunger : " + pet.getHunger() + " %");
		this.moraleText = new JLabel("Morale : " + pet.getMorale() + " %");
		this.focusText = new JLabel("Focus  : " + pet.getFocus() + " %");
		this.status = new JLabel(Creature.STATUSNAME[pet.getRaceId()-1][pet.getStatus()]);
		this.name = new JLabel(pet.getName());
		
		this.hungerText.setBounds(10, 520, 150, 30);
		this.moraleText.setBounds(10, 560, 150, 30);
		this.focusText.setBounds(10, 600, 150, 30);
		
		this.status.setBounds(325, 560, 150, 30);
		this.name.setBounds(325, 520, 150, 30);
	    
	    this.feed.setBounds(640, 520, 150, 30);
	    this.raiseMorale.setBounds(640, 560, 150, 30);
	    this.pray.setBounds(640, 600, 150, 30);
	    
	    
	    this.feed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pet.modifyHunger(20);
				update();
			}
	    });
	    
	    this.raiseMorale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pet.modifyMorale(20);
				update();
			}
	    });
	    
	    this.pray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pet.modifyFocus(20);
				update();
			}
	    });
	    
	    this.panel.setLayout(null);
	    
	    this.panel.add(this.hungerText);
	    this.panel.add(this.moraleText);
	    this.panel.add(this.focusText);
	    this.panel.add(this.feed);
	    this.panel.add(this.raiseMorale);
	    this.panel.add(this.pray);
	    this.panel.add(this.img);
	    this.panel.add(this.name);
	    this.panel.add(this.status);
	    
	    this.frame.setContentPane(this.panel);
	    
	    this.frame.setVisible(true);
	}
	
	/**
	 * Met à jour l'affichage des jauges.
	 */
	public void update() {
		this.hungerText.setText("Hunger : " + this.pet.getHunger() + " %");
		this.moraleText.setText("Morale : " + this.pet.getMorale() + " %");
		this.focusText.setText("Focus : " + this.pet.getFocus() + " %");
		this.status.setText(Creature.STATUSNAME[pet.getRaceId()-1][pet.getStatus()]);
	}
	
	/**
	 * Vérifie l'OS sur lequel est lancé le jeu.
	 * @return
	 * 		True si on est sur windows , false sinon.
	 */
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}
	
	/**
	 * Retourne l'objet frame de type JFrame.
	 * @return
	 * 		Retourne un objet de type JFrame.
	 */
	public JFrame getFrame() {
		return this.frame;
	}

}
