package model.flags;

import java.awt.image.BufferedImage;

/**
 * This interface represents a flag and provides the functionality to generate the flag. Various
 * classes can implement this interface and provide their own functionality of generating the
 * respective flag.
 */
public interface IImageGeneration {

  /**
   * This method is used to generate a Flag image.
   *
   * @param width  the horizontal size of the image.
   * @param height the vertical size of the image.
   * @return a Buffered Image which consists of the flag {@link model.IImage} data
   */
  BufferedImage generateImage(int width, int height);
}
