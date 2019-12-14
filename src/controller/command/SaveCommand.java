package controller.command;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class represents a save command which is used to save an image's data.s
 */
public class SaveCommand implements ICommand {

  private BufferedImage bufferedImage;
  private String path;

  /**
   * This constructor is used to create a Save Command that can be used to save an Image that has
   * been processed.
   *
   * @param bufferedImage the image Data after being processed
   */
  public SaveCommand(BufferedImage bufferedImage, String path) {
    this.bufferedImage = bufferedImage;
    this.path = path;
  }

  @Override
  public void execute() {
    File outputFile = new File(path);

    try {
      ImageIO.write(bufferedImage, "png", outputFile);
    } catch (IOException ioexception) {
      System.out.println("Failed to save the file! " + ioexception.getMessage());
    }
  }
}
