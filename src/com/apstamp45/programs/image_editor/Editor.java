package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

/**
 * This interface is used
 * to edit images.
 * 
 * @author apstamp45
 * @version 1.3
 */
public interface Editor {
	/**
	 * Returns the class's name.
	 * 
	 * @return the name.
	 */
	public String getName();

	/**
	 * Edits and returns a new image.
	 * 
	 * @param image the original image.
	 * @return the edited image.
	 */
	public BufferedImage editImage(BufferedImage image, String[] args);

	/**
	 * This function returns a Pixel with
	 * the rgb values based on the int input.
	 */
	public static Pixel rgbToPixel(int rgb) {
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		return new Pixel(r, g, b);
	}
	/**
	 * This function gets an rgb int value
	 * from a Pixel.
	 * @param pixel the pixel.
	 * @return the rgb value.
	 */
	public static int pixelToRgb(Pixel pixel) {
		int rgb = rgbToInt(pixel.r, pixel.g, pixel.b);
		return rgb;
	}

	/**
	 * This converts rgb values to an int.
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */
	public static int rgbToInt(int r, int g, int b) {
		int rgb = r;
		rgb = (rgb << 8) + g;
		rgb = (rgb << 8) + b;
		return rgb;
	}
}
