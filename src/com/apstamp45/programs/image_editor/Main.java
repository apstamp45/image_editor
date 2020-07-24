package com.apstamp45.programs.image_editor;

import java.util.ArrayList;

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
	 * 
	 */
	private static final int NUMBER_OF_EDITORS = 1;// CHANGE THIS WHEN ADDING AN EDITOR!

	/**
	 * This stores the editor name that
	 * was inputted by the user.
	 */
	private static String selectedEditorName;

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
	
	public static void main(String[] args) {
		initializeEditors();
		processParamiters(args);
		System.out.println(selectedEditorName);
		System.out.println(inputImagePath);
		System.out.println(outputImagePath);
	}

	/**
	 * Processes the command line options (duh).
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
				selectedEditorName = DEFAULT_EDITOR.getName();
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
					selectedEditorName = DEFAULT_EDITOR.getName();
				} else if (isIncompletePath) {
					System.out.println("A full path is required for the image file.");
					System.exit(0);
				} else {
					selectedEditorName = arg2;
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
				selectedEditorName = arg3;
			}
		} else {
			System.out.println("usage: java Main <inputImage> <outputImage>(optional) <editor>(recomended)");
			System.exit(0);
		}
	}

	/**
	 * This initializes the Editors to be used (duh).
	 * an Editor must be declated in this function
	 * to work.
	 */
	private static void initializeEditors() {
		editors = new Editor[NUMBER_OF_EDITORS];
		editorNames = new String[NUMBER_OF_EDITORS];

		editors[0] = new DefaultEditor();// ADD ALL EDITOR DECLORATIONS HERE!

		int i = 0;
		for (Editor e : editors) {
			editorNames[i] = e.getName();
			i++;
		}
		for (String name: editorNames) {
			if (selectedEditorName.equalsIgnoreCase(name)) {
				selectedEditor = editors[i];
			}
		}
		if (selectedEditor == null) {
			selectedEditor = DEFAULT_EDITOR;
		}
	}
}
