import controller.IImageController;
import controller.ImageControllerImpl;
import java.io.InputStreamReader;
import model.IImageModel;
import model.ImageModelImpl;
import view.IImageView;
import view.ImageViewImpl;

/**
 * This class represents the driver class for this program.
 */
public class ImageMain {

  public static void main(String[] args) {
    IImageModel imageModel = new ImageModelImpl();

    IImageView imageView = new ImageViewImpl(new InputStreamReader(System.in), System.out);

    IImageController imageController = new ImageControllerImpl(imageModel, imageView);

    imageController.go();
  }

}
