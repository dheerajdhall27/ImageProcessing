package model.flags;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class represents an implementation of the {@link IImageGeneration} interface. It provides
 * the functionality to generate an image of the France flag.
 */
public class FranceImageGeneration implements IImageGeneration {

  private BufferedImage bufferedImage;

  private Color blueStripe;
  private Color redStripe;
  private Color whiteStripe;

  /**
   * This constructor is used to create a FranceFlag object that initializes the colors of the
   * flag.
   */
  public FranceImageGeneration() {
    blueStripe = new Color(0, 0, 255);
    whiteStripe = new Color(255, 255, 255);
    redStripe = new Color(255, 0, 0);
  }

  @Override
  public BufferedImage generateImage(int width, int height) {
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    int imageWidth = bufferedImage.getWidth();
    int division = imageWidth / 3;

    for (int row = 0; row < bufferedImage.getHeight(); row++) {
      for (int col = 0; col < bufferedImage.getWidth(); col++) {
        if (col < division) {
          bufferedImage.setRGB(col, row, blueStripe.getRGB());
        } else if (col >= division && col < (2 * division)) {
          bufferedImage.setRGB(col, row, whiteStripe.getRGB());
        } else if(col >= (2 * division)){
          bufferedImage.setRGB(col, row, redStripe.getRGB());
        }
      }
    }
    return bufferedImage;
  }
}
