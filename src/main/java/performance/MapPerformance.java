package performance;

import java.util.HashMap;
import java.util.Map;

public class MapPerformance {

    public Map<Key, Integer> generate(int size) {
        Map<Key, Integer> nodes = new HashMap<>();

        long time = CollectionsHelper.countTimeMillis(() -> CollectionsHelper.generate(size, nodes));
        System.out.println(String.format("Generated %s nodes of HashMap in time - %s ms", size, time));

        return nodes;
    }
}
