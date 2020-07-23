package image_editor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class lets you edit images with
 * different filters.
 * 
 * @author apstamp45
 * @version 0.1
 */
public class Main {
	
	
	private static BufferedImage getImage(String path) {
		File file = null;
		BufferedImage image = null;
		try {
			file = new File(path);
		} catch (IOException e) {
			
		}
		return null;
	}
}
