package util;

import java.util.logging.Logger;

public class LogUtils {

  private static final Logger logger = Logger.getLogger("infoLogger");

  private LogUtils() {
  }

  public static void printArray(int[][] arr) {
    for (int[] innerArr : arr) {
      printArray(innerArr);
    }
    info(System.lineSeparator());
  }

  public static void printArray(int[] arr) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for (int i : arr) {
      sb.append(i).append(",");
    }

    sb.deleteCharAt(sb.length() - 1).append("]");
    info(sb.toString());
  }

  public static void info(String message) {
    logger.info(message);
  }
}
