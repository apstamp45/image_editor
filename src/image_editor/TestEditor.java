package image_editor;

import java.awt.image.BufferedImage;

public class TestEditor implements ImageEditor {

	@Override
	public BufferedImage editImage(BufferedImage image) {
		System.out.println("hi");
		return null;
	}
}
