package controller.command.flag;

import controller.command.ICommand;
import model.IImageModel;
import model.flags.EFlags;

/**
 * This class represents a command to generate Flags of various countries.
 */
public class FlagCommand implements ICommand {

  private IImageModel imageModel;

  private EFlags flagType;
  private int width;
  private int height;

  public FlagCommand(EFlags flagType, IImageModel imageModel) {
    this.flagType = flagType;
    this.imageModel = imageModel;
  }

  @Override
  public void execute() {
    imageModel.generateFlag(width, height, flagType);
  }
}
