package model;

import java.awt.image.BufferedImage;

/**
 * This interface represents an interface for an Image, which provides methods like filter and
 * transformation that can be applied to an image.
 */
public interface IImageModel {

  /**
   * This method is used to apply a particular filter to the image. It takes in a Kernel that can be
   * used to apply filter like blur. sharpen
   *
   * @param kernel represents the kernel that is used the filter to the Image.
   * @throws IllegalArgumentException if the provided Kernel is null.
   */
  void filter(float[][] kernel) throws IllegalArgumentException;

  /**
   * This method is used to transform this Image by using the matrix provided.
   *
   * @param matrix the matrix used to apply the transformation
   * @throws IllegalArgumentException if the matrix provided is null.
   */
  void transform(float[][] matrix) throws IllegalArgumentException;

  /**
   * This method is used to return the ReadOnly data for the Image so that the image cannot be
   * modified.
   *
   * @return the ReadOnly data for the Image.
   */
  BufferedImage getImageData();
}
