package model.kernel;

/**
 * This class represents a Blur Kernel which is used to apply the blur filter to an image.
 */
public class BlurKernel implements IKernel {

  private final float[][] kernel;

  /**
   * This constructor creates an object of a Blur Kernel which blurs an image by applying the blur
   * filter.
   */
  public BlurKernel() {
    kernel = new float[][]{
        {1f / 16, 1f / 8, 1f / 16},
        {1f / 8, 1f / 4, 1f / 8},
        {1f / 16, 1f / 8, 1f / 16},
    };
  }

  @Override
  public float[][] getKernelData() {
    return this.kernel;
  }
}
