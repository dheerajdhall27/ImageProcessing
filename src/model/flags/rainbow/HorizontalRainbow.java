package model.flags.rainbow;

import java.awt.image.BufferedImage;

/**
 * This class represents a Horizontal striped rainbow's implementation.
 */
public class HorizontalRainbow extends AbstractRainbow {

  private BufferedImage bufferedImage;


  public HorizontalRainbow() {
    super();
  }

  @Override
  public BufferedImage generateImage(int width, int height) {
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    int dimension = height / rainbowSize;

    return super.getImageData(width, height, dimension, bufferedImage, true);
  }
}
