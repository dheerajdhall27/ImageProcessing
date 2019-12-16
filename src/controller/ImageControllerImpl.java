package controller;

import controller.command.CheckerBoardCommand;
import controller.command.ICommand;
import controller.command.flag.FlagCommand;
import model.IImageModel;
import model.flags.EFlags;
import util.Utility;
import view.IImageView;

/**
 * This class is an implementation of the {@link IImageController}.
 */
public class ImageControllerImpl implements IImageController {

  private IImageModel imageModel;
  private IImageView imageView;

  public ImageControllerImpl(IImageModel imageModel, IImageView imageView) {
    this.imageModel = imageModel;
    this.imageView = imageView;
  }

  @Override
  public void go() {
    String message = imageView.takeInput(Utility.MESSAGE);

    while (message != null) {

      if (message.equals("Q") || message.equals("q")) {
        imageView.displayOutput("QUITTING APPLICATION");
        break;
      } else {
        processCommand(message);
        message = imageView.takeInput(Utility.MESSAGE);
      }
    }
  }


  private void processCommand(String option) {

    switch (option) {
      case ("1"):
        String input = imageView.takeInput(Utility.FLAG_MESSAGE);
        processInputForFlags(input);
        break;
      case ("2"):
        checkerBoardHelper();
        break;
      default:
        throw new IllegalArgumentException("Invalid Entry!");
    }
  }

  private void processInputForFlags(String option) {
    ICommand command = null;
    switch (option) {
      case ("1"):
        command = new FlagCommand(EFlags.FRANCE, imageModel);
        command.execute();
        break;
      case ("2"):
        command = new FlagCommand(EFlags.GREECE, imageModel);
        command.execute();
        break;
      case ("3"):
        command = new FlagCommand(EFlags.SWITZERLAND, imageModel);
        command.execute();
        break;
      case ("4"):
        command = new FlagCommand(EFlags.HORIZONTAL_RAINBOW, imageModel);
        command.execute();
        break;
      case ("5"):
        command = new FlagCommand(EFlags.VERTICAL_RAINBOW, imageModel);
        command.execute();
        break;
      case ("q"):
      case ("Q"):
        imageView.displayOutput("QUITTING APPLICATION");
        System.exit(1);
      default:
        imageView.displayOutput("The Entered option is invalid\n");
        String input = imageView.takeInput(Utility.FLAG_MESSAGE);
        if (input != null) {
          processInputForFlags(input);
        }

    }
  }

  private void checkerBoardHelper() {
    ICommand command = null;
    String input = imageView.takeInput(Utility.CHECKERBOARD_MESSAGE);

    try {
      int value = Integer.parseInt(input);
      command = new CheckerBoardCommand(imageModel, value);
      command.execute();
    } catch (NumberFormatException e) {
      imageView.displayOutput("Please enter a valid Number");
      checkerBoardHelper();
    }
  }
}
