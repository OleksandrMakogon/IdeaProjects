package com.epam.training.exercise1;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Class to store images.
 *
 */
public final class Image {
    private static final int LAST_BYTE = 0xFF;
    private static final int BYTE = 8;
    private static final int TWO_BYTES = 16;
    private BufferedImage image;

    private Image(String fileName) {
        this.image = loadImageFromFile(fileName);
    }
    /** createImage.
     * @param fileName name of file
     * @return new image object
     */
    public static Image createImage(String fileName) {
        return new Image(fileName);
    }
    public int getHeight() {
        return image.getHeight();
    }
    public int getWidth() {
        return image.getWidth();
    }
//public int getIntensity(Coordinate coordinate) {
//    return getRed(coordinate) + getBlue(coordinate) + getGreen(coordinate);
//}
    /** Get Red method.
     * @param coordinate Coordinate
     * @return int
     */
    public int getRed(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return (rgbValue >> TWO_BYTES) & LAST_BYTE;
    }

    /** get Green method.
     * @param coordinate coordinate obj
     * @return int rgb
     */
    public int getGreen(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return (rgbValue >> BYTE) & LAST_BYTE;
    }

    /** get Blue method.
     * @param coordinate coordinate obj
     * @return int rgb code
     */
    public int getBlue(Coordinate coordinate) {
        int rgbValue = getRgbValue(coordinate);
        return rgbValue & LAST_BYTE;
    }

    private int getRgbValue(Coordinate coordinate) {
        if (coordinate.getX() < 0 || coordinate.getX() > image.getWidth()) {
            throw new RuntimeException("Coordinate x out of range: 0.." + image.getWidth());
        } else if (coordinate.getY() < 0 || coordinate.getY() > image.getHeight()) {
            throw new RuntimeException("Coordinate y out of range: 0.." + image.getHeight());
        }
        return image.getRGB(coordinate.getX(), coordinate.getY());
    }

    private BufferedImage loadImageFromFile(String fileName) {
        try {
            return ImageIO.read(getClass().getClassLoader().getResource(fileName));
        } catch (IOException exception) {
            throw new RuntimeException("File not found!", exception);
        }
    }

}
