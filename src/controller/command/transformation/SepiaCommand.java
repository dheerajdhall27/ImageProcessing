package controller.command.transformation;

import controller.command.ICommand;
import model.IImageModel;
import model.matrix.ETransformationType;


/**
 * This class is used to apply the sepia transformation to an Image.
 */
public class SepiaCommand implements ICommand {

  private IImageModel imageModel;

  public SepiaCommand(IImageModel imageModel) {
    this.imageModel = imageModel;
  }

  @Override
  public void execute() {
    imageModel.transform(ETransformationType.SEPIA);
  }
}
