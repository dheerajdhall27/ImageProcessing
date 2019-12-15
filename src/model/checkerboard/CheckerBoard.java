package model.checkerboard;

import java.awt.Color;
import java.awt.image.BufferedImage;
import model.flags.IImageGeneration;

/**
 * This class represents an Image for the checkerboard.
 */
public class CheckerBoard implements IImageGeneration {

  private BufferedImage bufferedImage;

  private Color white;
  private int size;

  public CheckerBoard() {
    white = new Color(255, 255, 255);
  }

  @Override
  public BufferedImage generateImage(int width, int height) throws IllegalArgumentException {
    if (width != height) {
      throw new IllegalArgumentException("The width and height need to be similar");
    }
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    size = width / 8;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        int value = row / size;

        if (value % 2 == 0) {
          handleEvenRows(col, row);
        } else {
          handleOddRows(col, row);
        }
      }
    }

    return bufferedImage;
  }

  private void handleEvenRows(int col, int row) {
    int valueX = col / size;
    int valueY = row / size;

    if (valueX % 2 == 0 && valueY % 2 == 0) {
      bufferedImage.setRGB(col, row, white.getRGB());
    }
  }

  private void handleOddRows(int col, int row) {
    int valueX = col / size;
    int valueY = row / size;

    if (valueX % 2 != 0 && valueY % 2 != 0) {
      bufferedImage.setRGB(col, row, white.getRGB());
    }
  }
}
