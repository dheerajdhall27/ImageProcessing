package model.matrix;

/**
 * This class represents a factory to create a specific type of Transformation.
 */
public class TransformationFactory implements ITransformationFactory {

  @Override
  public ITransformations createTransformation(TransformationType transformationType) {
    ITransformations transformation;
    switch (transformationType) {
      case GREY_SCALE:
        transformation = new GreyScaleTransformation();
        break;
      case SEPIA:
        transformation = new SepiaTransformation();
        break;
      default:
        throw new IllegalArgumentException();
    }

    return transformation;
  }
}
