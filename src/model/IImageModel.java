package model;

import java.awt.image.BufferedImage;
import model.kernel.KernelType;
import model.matrix.TransformationType;

/**
 * This interface represents an interface for an Image, which provides methods like filter and
 * transformation that can be applied to an image.
 */
public interface IImageModel {

  /**
   * This method is used to apply a particular filter to the image. It takes in a Kernel that can be
   * used to apply filter like blur. sharpen
   *
   * @param kernelType represents the kernel that is used the filter to the Image (an enum).
   * @throws IllegalArgumentException if the provided Kernel is null.
   */
  void filter(KernelType kernelType) throws IllegalArgumentException;

  /**
   * This method is used to transform this Image by using the matrix provided.
   *
   * @param transformationType the transformation type used to apply the transformation
   * @throws IllegalArgumentException if the matrix provided is null.
   */
  void transform(TransformationType transformationType) throws IllegalArgumentException;

  /**
   * This method is used to return the ReadOnly data for the Image so that the image cannot be
   * modified.
   *
   * @return the ReadOnly data for the Image.
   */
  BufferedImage getImageData();


  BufferedImage generateImage();
}
