import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Engine{
	
	private JButton feed;
	private JButton raiseMorale;
	private JButton pray;
	private JLabel img;
	
	private JFrame tamagochi = new JFrame();
	
	private JPanel panel = new JPanel();
	
	private Creature pet;
	
	public Engine(Creature creature){
		
		this.pet = creature;
		if(this.pet.getRaceId() == 1){
			feed = new JButton("Hunt humans");
			raiseMorale = new JButton("Fight Angels");
			pray = new JButton("Worship Satan");
		} else if(this.pet.getRaceId() == 2) {
			feed = new JButton("Reap souls");
			raiseMorale = new JButton("Posess human");
			pray = new JButton("Haunt crypt");
		}
		
		this.img = new JLabel(new ImageIcon("res/demon.png"));
		this.img.setBounds(0, 0, 200, 200);
		
	    this.tamagochi.setTitle("Test");
	    this.tamagochi.setSize(800, 640);
	    this.tamagochi.setLocationRelativeTo(null);
	    this.tamagochi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.tamagochi.setResizable(false);
	    
	    this.feed.setBounds(640, 520, 150, 30);
	    this.raiseMorale.setBounds(640, 560, 150, 30);
	    this.pray.setBounds(640, 600, 150, 30);
	    
	    
	    this.feed.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pet.modifyHunger(20);
			}
	    });
	    
	    this.raiseMorale.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pet.modifyMorale(20);
			}
	    });
	    
	    this.pray.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pet.modifyFocus(20);
			}
	    });
	    this.panel.setLayout(null);
	    
	    this.panel.add(this.img);
	    this.panel.add(this.feed);
	    this.panel.add(this.raiseMorale);
	    this.panel.add(this.pray);
	    
	    this.tamagochi.setContentPane(this.panel);
	    
	    this.tamagochi.setVisible(true);
	}
	
	public void update(){
		
	}

}
