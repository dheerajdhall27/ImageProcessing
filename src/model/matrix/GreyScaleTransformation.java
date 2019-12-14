package model.matrix;


/**
 * This method represents a transformation that stores the matrix for the Greyscale transformation.
 */
public class GreyScaleTransformation implements ITransformations {

  private final float[][] matrix;

  /**
   * This method is used to create an object of a GreyScaleTransformation matrix
   */
  public GreyScaleTransformation() {
    matrix = new float[][]{
        {0.2126f, 0.7512f, 0.0722f},
        {0.2126f, 0.7512f, 0.0722f},
        {0.2126f, 0.7512f, 0.0722f}
    };
  }

  @Override
  public float[][] getMatrixData() {
    return this.matrix;
  }
}
