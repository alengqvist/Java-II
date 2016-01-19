package zoo_application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** 
 * This class handles the creation of a Shark.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 09:12, Januari 17, 2016.
 * 
 * @extends Animal
 */
public class Shark extends Animal {

	/**
	 * Constructor.
	 * Calls the superclass Animal.
	 * 
	 * @param name
	 * @param weight
	 */
	public Shark(String name, int weight) {
		super(AnimalType.SHARK, name, weight);
	}

	/**
	 * Gets the image of the animal.
	 * 
	 * @return bufferedImage
	 */
	@Override
	public BufferedImage getImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("shark.png"));
		} catch (IOException e) {
			
		}
		return img;
	}
}