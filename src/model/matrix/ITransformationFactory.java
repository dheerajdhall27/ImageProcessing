package model.matrix;

/**
 * This interface represents a factory to create a particular type of transformation
 */
public interface ITransformationFactory {

  /**
   * This method is used to create a specifice type of Transformation according to the provided enum
   * data
   *
   * @param transformationType The Transformation that needs to be created
   * @return the created Transformation
   */
  ITransformations createTransformation(TransformationType transformationType);
}
