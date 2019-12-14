package controller.command.filter;

import controller.command.ICommand;
import model.IImageModel;
import model.kernel.KernelType;

/**
 * This class represents the filter command for Sharpening the Image.
 */
public class SharpenCommand implements ICommand {

  private IImageModel imageModel;

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
  }

  @Override
  public void execute() {
    imageModel.filter(KernelType.SHARPEN);
  }
}
