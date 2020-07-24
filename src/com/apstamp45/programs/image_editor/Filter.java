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
	public Pixel filter(Pixel pixel);
}
