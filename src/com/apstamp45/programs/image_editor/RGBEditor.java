package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

/**
 * This editor makes each pixel of an
 * image either red, green, or blue.
 * 
 * @author apstamp45
 * @version 1.0
 */
public class RGBEditor implements Editor {
    
    @Override
	public String getName() {
		return "RGB";
	}

	@Override
	public BufferedImage editImage(BufferedImage image, String[] args) {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage editedImage = image;
		TestEditor.RGBFilter filter = new TestEditor.RGBFilter();
		Pixel pixel;
		Pixel editedPixel;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int rgb = image.getRGB(x, y);
				pixel = Editor.rgbToPixel(rgb);
				editedPixel = filter.filter(pixel);
				editedImage.setRGB(x, y, Editor.pixelToRgb(editedPixel));
			}
		}
		return editedImage;
	}

	/**
	 * This class is used by this editor
	 * to reduce each pixel to either
	 * a red, green, or blue hue.
	 */
	static class RGBFilter implements Filter {
		@Override
		public Pixel filter(Pixel pixel) {
			int largest;
			if (pixel.r > pixel.g) {
				if (pixel.r > pixel.b) {
					largest = 0;
				} else {
					largest = 2;
				}
			} else {
				if (pixel.g > pixel.b) {
					largest = 1;
				} else {
					largest = 2;
				}
			}
			if (largest == 0) {
				return new Pixel(255, 0, 0);
			} else if (largest == 1) {
				return new Pixel(0, 255, 0);
			} else {
				return new Pixel(0, 0, 255);
			}
		}
	}
}