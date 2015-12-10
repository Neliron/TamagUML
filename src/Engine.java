import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Engine{
	
	private JButton feed = new JButton("Feed");
	private JButton raiseMorale = new JButton("Raise Morale");
	private JButton pray = new JButton("Pray");
	
	private JFrame tamagochi = new JFrame();
	
	private JPanel panel = new JPanel();
	
	public Engine(){

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
				System.out.println("Test !");
			}
	    });
	    
	    this.raiseMorale.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test 2 !");
			}
	    });
	    
	    this.pray.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test 3 !");
			}
	    });
	    
	    this.panel.setLayout(null);
	    
	    this.panel.add(this.feed);
	    this.panel.add(this.raiseMorale);
	    this.panel.add(this.pray);
	    
	    this.tamagochi.setContentPane(this.panel);
	    
	    this.tamagochi.setVisible(true);
	}
	
	public void update(){
		
	}

}
