 package com.apstamp45.programs.image_editor;

/**
 * This interface represents an
 * image filter, and is used by
 * the (ImageEditor)s.
 * 
 * @author apstamp45
 * @version 1.0
 */
public interface Filter {
	/**
	 * This function takes a pixel as
	 * an input an input and returns
	 * another (probably different from
	 * the first).
	 * @param pixel The unedited pixel.
	 * @return The finnised pixel.
	 */
	public Pixel filter(Pixel pixel);
}
