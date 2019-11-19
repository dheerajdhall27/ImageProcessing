package controller.command;

import model.IImageModel;

public class BlurCommand implements ICommand {

  private IImageModel model;

  private float[][] kernel;

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

    kernel = new float[][]{
        {1f / 16, 1f / 8, 1f / 16},
        {1f / 8, 1f / 4, 1f / 8},
        {1f / 16, 1f / 8, 1f / 16},
    };
    
    this.model = model;
  }

  @Override
  public void execute() {
    model.filter(kernel);
  }
}
