package converter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;


/** 
 * This class creates a window-based application which takes a String
 * and converts it into a set of Binary numbers.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:25, November 12, 2015.
 */
public class ConverterGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 3495883917426331695L;

	// GUI-components.
	JButton convertButton;
	JTextArea inputTextArea;
	JTextArea outputTextArea;
	
	public static void main(String[] args) {
		
		// Build and show GUI on separate thread.
		SwingUtilities.invokeLater(() -> new ConverterGUI().setVisible(true));
	}
	
	/**
	 * Constructor which builds the GUI.
	 */
	public ConverterGUI() {

		// Setup JFrame.
		setTitle("String to Binary");		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(800, 500);			
		setMinimumSize(new Dimension(300, 200));

		// Add window listener for Exit.
		addWindowListener( 
		    new WindowAdapter() { 
		        public void windowClosing(WindowEvent e) { 
		            exit(); 
		        } 
		    } 
		);
		
		// Set WindowIcon. (Can't use it on OSX, no support?)
		ArrayList<Image> iconImages = new ArrayList<Image>();
		iconImages.add(new ImageIcon("miun16x16.png").getImage());
		iconImages.add(new ImageIcon("miun32x32.png").getImage());
		iconImages.add(new ImageIcon("miun64x64.png").getImage());
		setIconImages(iconImages);
		
		// Add GUI-components.
		addMenu();
		addComponents();		
	}

	/**
	 * Add a Menu to the JFrame.
	 */
	private void addMenu() {
		
		// Create MenuBar.
		JMenuBar menuBar = new JMenuBar();

		// Create a Menu.
		JMenu menu1 = new JMenu("File");

		// Create three MenuItems.
		JMenuItem menuItem1 = new JMenuItem("New");
		JMenuItem menuItem2 = new JMenuItem("Convert to Binary");
		JMenuItem menuItem3 = new JMenuItem("Exit");

		// Set Mnemonic for each selection.
		menu1.setMnemonic(KeyEvent.VK_M);
		menuItem1.setMnemonic(KeyEvent.VK_1);
		menuItem2.setMnemonic(KeyEvent.VK_2);
		menuItem3.setMnemonic(KeyEvent.VK_3);

		// Add a ActionListener to each MenuItem.
		menuItem1.addActionListener(this);
		menuItem2.addActionListener(this);
		menuItem3.addActionListener(this);

		// Add the MenuItems to the Menu.
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.addSeparator();
		menu1.add(menuItem3);

		// Add the Menu to the MenuBar.
		menuBar.add(menu1);

		// Add the MenuBar to the JFrame.
		setJMenuBar(menuBar);
	}
	
	/**
	 * Add the GUI-components (e.g two TextAreas and one Button).
	 */
	private void addComponents() {
		
		// Create TextArea for input.
		inputTextArea = new JTextArea();
		inputTextArea.setToolTipText("Write you message here.");
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
		add(inputScrollPane, BorderLayout.PAGE_START);
		
		// Create Button for converting.
		convertButton = new JButton("Convert to Binary");
		convertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		convertButton.addActionListener(this);
		add(convertButton, BorderLayout.CENTER);
		
		// Create TextArea for output.
		outputTextArea = new JTextArea();
		outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
		add(outputScrollPane, BorderLayout.PAGE_END);
	}

	/**
	 * Performs the action for each selection.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "New":
				reset();
			break;
			case "Convert to Binary":
				convertToBinary();
			break;
			case "Exit":
				exit();
			break;
		}		
	}
	
	/**
	 * Resets the TextAreas.
	 */
	private void reset() {
		inputTextArea.setText(null);
		outputTextArea.setText(null);
	}

	/**
	 * Converts the String to Binary.
	 */
	private void convertToBinary() {
		
		// Get the input.
		String s = inputTextArea.getText();
		
		byte[] bytes = s.getBytes();
		StringBuilder binary = new StringBuilder();

		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}	
		
		// Set the output.
		outputTextArea.setText(binary.toString());  
	}
	
	/**
	 * Exits the application.
	 */
	private void exit() {
		
        // Display confirm dialog.
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION); 
        
        // Exit if user confirmed.
        if (confirmed == JOptionPane.YES_OPTION) {                             
             System.exit(0);
        } 
	}
}