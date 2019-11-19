package model;

import java.awt.image.BufferedImage;

/**
 * This class represents a Readonly Implementation of the Image that provides the BufferedImage
 * data.
 */
public class ReadonlyImageImpl implements IReadOnlyImage {

  private BufferedImage bufferedImage;

  public ReadonlyImageImpl(BufferedImage bufferedImages) {
    this.bufferedImage = bufferedImages;
  }

  @Override
  public BufferedImage getBufferedImageData() {
    return this.bufferedImage;
  }
}
