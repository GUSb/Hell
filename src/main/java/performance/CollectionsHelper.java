package performance;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public abstract class CollectionsHelper {

    public static Collection<Integer> generate (int size, int randomization, Collection<Integer> data) {
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(randomization));
        }

        return data;
    }

    public static Map<Key, Integer> generate(int size, Map<Key, Integer> data) {
        for (int i = 0; i < size; i++) {
            data.put(new Key(i), i);
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
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return time;
    }

    public static long nanosToMillis(long nanos) {
        return nanos / 1_000_000;
    }
}
