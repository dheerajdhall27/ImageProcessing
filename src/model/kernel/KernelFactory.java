package model.kernel;

/**
 * This class represents a factory that is used to create a Kernel type.
 */
public class KernelFactory implements IKernelFactory {

  @Override
  public IKernel createKernel(KernelType kernelType) {
    IKernel kernel;
    switch (kernelType) {
      case BLUR:
        kernel = new BlurKernel();
        break;
      case SHARPEN:
        kernel = new SharpenKernel();
        break;
      default:
        throw new IllegalArgumentException();
    }

    return kernel;
  }
}
