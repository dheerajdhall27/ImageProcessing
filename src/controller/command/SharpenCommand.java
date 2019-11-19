package controller.command;

import model.IImageModel;

/**
 * This class represents the filter command for Sharpening the Image.
 */
public class SharpenCommand implements ICommand {

  private IImageModel imageModel;

  private float[][] kernel;

  /**
   * This constructor is used to create a SharpenCommand class that can be used to apply the Sharpen
   * filter.
   *
   * @param imageModel The image Model on which the Sharpen filter is applied.
   */
  public SharpenCommand(IImageModel imageModel) {
    if (imageModel == null) {
      throw new IllegalArgumentException("The model is NULL! It cannot be NULL");
    }
    this.imageModel = imageModel;
    kernel = new float[][]{
        {-1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8},
        {-1.0f / 8,  1.0f / 4,  1.0f / 4,  1.0f / 4, -1.0f / 8},
        {-1.0f / 8,  1.0f / 4,  1.0f    ,  1.0f / 4, -1.0f / 8},
        {-1.0f / 8,  1.0f / 4,  1.0f / 84,  1.0f / 4, -1.0f / 8},
        {-1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8, -1.0f / 8}
    };
  }

  @Override
  public void execute() {
    imageModel.filter(kernel);
  }
}
