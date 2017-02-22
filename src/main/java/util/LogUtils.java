package util;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LogUtils {

    // TODO : logger have errors need fixing
    //private static Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void printArray(int[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {

            sb.append("[");

            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(",");
            }

            sb.deleteCharAt(sb.length() - 1).append("]").append(System.lineSeparator());
        }

        info(sb.toString());
    }

    public static void info(String message) {
        System.out.println(message);
    }
}
