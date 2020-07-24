package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

public class TestEditor implements Editor {

	@Override
	public String name = "default";

	@Override
	public BufferedImage editImage(BufferedImage image) {
		System.out.println("hi");
		return null;
	}
}
