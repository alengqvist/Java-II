package zoo_application;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

import javax.imageio.*;

import java.io.*;

/** 
 * This class handles the creation and management of the OptionPanel.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 10:08, Januari 17, 2016.
 * 
 * @extends JPanel
 */
public class OptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Constants to avoid string dependencies.
	private static final int SHARK = 1;
	private static final int TIGER = 2;
	private static final int CAT = 3;

	// Member variables.
	private ExerciseListener exerciseListener;		// Observer.
	private int selection = 1;						// Selection of animal.

	// GUI-components.
	private JButton sharkButton;
	private JButton tigerButton;
	private JButton catButton;
	private BufferedImage sharkImage;
	private BufferedImage tigerImage;
	private BufferedImage catImage;
	
	/**
	 * Constructor.
	 * Initializes the GUI of the OptionPanel.
	 */
	public OptionPanel() {
		
		setLayout(new BorderLayout());

		JLabel selectionLabel = new JLabel("VŠlj ett djur:");
		
		JPanel selectionsPanel = new JPanel();
		selectionsPanel.setLayout(new BoxLayout(selectionsPanel, BoxLayout.Y_AXIS));
		
		JButton exerciseButton = new JButton("Motionera alla djur");
		exerciseButton.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) {
	        	exerciseListener.exercise();
	        }
	    });
		
		setupAnimalButtons();
		
		selectionsPanel.add(selectionLabel);
		selectionsPanel.add(sharkButton);
		selectionsPanel.add(tigerButton);
		selectionsPanel.add(catButton);
		add(selectionsPanel, BorderLayout.CENTER);
		add(exerciseButton, BorderLayout.PAGE_END);

	}
	
	/**
	 * Setups the buttons for animal selections.
	 */
	private void setupAnimalButtons() {
		
		try {
			sharkImage = ImageIO.read(new File("shark.png"));			
			tigerImage = ImageIO.read(new File("tiger.png"));			
			catImage = ImageIO.read(new File("cat.png"));			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sharkButton = new JButton(new ImageIcon(sharkImage));
		tigerButton = new JButton(new ImageIcon(tigerImage));
		catButton = new JButton(new ImageIcon(catImage));
		
		sharkButton.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) {
				selection = SHARK;
	        }
	    });
		
		tigerButton.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) {
				selection = TIGER;
	        }
	    });
		
		catButton.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) {
				selection = CAT;
	        }
	    });
	}
	
	/**
	 * Gets the selection from the animal menu.
	 * 
	 * @return selection
	 */
	public int getSelection() {
		return this.selection;
	}
	
	/**
	 * Observer which keeps track of the mouse coordinates.
	 * 
	 * @param observer - CoordinateListener
	 */
    public void addListener(ExerciseListener observer) {
    	exerciseListener = observer;
    }
}