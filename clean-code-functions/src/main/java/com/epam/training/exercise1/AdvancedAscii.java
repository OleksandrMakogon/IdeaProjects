package com.epam.training.exercise1;

/** Print image using ascii.
 *
 */
public final class AdvancedAscii {

    static final int MAX = 0;
    static final int MIN = 255*3;
    static final int WIDTH = 200;
    static final int HEIGHT = 60;
    private static Image image;
    private static int stepY;
    private static int stepX;
    private static int min;
    private static int max;

    private AdvancedAscii(){ }
    /** main entry.
     * @param args args
     */
    public static void main(final String[] args) {
        image = Image.createImage("pair_hiking.png");
        char[] charsByDarkness = { '#', '@', 'X', 'L', 'I', ':', '.', ' ' };
        max = MAX;
        min = MIN;
        stepY = image.getHeight() / HEIGHT;
        stepX = image.getWidth() /WIDTH;
        calculateMinMax();
        printResult(charsByDarkness);
    }

    /** Print funal result to console.
     * @param charsByDarkness char array
     */
    public static void printResult(char[] charsByDarkness) {
        int sum;
        for (int y = 0; y < image.getHeight() - stepY; y += stepY) {
            for (int x = 0; x < image.getWidth() - stepX; x += stepX) {
                sum = getSum(x, y);
                System.out.print(charsByDarkness[(sum - min) * charsByDarkness.length / (max - min + 1)]);
            }
            System.out.println();
        }
    }

    /** calculate min and max.
     *
     */
    public static void calculateMinMax(){
        int sum;
        for (int y = 0; y < image.getHeight(); y += stepY) {
            for (int x = 0; x < image.getWidth(); x += stepX) {
                sum = getSum(x,y);
                if (max < sum) {
                    max = sum;
                }
                if (min > sum) {
                    min = sum;
                }
            }
        }

    }

    /** calculate sum.
     * @param coordinateX coordinate
     * @param coordinateY coordinate
     * @return int sum
     */
    public static int getSum(int coordinateX, int coordinateY){
        int sum = 0;
        for (int avgy = 0; avgy < stepY; avgy++) {
            for (int avgx = 0; avgx < stepX; avgx++) {
                sum = sum + (image.getRed(new Coordinate(coordinateX, coordinateY)) + image.getBlue(new Coordinate(coordinateX, coordinateY)) + image.getGreen(new Coordinate(coordinateX, coordinateY)));
            }
        }
        return sum / stepY / stepX;

    }

}
