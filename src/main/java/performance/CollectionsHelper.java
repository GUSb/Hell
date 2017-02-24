package performance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Callable;

public class CollectionsHelper {

    private static final Logger logger = LoggerFactory.getLogger(CollectionsHelper.class);
    private static final String ERROR_MESSAGE = "Error occur during task execution";

    private CollectionsHelper() {
    }

    public static Collection<Integer> generate (int size, int randomization, Collection<Integer> data) {
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(randomization));
        }

        return data;
    }

    public static long countTimeMillis(Callable task) {
        long time = 0;

        try {
            time = System.currentTimeMillis();
            task.call();
            time = System.currentTimeMillis() - time;
        } catch (Exception e) {
            logger.info(ERROR_MESSAGE, e);
        }

        return time;
    }

    public static long countTimeNanos(Callable task) {
        long time = 0;

        try {
            time = System.nanoTime();
            task.call();
            time = System.nanoTime() - time;
        } catch (Exception e) {
            logger.info(ERROR_MESSAGE, e);
        }

        return time;
    }

    public static long nanosToMillis(long nanos) {
        return nanos / 1_000_000;
    }
}
