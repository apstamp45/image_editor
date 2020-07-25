package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

/**
 * This class is a test Editor to use if one is not specified.
 */
public class TestEditor implements Editor {

	@Override
	public String getName() {
		return "TEST";
	}

	@Override
	public BufferedImage editImage(BufferedImage image) {
		System.out.println("hi");
		return null;
	}
}
