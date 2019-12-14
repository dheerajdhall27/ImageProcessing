package model.matrix;


/**
 * This method represents a transformation that stores the matrix for the Greyscale transformation.
 */
public class SepiaTransformation implements ITransformations {

  private final float[][] matrix;

  /**
   * This method is used to create an object of a SepiaTransformation matrix
   */
  public SepiaTransformation() {
    matrix = new float[][]{
        {0.393f, 0.769f, 0.189f},
        {0.349f, 0.686f, 0.168f},
        {0.272f, 0.534f, 0.131f}
    };
  }

  @Override
  public float[][] getMatrixData() {
    return this.matrix;
  }
}
