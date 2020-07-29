package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

/**
 * This Editor makes white areas
 * of an image pure white.
 */
public class WhiteEditor implements Editor {

    @Override
    public String getName() {
        return "WHITE";
    }

    @Override
    public BufferedImage editImage(BufferedImage image, String[] args) {
        int threshold = 0;
        BufferedImage editedImage = image;
        if (args.length > 0) {
            threshold = Integer.valueOf(args[0]);
        } else {
            System.out.println("A threshold variable is needed for\nthis Editor to work.");
            System.exit(0);
        }
        WhiteEditor.WhiteFilter filter = new WhiteEditor.WhiteFilter();
        filter.setThreshold(threshold);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel pixel = filter.filter(Editor.rgbToPixel(image.getRGB(x, y)));
                editedImage.setRGB(x, y, Editor.pixelToRgb(pixel));
            }
        }
        return editedImage;
    }

    /**
     * This filter returns a white pixel if the
     * average brightness is greater than the
     * threshold.
     */
    static class WhiteFilter implements Filter {

        /**
         * This constant holds the constant
         * that determines wether or not a
         * pixel is white.
         */
        private static final int WHITE_THRESHOLD = 20;
        /**
         * Stores the threshold.
         */
        private int threshold;

        @Override
        public Pixel filter(Pixel pixel) {
            if ((pixel.r + pixel.g + pixel.b) / 3 > threshold) {
                if (
                    !(pixel.r + WHITE_THRESHOLD < pixel.g || pixel.r > pixel.g + WHITE_THRESHOLD) &&
                    !(pixel.r + WHITE_THRESHOLD < pixel.b || pixel.r > pixel.b + WHITE_THRESHOLD) &&
                    !(pixel.g + WHITE_THRESHOLD < pixel.b || pixel.g > pixel.b + WHITE_THRESHOLD)
                    ) {
                    return new Pixel(255, 255, 255);
                }
            }
            return pixel;
        }

        /**
         * Sets the threshold.
         */
        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }
    }
}