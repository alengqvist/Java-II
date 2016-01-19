package zoo_application;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/** 
 * This class handles the creation and management of the ZooPanel (the map).
 * 
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 10:08, Januari 17, 2016.
 * 
 * @extends JPanel
 * @implements ExerciseListener
 */
public class ZooPanel extends JPanel implements ExerciseListener {

	private static final long serialVersionUID = 1L;
	
	// Constants to avoid string dependencies.
	private static final int SHARK = 1;
	private static final int TIGER = 2;
	private static final int CAT = 3;

	// Member variables.
	private Zoo zoo;							// Instance of the Zoo.
	
	// GUI-components.
	private OptionPanel optionPanel;			// Instance of the OptionPanel.
	private BufferedImage backgroundImage;		// BackgroundImage e.g the map.
	
	/**
	 * Constructor.
	 * Initializes the GUI of the ZooPanel.
	 * 
	 * @param optionPanel
	 * @param zoo
	 */
	public ZooPanel(OptionPanel optionPanel, Zoo zoo) {
		this.optionPanel = optionPanel;
		this.zoo = zoo;
		
		this.optionPanel.addListener(this);

		addMap();
		
		MapListener listener = new MapListener();
		addMouseListener(listener);
	}
	
	/**
	 * Adds the map to the JPanel.
	 */
	private void addMap() {
		try {
			backgroundImage = ImageIO.read(new File("zoo_map.png"));			
			setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Paints the components into the JPanel.
	 * 
	 * @param graphics
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		if (backgroundImage != null) {
			graphics.drawImage(backgroundImage, 0, 0, null);
			
	    	for (Animal animal : zoo.getAnimals()) {
	    		BufferedImage image = animal.getImage();
	    		int x = image.getWidth()/2;
	    		int y = image.getHeight()/2;
	    		graphics.drawImage(animal.getImage(), animal.getX()-x, animal.getY()-y, null);
	    	}
		}		
	}
	
	/**
	 * Class which listens when the user puts an animal into the zoo.
	 */
    private class MapListener extends MouseInputAdapter {

    	@Override
    	public void mouseReleased(MouseEvent e) {    		
			try {
				
				Animal animal = null;
				
	    		switch (optionPanel.getSelection()) {
	    		case SHARK:
	    			animal = new Shark("Hajen Lennart", 1000);
	    			break;
	    		case TIGER:
	    			animal = new Tiger("Tigern Bengt", 500);
	    			break;
	    		case CAT:
	    			animal = new Cat("Katten Sven", 3);
	    			break;
	    		}
	    		
	    		if (animal != null) {
	    			Point p = e.getPoint();
	    			animal.setX(p.x);
	    			animal.setY(p.y);
	    			zoo.addAnimal(animal);
	    			repaint();
	    		}
	    		
			} catch (ZooException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
    	}
    }

	/**
	 * Exercises the animals when the user clicks the exercise button.
	 */
	@Override
	public void exercise() {
		zoo.exerciseAllAnimals();
		repaint();
	}
}