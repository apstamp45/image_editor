package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;

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
         * Stores the threshold.
         */
        private int threshold;

        @Override
        public Pixel filter(Pixel pixel) {
            if ((pixel.r + pixel.g + pixel.b) / 3 > threshold) {
                return new Pixel(255, 255, 255);
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