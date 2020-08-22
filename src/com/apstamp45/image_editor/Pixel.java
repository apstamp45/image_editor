package com.apstamp45.image_editor;

/**
 * This class represents an
 * image pixel.
 * 
 * @author apstamp45
 * @version 1.0
 */
public class Pixel {
	/**
	 * Represents the red value of a pixel.
	 */
	public int r;

	/**
	 * Represents the green value of a pixel.
	 */
	public int g;

	/**
	 * Represents the blue value of a pixel.
	 */
	public int b;

	public Pixel(int r, int g, int b) {
		if (
			r > 255 || r < 0 ||
			g > 255 || g < 0 ||
			b > 255 || b < 0
			) {
			System.out.println("Invalid rgb values were passed into\nthe Pixel constructor.");
			System.exit(0);
		}
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
