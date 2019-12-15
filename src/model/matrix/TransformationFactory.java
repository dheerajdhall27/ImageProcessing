package model.matrix;

/**
 * This class represents a factory to create a specific type of Transformation.
 */
public class TransformationFactory implements ITransformationFactory {

  @Override
  public ITransformations createTransformation(ETransformationType ETransformationType) {
    ITransformations transformation;
    switch (ETransformationType) {
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
