package model.flags.rainbow;

import java.awt.image.BufferedImage;

/**
 * This class represents an implementation of the Vertical rainbow.
 */
public class VerticalRainbow extends AbstractRainbow {

  private BufferedImage bufferedImage;

  public VerticalRainbow() {
    super();
  }

  @Override
  public BufferedImage generateImage(int width, int height) {
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    int dimension = width / rainbowSize;

    return super.getImageData(width, height, dimension, bufferedImage, false);
  }
}
