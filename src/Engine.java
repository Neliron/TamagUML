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

	    tamagochi.setTitle("Test");
	    tamagochi.setSize(800, 640);
	    tamagochi.setLocationRelativeTo(null);
	    tamagochi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tamagochi.setResizable(false);
	    
	    feed.setBounds(640, 520, 150, 30);
	    raiseMorale.setBounds(640, 560, 150, 30);
	    pray.setBounds(640, 600, 150, 30);
	    
	    
	    feed.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test !");
			}
	    });
	    
	    raiseMorale.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test 2 !");
			}
	    });
	    
	    pray.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test 3 !");
			}
	    });
	    
	    panel.setLayout(null);
	    
	    panel.add(feed);
	    panel.add(raiseMorale);
	    panel.add(pray);
	    
	    tamagochi.setContentPane(panel);
	    
	    tamagochi.setVisible(true);
	}
	
	public void update(){
		
	}

}
