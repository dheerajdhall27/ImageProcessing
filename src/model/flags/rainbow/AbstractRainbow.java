package model.flags.rainbow;

import java.awt.Color;
import java.awt.image.BufferedImage;
import model.flags.IImageGeneration;

public class AbstractRainbow implements IImageGeneration {

  protected Color[] colorsArray;
  protected int rainbowSize;


  /**
   * This constructor is mainly used to initialize the variables, since this is an abstract class an
   * object of this class cannot be created.
   */
  protected AbstractRainbow() {
    colorsArray = new Color[]{
        new Color(255, 0, 0),            // RED
        new Color(255, 165, 0),          // ORANGE
        new Color(255, 255, 0),          // YELLOW
        new Color(0, 128, 0),            // GREEN
        new Color(0, 0, 255),            // BLUE
        new Color(75, 0, 130),           // INDIGO
        new Color(238, 130, 238)         // VIOLET
    };

    rainbowSize = 7;
  }

  @Override
  public BufferedImage generateImage(int width, int height) {
    return null;
  }


  /**
   * A helper method to generate the rainbow image
   *
   * @param width
   * @param height
   * @param dimension
   * @param bufferedImage
   * @return
   */
  protected BufferedImage getImageData(int width, int height, int dimension,
      BufferedImage bufferedImage, Boolean horizontal) {
    int value;
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {

        if(horizontal) {
          value = row / dimension;
        } else {
          value = col / dimension;
        }
        bufferedImage.setRGB(col, row, colorsArray[value].getRGB());
      }
    }

    return bufferedImage;
  }
}
