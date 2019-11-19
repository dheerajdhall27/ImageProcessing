package controller.command.transformation;

import controller.command.ICommand;
import model.IImageModel;


/**
 * This class is used to apply the sepia transformation to an Image.
 */
public class SepiaCommand implements ICommand {

  private IImageModel imageModel;

  private float[][] matrix;

  public SepiaCommand(IImageModel imageModel) {
    this.imageModel = imageModel;
    matrix = new float[][]{
        {0.393f, 0.769f, 0.189f},
        {0.349f, 0.686f, 0.168f},
        {0.272f, 0.534f, 0.131f}
    };
  }

  @Override
  public void execute() {
    imageModel.transform(matrix);
  }
}
