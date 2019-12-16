package model;

import java.awt.image.BufferedImage;
import model.flags.EFlags;
import model.kernel.EKernelType;
import model.matrix.ETransformationType;

/**
 * This interface represents an interface for an Image, which provides methods like filter and
 * transformation that can be applied to an image.
 */
public interface IImageModel {

  /**
   * This method is used to apply a particular filter to the image. It takes in a Kernel that can be
   * used to apply filter like blur. sharpen
   *
   * @param EKernelType represents the kernel that is used the filter to the Image (an enum).
   * @throws IllegalArgumentException if the provided Kernel is null.
   */
  void filter(EKernelType EKernelType) throws IllegalArgumentException;

  /**
   * This method is used to transform this Image by using the matrix provided.
   *
   * @param ETransformationType the transformation type used to apply the transformation
   * @throws IllegalArgumentException if the matrix provided is null.
   */
  void transform(ETransformationType ETransformationType) throws IllegalArgumentException;

  /**
   * This method is used to return the ReadOnly data for the Image so that the image cannot be
   * modified.
   *
   * @return the ReadOnly data for the Image.
   */
  BufferedImage getImageData();


  /**
   * This method is used to generate Flags.
   *
   * @param width    the width of the flag
   * @param height   the height of the flag
   * @param flagType the type of flag
   * @return the image data as a buffered image.
   */
  BufferedImage generateFlag(int width, int height, EFlags flagType);

  /**
   * This method is used to generate an image with the dimensions specified by the user
   *
   * @param width  the width of the image that has to be generated
   * @param height the height of the image that has to be generated
   * @return a BufferedImage object with image data
   */
  BufferedImage generateImage(int width, int height);
}
