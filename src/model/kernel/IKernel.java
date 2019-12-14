package model.kernel;

/**
 * This Interface represents a Blur kernel which gets the kernel information represented in a 2D
 * matrix. The blur kernel can be applied to an image to blur it.
 */
public interface IKernel {

  /**
   * This method provides the kernel data which is stored in a 2D matrix.
   *
   * @return the kernel data as a floating point  2D array
   */
  float[][] getKernelData();
}
