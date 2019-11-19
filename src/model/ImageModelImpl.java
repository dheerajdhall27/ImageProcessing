package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class represents the implementation of the {@link IImageModel} interface, it represents an
 * Image that can be modified based on the requirement 1. Filter 2. Transformation
 */
public class ImageModelImpl implements IImageModel {

  private IImage image;

  /**
   * This Constructor is used to create an object of ImageModel, which can be used to apply filter
   * and transformations.
   *
   * @param image the image object that carries the pixel information
   * @throws IllegalArgumentException if the pixelInformation passed is null
   */
  public ImageModelImpl(IImage image) throws IllegalArgumentException {
    this.image = image;
  }

  @Override
  public void filter(float[][] kernel) throws IllegalArgumentException {
    float[][][] pixelInformation = image.getPixelInformation();
    float[][][] newPixelInformation = new float[pixelInformation.length][pixelInformation[0].length]
        [pixelInformation[0][0].length];

    updatePixelInformation(pixelInformation, newPixelInformation, kernel);
    image.setPixelInformation(pixelInformation);
  }

  @Override
  public IReadOnlyImage getImageData() {
    BufferedImage bufferedImage = createImage(image.getPixelInformation());

    return new ReadonlyImageImpl(bufferedImage);
  }

  /**
   * This method is used to update the pixelInformation using the Kernel provided.
   *
   * @param pixelInformation    the pixel information of the image provided as a 3-D array
   * @param newPixelInformation the 3-D array to store the updated pixel after applying filter
   * @param kernel              the Kernel being used to apply some kind of transformation
   */
  private void updatePixelInformation(float[][][] pixelInformation, float[][][] newPixelInformation,
      float[][] kernel) {
    for (int i = 0; i < pixelInformation.length; i++) {
      for (int j = 0; j < pixelInformation[i].length; j++) {
        for (int k = 0; k < pixelInformation[i][j].length; k++) {
          float[][][] neighbours = getNeighbours(pixelInformation, kernel.length, kernel[0].length,
              3, new int[]{i, j});
          float newValue = getNewValue(neighbours, kernel, k);
          newPixelInformation[i][j][k] = newValue;
        }
      }
    }

    for (int i = 0; i < pixelInformation.length; i++) {
      for (int j = 0; j < pixelInformation[i].length; j++) {
        for (int k = 0; k < pixelInformation[i][j].length; k++) {
          pixelInformation[i][j][k] = newPixelInformation[i][j][k];
        }
      }
    }
  }

  /**
   * This method is used to create the image using the pixel information.
   *
   * @param pixelInformation the image Information stored in a 3-D array which gives information
   *                         about the channels (R, G, B)
   * @return returns the BufferedImage data of the Image
   */
  private BufferedImage createImage(float[][][] pixelInformation) {
    BufferedImage bi = new BufferedImage(pixelInformation.length, pixelInformation[0].length,
        BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < pixelInformation.length; i++) {
      for (int j = 0; j < pixelInformation[i].length; j++) {
        float r = pixelInformation[i][j][0] / 255.0f;
        float g = pixelInformation[i][j][1] / 255.0f;
        float b = pixelInformation[i][j][2] / 255.0f;
        Color color = new Color(r, g, b);

        bi.setRGB(i, j, color.getRGB());
      }
    }

    return bi;
  }

  /**
   * This method is used to calculate the new value of a particular channel after applying the
   * filter.
   *
   * @param neighbors the neighbors for that particular pixel
   * @param kernel    the kernel being used to apply the change
   * @param channel   the channel that is supposed to be updated
   * @return the new value for the channel after making the required change
   */
  private float getNewValue(float[][][] neighbors, float[][] kernel, int channel) {
    float newValue = 0;

    for (int i = 0; i < neighbors.length; i++) {
      for (int j = 0; j < neighbors[i].length; j++) {
        newValue += neighbors[i][j][channel] * kernel[i][j];
      }
    }

    if (newValue > 255) {
      newValue = 255.0f;
    } else if (newValue < 0) {
      newValue = 0.0f;
    }

    return newValue;
  }

  /**
   * This method is used to get the neighbours of a particular cell. if the neighbor does not exist
   * that particular value is 0.
   *
   * @param pixelInformation represents a 2d array which holds the pixel information of the image.
   * @param kernelRowSize    The number of rows in the kernel
   * @param kernelColSize    The number of cols in the kernel
   * @return an 2D array of neighbors
   */
  private float[][][] getNeighbours(float[][][] pixelInformation, int kernelRowSize,
      int kernelColSize, int kernelChannelSize, int[] cell) {
    float[][][] arr = new float[kernelRowSize][kernelColSize][kernelChannelSize];
    int index = kernelRowSize / 2;

    for (int i = -index; i <= index; i++) {
      for (int j = -index; j <= index; j++) {
        for (int k = 0; k < kernelChannelSize; k++) {
          int row = cell[0] + i;
          int col = cell[1] + j;

          if ((row >= 0 && row < pixelInformation.length) && (col >= 0
              && col < pixelInformation[0].length)) {
            arr[i + index][j + index][k] = pixelInformation[row][col][k];
          }
        }
      }
    }
    return arr;
  }
}