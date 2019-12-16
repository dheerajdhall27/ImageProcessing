package view;

/**
 * This interface represents the view for the Image application.
 */
public interface IImageView {

  /**
   * This method is used to display an output to the user
   *
   * @param message the output that has to be displayed.
   */
  void displayOutput(String message);

  /**
   * This method is used get input from the user.
   *
   * @param message the message that the user typed
   * @return the input entered by the user for processing.
   */
  String takeInput(String message);
}
