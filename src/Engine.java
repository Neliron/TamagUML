import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author TORO DAPP
 *
 */
public class Engine {
	/**	 */
	private JButton feed;
	/**	 */
	private JButton raiseMorale;
	/**	 */
	private JButton pray;
	/**	 */
	private JLabel img, hungerText, moraleText, focusText;
	/**	 */
	private JFrame tamagochi = new JFrame();
	/**	 */
	private JPanel panel = new JPanel();
	/**	 */
	private Creature pet;
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private int windowSizeCorrection = 0;
	
	/**
	 * 
	 * @param creature
	 * 
	 */
	public Engine(Creature creature) {
		
		if(isWindows()) {
			this.windowSizeCorrection = 30;
		}
		

	    this.tamagochi.setTitle("Tamagotchi");
	    this.tamagochi.setSize(800, 640);
	    this.tamagochi.setLocationRelativeTo(null);
	    this.tamagochi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.tamagochi.setResizable(false);
		
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
			this.img = new JLabel(new ImageIcon("res/banshee.jpg"));
		}
		
		
		this.img.setBounds(0, 0, 300, 300);
		
		this.hungerText = new JLabel("Hunger : " + pet.getHunger() + " %");
		this.moraleText = new JLabel("Morale : " + pet.getMorale() + " %");
		this.focusText = new JLabel("Focus  : " + pet.getFocus() + " %");
		
		this.hungerText.setBounds(10, 520-windowSizeCorrection, 150, 30);
		this.moraleText.setBounds(10, 560-windowSizeCorrection, 150, 30);
		this.focusText.setBounds(10, 600-windowSizeCorrection, 150, 30);
	    
	    this.feed.setBounds(640, 520-windowSizeCorrection, 150, 30);
	    this.raiseMorale.setBounds(640, 560-windowSizeCorrection, 150, 30);
	    this.pray.setBounds(640, 600-windowSizeCorrection, 150, 30);
	    
	    
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
	    
	    this.tamagochi.setContentPane(this.panel);
	    
	    this.tamagochi.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void update() {
		this.hungerText.setText("Hunger : " + this.pet.getHunger() + " %");
		this.moraleText.setText("Morale : " + this.pet.getMorale() + " %");
		this.focusText.setText("Focus : " + this.pet.getFocus() + " %");
	}
	
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

}
