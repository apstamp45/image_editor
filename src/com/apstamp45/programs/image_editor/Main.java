package com.apstamp45.programs.image_editor;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Arrays;

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
	 * This constant is the default name
	 * of the output file.
	 */
	private static final String DEFAULT_OUTPUT_FILE_NAME = "output.png";

	/**
	 * This constant is to be changed when
	 * Editors are added.
	 */
	private static final int NUMBER_OF_EDITORS = 1;// CHANGE THIS WHEN ADDING AN EDITOR!

	/**
	 * This stores the editor name that
	 * was inputted by the user.
	 */
	private static String selectedEditorName;

	/**
	 * This array is used to store extra
	 * paramiters used for the editors.
	 */
	private static String[] extraParamiters;

	/**
	 * This stores the current Editor
	 * being used.
	 */
	private static Editor selectedEditor;

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
	 * This field will contain all of the
	 * Editors that can be used when it
	 * is inirialized.
	 */
	private static Editor[] editors;

	/**
	 * This array stores all of the Editor's
	 * names.
	 */
	private static String[] editorNames;

	private static BufferedImage image;
	
	public static void main(String[] args) {
		initializeEditors();
		processParamiters(args);
		getEditor();
		getImage();
		System.out.println(selectedEditor);
		System.out.println(inputImagePath);
		System.out.println(outputImagePath);
		for (String s: extraParamiters) {
			System.out.println(s);
		}
	}

	/**
	 * Processes the command line options (duh).
	 * 
	 * @param args an array containing all the arguments.
	 */
	private static void processParamiters(String[] args) {
		if (args.length > 1) {
			String arg1 = args[0];
			if (isPath(arg1) == 1) {
				inputImagePath = arg1;
				String arg2 = args[1];
				if (isPath(arg2) > -1) {
					if (args.length >= 3) {
						outputImagePath = arg2;
						selectedEditorName = args[2];
						extraParamiters = Arrays.copyOfRange(args, 3, args.length);
					} else {
						System.out.println("Editor name is required to work.");
						System.exit(0);
					}
				} else {
					selectedEditorName = arg2;
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
					extraParamiters = Arrays.copyOfRange(args, 2, args.length);
				}
			} else {
				System.out.println("The first paramiter needs to be a complete\rpath to the image.");
				System.exit(0);
			}
		} else {
			System.out.println("usage: java Main <inputImage> <outputImage>(optional) <editor>");
			System.exit(0);
		}
	}

	/**
	 * This initializes the Editors to be used (duh).
	 * An Editor must be declated in this function
	 * to work.
	 */
	private static void initializeEditors() {
		editors = new Editor[NUMBER_OF_EDITORS];
		editorNames = new String[NUMBER_OF_EDITORS];

		editors[0] = new TestEditor();// ADD ALL EDITOR DECLARATIONS HERE!

		int i = 0;
		for (Editor e : editors) {
			editorNames[i] = e.getName();
			i++;
		}
	}

	/**
	 * This function gets the editor
	 * that will be used durring this
	 * program run.
	 */
	private static void getEditor() {
		int i = 0;
		for (String name: editorNames) {
			if (selectedEditorName.equalsIgnoreCase(name)) {
				selectedEditor = editors[i];
			}
		}
		if (selectedEditor == null) {
			System.out.println("Your editor name input isn't valid.");
			System.exit(0);
		}
	}

	/**
	 * Gets the image from the
	 * specified path.
	 */
	private static void getImage() {
		int width = 600;
		int height = 388;
		File file;
		try {
			file = new File(inputImagePath);
			image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
			image = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("An error occured when reading the image \r(did you enter the right path?)");
			e.printStackTrace();
		}
	}

	/**
	 * Returns an int depending on
	 * the path status.
	 * @param path a String containing
	 * a path.
	 * @return 
	 * -1: the String isn't a path.
	 * 0: the String is an incomplete path.
	 * 1: the String is a complete path.
	 */
	private static int isPath(String path) {
		if (path.charAt(0) == '/') {
			return 1;
		}
		char[] $path = path.toCharArray();
		int i = 0;
		for (char c: $path) {
			if (c == '/' && i > 0) {
				return 0;
			}
			i++;
		}
		return -1;
	}
}
