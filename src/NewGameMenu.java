import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class NewGameMenu {
	
	private JButton startButton, returnButton;
	/**	 */
	private JFrame newGameFrame = new JFrame();
	/**	 */
	private JPanel newGamePanel = new JPanel();
	
	private JRadioButton demonRadio, bansheeRadio, save1Radio, save2Radio, save3Radio;
	
	private ButtonGroup raceChoice, saveChoice;
	
	private JTextField nameField;
	
	public NewGameMenu() {
		
		this.newGameFrame.setTitle("Tamagotchi");
	    this.newGameFrame.setSize(300, 240);
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
	
}
