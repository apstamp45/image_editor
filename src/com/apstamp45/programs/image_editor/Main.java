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
 * @version 0.2
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
	 * This stores the editor name that
	 * was inputted by the user.
	 */
	private static String editorName;
	
	public static void main(String[] args) {
		processParamiters(args);
		System.out.println(editorName);
		System.out.println(inputImagePath);
		System.out.println(outputImagePath);
	}

	/**
	 * Processes the command line options.
	 * 
	 * @param args an array containing all the arguments.
	 */
	private static void processParamiters(String[] args) {
		if (args.length > 0) {
			if (args.length == 1) {
				String arg1 = args[0];
				if (!(arg1.charAt(0) == '/')) {
					System.out.println("A full path is required for the image file.");
					System.exit(0);
				}
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
				editorName = DEFAULT_EDITOR.getName();
			}
			if (args.length == 2) {
				String arg1 = args[0];
				if (!(arg1.charAt(0) == '/')) {
					System.out.println("A full path is required for the image file.");
					System.exit(0);
				}
				inputImagePath = arg1;
				String arg2 = args[1];
				int i = 0;
				boolean isIncompletePath = false;
				for (char c :arg2.toCharArray()) {
					if (arg2.charAt(i) == '/') {
						isIncompletePath = true;
					}
					i++;
				}
				if (arg2.charAt(0) == '/') {
					outputImagePath = arg2;
					editorName = DEFAULT_EDITOR.getName();
				} else if (isIncompletePath) {
					System.out.println("A full path is required for the image file.");
					System.exit(0);
				} else {
					editorName = arg2;
					char[] $outputPath = arg1.toCharArray();
					int lastSlashIndex = -1;
					i = 0;
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
			}
			if (args.length >= 3) {
				String arg1 = args[0];
				String arg2 = args[1];
				String arg3 = args[2];
				if (!(arg1.charAt(0) == '/')) {
					System.out.println("A full path is required for the image file.");
					System.exit(0);
				}
				inputImagePath = arg1;
				if (!(arg2.charAt(0) == '/')) {
					System.out.println("A full path is required for the image file.");
					System.exit(0);
				}
				outputImagePath = arg2;
				editorName = arg3;
			}
		} else {
			System.out.println("usage: java Main <inputImage> <outputImage>(optional) <editor>(recomended)");
			System.exit(0);
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
