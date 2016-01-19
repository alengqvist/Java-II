package zoo_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/** 
 * This class handles the creation and management of the ZooGUI.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 10:08, Januari 17, 2016.
 * 
 * @extends JFrame
 */
public class ZooGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Member variables.
	private Zoo zoo;					// Instance of the Zoo.
	
	// GUI-components.
	private ZooPanel zooPanel;			// Instance of the ZooPanel.
	private OptionPanel optionPanel;	// Instance of the OptionPanel.

	/**
	 * Constructor.
	 * Initializes the ZooGUI.
	 */
	public ZooGUI() {
		super();
		
		// Create instance of a Zoo.
		zoo = new Zoo("Mitt Zoo", 10);
		
		// Set the name of the Zoo.
		setTitle(zoo.getName());
		
		// Window settings.
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(500, 370));

		// Initialize the GUI-components inside this component.
		initComponents();

		// Set size of the window to preferred size.
		pack();
		
		// Center the window on the screen.
		setLocationRelativeTo(null);

		// Display the component.
		setVisible(true);
	}

	/**
	 * Initializes the Menu, ZooPanel and OptionPanel.
	 */
	private void initComponents() {
		
		// Create MenuBar.
		JMenuBar menuBar = new JMenuBar();

		// Create a Menu.
		JMenu menu1 = new JMenu("File");

		// Create Clear-button in the menu.
		JMenuItem menuItem1 = new JMenuItem(new AbstractAction("Clear") {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
		        zoo.clearZoo();
		        zooPanel.repaint();
		    }
		});
		
		// Create Save-button in the menu.
		JMenuItem menuItem2 = new JMenuItem(new AbstractAction("Save...") {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				if (zoo.getAnimals().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Du har inga djur att spara!");
				} else {
					save();
				}
		    }
		});
		
		// Add the MenuItems to the Menu.
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		
		// Add the Menu to the MenuBar.
		menuBar.add(menu1);

		// Add the MenuBar to the JFrame.
		setJMenuBar(menuBar);

		// Create and add the OptionPanel.
		optionPanel = new OptionPanel();
		add(optionPanel, BorderLayout.LINE_START);
		
		// Create and add the ZooPanel inside a ScrollPane.
		zooPanel = new ZooPanel(optionPanel, zoo);
		JScrollPane scroll = new JScrollPane(zooPanel);
		add(scroll, BorderLayout.LINE_END);
	}
	
	/**
	 * Saves to a file.
	 */
	private void save() {
		
		// Create JFileChooser.
		JFileChooser chooser = new JFileChooser();
        
		// Open dialog.
        int option = chooser.showSaveDialog(this);
        
        // If a file is selected for saving.
        if (option == JFileChooser.APPROVE_OPTION) {	   
        	
        	// Try writing to that file.
        	try {
	        	PrintWriter writer = new PrintWriter(chooser.getSelectedFile() + ".zoo.txt");
	        	
	        	// Loop through all animals in the zoo and write to the file.
	        	for (Animal animal : zoo.getAnimals()) {
		        	writer.println(animal.getType() + "; " + animal.getName() + "; " + animal.getWeight() + "; " + animal.isSleeping() + "; " + animal.getX() + "; " + animal.getY());
	        	}
		        writer.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
        }
   }

	public static void main(String args[]) {
		
		// Build and show GUI on separate thread.
		SwingUtilities.invokeLater(() -> new ZooGUI().setVisible(true));
	}
}