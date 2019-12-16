package util;

import java.util.HashMap;
import java.util.Map;
import model.flags.EFlags;
import model.flags.FranceImageGeneration;
import model.flags.GreeceImageGeneration;
import model.flags.IImageGeneration;

/**
 * A util class to provide certain global variables and functionality.
 */
public class Utility {

  public static Map<EFlags, IImageGeneration> FLAG_MAP = new HashMap<>();

  public static String MESSAGE = "PLEASE CHOOSE ONE.\n"
      + "1. GENERATE A FLAG.\n"
      + "2. GENERATE A CHECKERBOARD\n";

  public static String FLAG_MESSAGE = "PLEASE CHOOSE A FLAG TO GENERATE.\n"
      + "1. FRANCE\n"
      + "2. GREECE\n"
      + "3. SWITZERLAND\n";

  public static String CHECKERBOARD_MESSAGE = "PLEASE ENTER THE LENGTH OF THE SQUARE.\n";

  public static void initializeMap() {
    FLAG_MAP = new HashMap<>();

    FLAG_MAP.put(EFlags.FRANCE, new FranceImageGeneration());
    FLAG_MAP.put(EFlags.GREECE, new GreeceImageGeneration());
    FLAG_MAP.put(EFlags.SWITZERLAND, null);
  }

}
