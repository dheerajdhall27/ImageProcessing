package controller.command.filter;

import controller.command.ICommand;
import model.IImageModel;
import model.kernel.KernelType;

public class BlurCommand implements ICommand {

  private IImageModel model;

  /**
   * This Constructor is used to create a Blur Command Object, which is used to blur a specific
   * image.
   *
   * @param model This represents the ImageModel
   * @throws IllegalArgumentException if the model passed is null
   */
  public BlurCommand(IImageModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException(
          "The model passed is null! Please pass an appropriate model");
    }

    this.model = model;
  }

  @Override
  public void execute() {
    model.filter(KernelType.BLUR);
  }
}
