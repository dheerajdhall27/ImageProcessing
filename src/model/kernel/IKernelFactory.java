package model.kernel;

/**
 * This interface represents a Kernel factory which is used to create a specific type of Kernel.
 */
public interface IKernelFactory {

  /**
   * This method is used to create a Kernel based on the Type of kernel parameter.
   *
   * @param kernelType the type of Kernel that needs to be created
   * @return Returns the type of kernel that was created.
   * @throws IllegalArgumentException if the kernelType provided is invalid
   */
  IKernel createKernel(KernelType kernelType) throws IllegalArgumentException;
}
