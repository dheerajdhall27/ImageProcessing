package controller.command.transformation;

import controller.command.ICommand;
import model.IImageModel;

/**
 * This class is used to create a GreyScale of an image by applying the changes.
 */
public class GreyScaleCommand implements ICommand {

  private IImageModel imageModel;

  private float[][] matrix;

  public GreyScaleCommand(IImageModel imageModel) {
    this.imageModel = imageModel;
    matrix = new float[][]{
        {0.2126f, 0.7512f, 0.0722f},
        {0.2126f, 0.7512f, 0.0722f},
        {0.2126f, 0.7512f, 0.0722f}
    };
  }

  @Override
  public void execute() {
    imageModel.transform(matrix);
  }
}
