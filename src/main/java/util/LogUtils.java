package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import performance.CollectionsHelper;

public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(CollectionsHelper.class);

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
