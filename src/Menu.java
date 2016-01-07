import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu {
	
	private JButton newGameButton, loadButton, exitButton;
	/**	 */
	private JFrame menuFrame = new JFrame();
	/**	 */
	private JPanel menuPanel = new JPanel();
	
	public Menu() {
		
		this.menuFrame.setTitle("Tamagotchi");
	    this.menuFrame.setSize(200, 250);
	    this.menuFrame.setLocationRelativeTo(null);
	    this.menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.menuFrame.setResizable(false);
	    
	    this.newGameButton = new JButton("New game");
	    this.loadButton = new JButton("Load saved game");
	    this.exitButton = new JButton("Exit");
	    
	    this.newGameButton.setBounds(30, 30, 140, 30);
	    this.loadButton.setBounds(30, 90, 140, 30);
	    this.exitButton.setBounds(30, 150, 140, 30);
	    
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
				// TODO add load menu
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
	
}
