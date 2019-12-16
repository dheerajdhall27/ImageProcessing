package view;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the implementation of the {@link IImageView} interface, which is the view
 * for this MVC application.
 */
public class ImageViewImpl implements IImageView {

  private Appendable out;
  private Scanner scanner;

  /**
   * This constructor is used to create a textual view for the Image application.
   *
   * @param in  the readable to read input
   * @param out the appendable to display output
   */
  public ImageViewImpl(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("The arguments passed are null");
    }
    this.out = out;
    this.scanner = new Scanner(in);
  }

  @Override
  public void displayOutput(String message) {
    try {
      out.append(message);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public String takeInput(String message) {
    displayOutput(message);
    if (scanner.hasNext()) {
      return scanner.next();
    }

    return null;
  }
}
