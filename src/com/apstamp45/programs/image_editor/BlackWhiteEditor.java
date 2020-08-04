package com.apstamp45.programs.image_editor;

import java.awt.image.BufferedImage;
import java.math.BigInteger;

/**
 * This Editor makes white areas
 * of an image pure white.
 */
public class BlackWhiteEditor implements Editor {

    @Override
    public String getName() {
        return "BLACKWHITE";
    }

    @Override
    public BufferedImage editImage(BufferedImage image, String[] args) {
        BufferedImage editedImage = image;
        int threshold = 0;
        int numberOfPixels = 0;
        long  rgbTotal = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                numberOfPixels++;
                Pixel pixel = Editor.rgbToPixel(image.getRGB(x, y));
                rgbTotal += pixel.r + pixel.g + pixel.b;
            }
        }
        BigInteger total = BigInteger.valueOf(rgbTotal);
        BlackWhiteEditor.WhiteFilter filter = new BlackWhiteEditor.WhiteFilter();
        threshold = total.divide(BigInteger.valueOf((long) (numberOfPixels * 3))).intValue();
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
        
        /**
         * Sets the threshold of this instance.
         */
        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public Pixel filter(Pixel pixel) {
            if ((pixel.r + pixel.g + pixel.b) / 3 > threshold) {
                return new Pixel(255, 255, 255);
            }
            return new Pixel(0, 0, 0);
        }
    }
}