package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

/**
 * This class is the default Editor to use if one is not specified.
 */
public class DefaultEditor implements Editor {

	@Override
	public String getName() {
		return "default";
	}

	@Override
	public BufferedImage editImage(BufferedImage image) {
		System.out.println("hi");
		return null;
	}
}
