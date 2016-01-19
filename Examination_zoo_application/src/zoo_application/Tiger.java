package zoo_application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** 
 * This class handles the creation of a Tiger.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 09:12, Januari 17, 2016.
 * 
 * @extends Animal
 */
public class Tiger extends Animal {

	/**
	 * Constructor.
	 * Calls the superclass Animal.
	 * 
	 * @param name
	 * @param weight
	 */
	public Tiger(String name, int weight) {
		super(AnimalType.TIGER, name, weight);
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
			img = ImageIO.read(new File("tiger.png"));
		} catch (IOException e) {
			
		}
		return img;
	}
}