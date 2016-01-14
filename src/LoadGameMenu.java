import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class LoadGameMenu {

	private JButton loadButton, returnButton;
	/**	 */
	private JFrame loadGameFrame = new JFrame();
	/**	 */
	private JPanel loadGamePanel = new JPanel();
	
	private JRadioButton save1Radio, save2Radio, save3Radio;
	
	private ButtonGroup saveChoice;
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private int windowSizeCorrection = 0;
	
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
	
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}
	
}
