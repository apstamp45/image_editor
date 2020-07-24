package com.apstamp45.programs.image_editor;

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

	/**
	 * This constant provides the default
	 * editor to be used on the image.
	 */
	private static final Editor DEFAULT_EDITOR = new DefaultEditor();

	/**
	 * This constant is the default name
	 * of the output file.
	 */
	private static final String DEFAULT_OUTPUT_FILE_NAME = "output.png";

	/**
	 * Used to identify the input image
	 * file.
	 */
	private static String inputImagePath;

	/**
	 * Used to identify the ouput image
	 * file.
	 */
	private static String outputImagePath;

	/**
	 * Used to select the different effects.
	 */
	private static String editor;
	
	public static void main(String[] args) {
		getParamiters(args);
		System.out.println(editor);
		System.out.println(inputImagePath);
		System.out.println(outputImagePath);
	}

	private static void getParamiters(String[] args) {
		if (args.length > 0) {
			if (args.length == 1) {
				String arg1 = args[0];
				if (arg1.charAt(0) == '/') {
					inputImagePath = arg1;
					char[] $outputPath = arg1.toCharArray();
					int lastSlashIndex = -1;
					int i = 0;
					for (char c: $outputPath) {
						if (c == '/') {
							lastSlashIndex = i;
						}
						i++;
					}
					char[] outputPath = new char[lastSlashIndex + 1 + DEFAULT_OUTPUT_FILE_NAME.length()];
					i = 0;
					for (char c: outputPath) {
						if (i <= lastSlashIndex) {
							outputPath[i] = $outputPath[i];
						} else {
							outputPath[i] = DEFAULT_OUTPUT_FILE_NAME.charAt(i - lastSlashIndex - 1);
						}
						i++;
					}
					outputImagePath = String.valueOf(outputPath);
				} else {
					System.out.println("A full path is required for the image file.");
				}
			}
			if (args.length == 2) {
				String arg1 = args[0];
				if (arg1.charAt(0) == '/') {
					inputImagePath = arg1;
					String arg2 = args[1];
					if (arg2.charAt(0) == '/') {
						outputImagePath = arg2;
					} else {
						editor = arg2;
						char[] $outputPath = arg1.toCharArray();
						int lastSlashIndex = -1;
						int i = 0;
						for (char c: $outputPath) {
							if (c == '/') {
								lastSlashIndex = i;
							}
							i++;
						}
						char[] outputPath = new char[lastSlashIndex + 1 + DEFAULT_OUTPUT_FILE_NAME.length()];
						i = 0;
						for (char c: outputPath) {
							if (i <= lastSlashIndex) {
								outputPath[i] = $outputPath[i];
							} else {
								outputPath[i] = DEFAULT_OUTPUT_FILE_NAME.charAt(i - lastSlashIndex - 1);
							}
							i++;
						}
						outputImagePath = String.valueOf(outputPath);
					}
				} else {
					System.out.println("A full path is required for the image file.");
				}
			}
		} else {
			System.out.println("usage: java Main <inputImage> <outputImage>(optional) <Editor>(optional)");
		}
	}

	/**
	 * Gets the image file.
	 */
	private static void getImage() {
		File file = null;
		BufferedImage image = null;
		// try {
		// 	file = new File(path);
		// } catch (IOException e) {
			
		// }
	}
}
