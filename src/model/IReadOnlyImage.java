package model;

import java.awt.image.BufferedImage;

/**
 * This interface represents a ReadOnly interface for the
 */
public interface IReadOnlyImage {

  /**
   * This method returns the BufferedImage data of the Image which can be used to save the Image if
   * required.
   *
   * @return the BufferedImage data of the Image.
   */
  BufferedImage getBufferedImageData();
}
