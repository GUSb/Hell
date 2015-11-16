package exercises.stack;

import java.util.HashMap;
import java.util.Map;

public class StackPool<T> {

    private Map<Integer, T> nodes = new HashMap<>();
    private Integer index = 0;

    public void put(T node) {
        index++;
        nodes.put(index, node);
    }

    public T get() {
        if (index == 0) {
            throw new RuntimeException("Stack is empty");
        }
        T node = nodes.get(index);
        nodes.remove(index);
        index--;
        return node;
    }
}
