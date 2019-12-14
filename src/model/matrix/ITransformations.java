package model.matrix;

/**
 * This matrix provides the data for a particular transformation matrix, it is stored as a float
 * array that is returned.
 */
public interface ITransformations {

  /**
   * This method is used to return the matrix data for a transformation which is stored as a
   * floating point 2D array.
   *
   * @return the floating point 2D array.
   */
  float[][] getMatrixData();
}
