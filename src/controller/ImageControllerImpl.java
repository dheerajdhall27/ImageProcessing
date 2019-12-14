package controller;

import model.IImageModel;

/**
 * This class is an implementation of the {@link IImageController}.
 */
public class ImageControllerImpl implements IImageController{

  private IImageModel imageModel;

  public ImageControllerImpl(IImageModel imageModel) {
    this.imageModel = imageModel;
  }

  @Override
  public void go() {

  }
}
