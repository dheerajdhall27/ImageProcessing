package controller.command.transformation;

import controller.command.ICommand;
import model.IImageModel;
import model.matrix.ETransformationType;

/**
 * This class is used to create a GreyScale of an image by applying the changes.
 */
public class GreyScaleCommand implements ICommand {

  private IImageModel imageModel;

  public GreyScaleCommand(IImageModel imageModel) {
    this.imageModel = imageModel;
  }

  @Override
  public void execute() {
    imageModel.transform(ETransformationType.GREY_SCALE);
  }
}
