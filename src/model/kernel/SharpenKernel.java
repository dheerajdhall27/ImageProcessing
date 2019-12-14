package model.kernel;

/**
 * This class represents a Blur Kernel which is used to apply the blur filter to an image.
 */
public class SharpenKernel implements IKernel {

  private final float[][] kernel;

  /**
   * This constructor creates an object of a Sharpen Kernel which sharpens an image by applying
   * the sharpen filter.
   */
  public SharpenKernel() {
    kernel = new float[][]{
        {-1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8},
        {-1.0f / 8,  1.0f / 4,  1.0f / 4,  1.0f / 4, -1.0f / 8},
        {-1.0f / 8,  1.0f / 4,  1.0f    ,  1.0f / 4, -1.0f / 8},
        {-1.0f / 8,  1.0f / 4,  1.0f / 84,  1.0f / 4, -1.0f / 8},
        {-1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8}
    };
  }

  @Override
  public float[][] getKernelData() {
    return this.kernel;
  }
}
