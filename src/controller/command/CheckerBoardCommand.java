package controller.command;

import java.awt.image.BufferedImage;
import model.IImageModel;

/**
 * This method is used to create a command class to generate checker board.
 */
public class CheckerBoardCommand implements ICommand {

  private IImageModel imageModel;
  private int dimension;

  public CheckerBoardCommand(IImageModel imageModel, int dimension) {
    this.imageModel = imageModel;
    this.dimension = dimension;
  }

  @Override
  public void execute() {
    BufferedImage bufferedImage = imageModel.generateImage(dimension, dimension);
  }
}
