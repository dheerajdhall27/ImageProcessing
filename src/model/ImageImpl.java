package model;

/**
 * This class represents an Image, it stores the pixel information of the image and provides methods
 * to read information considering the Image.
 */
public class ImageImpl implements IImage {

  private float[][][] imageInformation;

  public ImageImpl(float[][][] imageInformation) {
    this.imageInformation = imageInformation;
  }

  @Override
  public float[][][] getPixelInformation() {
    return this.imageInformation;
  }

  @Override
  public void setPixelInformation(float[][][] imageInformation) {
    this.imageInformation = imageInformation;
  }
}
