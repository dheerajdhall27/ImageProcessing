import controller.command.filter.BlurCommand;
import controller.command.ICommand;
import controller.command.SaveCommand;
import controller.command.filter.SharpenCommand;
import controller.command.transformation.GreyScaleCommand;
import controller.command.transformation.SepiaCommand;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.IImageModel;
import model.ImageImpl;
import model.ImageModelImpl;

/**
 * This class represents the driver class for this program.
 */
public class ImageMain {

  public static void main(String[] args) {
    try {
      BufferedImage bufferedImage = ImageIO.read(new File("rahul.png"));
      int imgWidth = bufferedImage.getWidth();
      int imgHeight = bufferedImage.getHeight();

      float[][][] imageInformation = getImageInformation(bufferedImage, imgWidth, imgHeight);

      IImageModel imageModel = new ImageModelImpl(new ImageImpl(imageInformation));
//      ICommand blurCommand = new BlurCommand(imageModel);
//      blurCommand.execute();
//
////       Save the File
//      ICommand saveCommand = new SaveCommand(imageModel.getImageData(),
//          "Images/blurred.png");
//      saveCommand.execute();

//      ICommand sharpenCommand = new SharpenCommand(imageModel);
//      sharpenCommand.execute();
//
//      ICommand saveCommand2 = new SaveCommand(imageModel.getImageData(),
//          "Images/sharpened.png");
//      saveCommand2.execute();

      ICommand greyScaleCommand = new GreyScaleCommand(imageModel);
      greyScaleCommand.execute();

      ICommand saveCommand3 = new SaveCommand(imageModel.getImageData(),
          "Images/greyScale.png");
      saveCommand3.execute();

      ICommand sepiaCommand = new SepiaCommand(imageModel);
      sepiaCommand.execute();

      ICommand saveCommand4 = new SaveCommand(imageModel.getImageData(),
          "Images/sepia.png");
      saveCommand4.execute();


    } catch (IOException e) {
      System.out.print("The file does not exist: " + e.getMessage());
    }
  }

  private static float[][][] getImageInformation(BufferedImage bufferedImage, int imgWidth,
      int imgHeight) {
    float[][][] imageInformation = new float[imgWidth][imgHeight][3];

    for (int i = 0; i < imageInformation.length; i++) {
      for (int j = 0; j < imageInformation[i].length; j++) {
        int pixelData = bufferedImage.getRGB(i, j);
        Color color = new Color(pixelData);
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        imageInformation[i][j][0] = red;
        imageInformation[i][j][1] = green;
        imageInformation[i][j][2] = blue;
      }
    }

    return imageInformation;
  }
}
