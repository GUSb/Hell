package exercises.stack;

import java.util.HashMap;
import java.util.Map;

public class MapBasedStack<T> implements Stack<T> {

    private Map<Integer, T> nodes;
    private Integer index = 0;

    public MapBasedStack() {
        nodes = new HashMap<>();
    }

    @Override
    public void push(T node) {
        index++;
        nodes.put(index, node);
    }

    @Override
    public T pop() {
        if (index == 0) {
            throw new RuntimeException("Stack is empty");
        }
        T node = nodes.get(index);
        nodes.remove(index);
        index--;
        return node;
    }
}
