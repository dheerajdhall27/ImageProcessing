package model.flags;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class AbstractRainbow implements IImageGeneration {

  protected Color[] colorsArray;
  protected int rainbowSize;


  protected AbstractRainbow() {
    colorsArray = new Color[]{
        new Color(255, 0, 0),
        new Color(255, 165, 0),
        new Color(255, 255, 0),
        new Color(0, 128, 0),
        new Color(0, 0, 255),
        new Color(75, 0, 130),
        new Color(238, 130, 238)
    };
    
    rainbowSize = 7;
  }

  @Override
  public BufferedImage generateImage(int width, int height) {
    return null;
  }

  protected BufferedImage getImageData(int width, int height, int dimension,
      BufferedImage bufferedImage) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        int value = col / dimension;
        bufferedImage.setRGB(col, row, colorsArray[value].getRGB());
      }
    }

    return bufferedImage;
  }
}
