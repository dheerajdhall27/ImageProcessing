package model.flags;


import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class represents an implementation of the {@link IImageGeneration} interface. It provides the
 * functionality to generate an image of the France flag.
 */
public class GreeceImageGeneration implements IImageGeneration {

  private BufferedImage bufferedImage;

  private Color whiteStripe;
  private Color blueStripe;
  private int numberOfStripes;

  /**
   * This constructor is used to create a GreeceFlag object that initializes the colors of the
   * flag.
   */
  public GreeceImageGeneration() {
    whiteStripe = new Color(255, 255, 255);
    blueStripe = new Color(13, 94, 175);
    numberOfStripes = 9;
  }

  @Override
  public BufferedImage generateImage(int width, int height) {
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    int stripeDimension = height / numberOfStripes;

    for (int row = 0; row < bufferedImage.getHeight(); row++) {
      for (int col = 0; col < bufferedImage.getWidth(); col++) {
        handleCases(col, row, stripeDimension);
      }
    }
    return bufferedImage;
  }

  private void handleCases(int col, int row, int stripeDimension) {
    if (row <= stripeDimension || (row > (4 * stripeDimension) && row <= (5
        * stripeDimension))) {
      handleTopAndSimilar(col, row, stripeDimension);
    } else if ((row > stripeDimension && row <= (2 * stripeDimension)) || (
        row > (3 * stripeDimension) && row <= (4 * stripeDimension))) {
      handleSecondAndSimilar(col, row, stripeDimension);
    } else if (row > (2 * stripeDimension) && row <= (3 * stripeDimension)) {
      handleThird(col, row, stripeDimension);
    } else {
      handleOthers(col, row, stripeDimension);
    }
  }

  private void handleTopAndSimilar(int col, int row, int stripeDimension) {
    if (col > (2 * stripeDimension) && col <= (3 * stripeDimension)) {
      bufferedImage.setRGB(col, row, whiteStripe.getRGB());
    } else {
      bufferedImage.setRGB(col, row, blueStripe.getRGB());
    }
  }

  private void handleSecondAndSimilar(int col, int row, int stripeDimension) {
    if (col <= (2 * stripeDimension) || (col > (3 * stripeDimension) && col <= (5
        * stripeDimension + 1))) {
      bufferedImage.setRGB(col, row, blueStripe.getRGB());
    } else {
      bufferedImage.setRGB(col, row, whiteStripe.getRGB());
    }
  }

  private void handleThird(int col, int row, int stripeDimension) {
    if (col <= (5 * stripeDimension + 1)) {
      bufferedImage.setRGB(col, row, whiteStripe.getRGB());
    } else {
      bufferedImage.setRGB(col, row, blueStripe.getRGB());
    }
  }

  private void handleOthers(int col, int row, int stripeDimension) {
    if (row > (5 * stripeDimension) && row <= (6 * stripeDimension)) {
      bufferedImage.setRGB(col, row, whiteStripe.getRGB());
    } else if (row > (6 * stripeDimension) && row <= (7 * stripeDimension)) {
      bufferedImage.setRGB(col, row, blueStripe.getRGB());
    } else if (row > (7 * stripeDimension) && row <= (8 * stripeDimension)) {
      bufferedImage.setRGB(col, row, whiteStripe.getRGB());
    } else if (row > (8 * stripeDimension) && row <= (9 * stripeDimension)) {
      bufferedImage.setRGB(col, row, blueStripe.getRGB());
    }
  }
}
