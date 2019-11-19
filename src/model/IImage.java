package model;

/**
 * This interface represents the an Image which holds the information about the Image and provides
 * methods to access the Image data.
 */
public interface IImage {

  /**
   * This method is used to get the pixel information associated with the image.
   *
   * @return a 2D array which provides the pixel information
   */
  float[][][] getPixelInformation();

  /**
   * This method is used to set the pixelInformation of this particular image.
   *
   * @param imageInformation the updated pixel information for this image
   */
  void setPixelInformation(float[][][] imageInformation);
}
