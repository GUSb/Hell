package exercises.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayBasedStack<T> implements Stack<T> {

    private final int DEFAULT_SIZE = 5;
    private final int SIZE_MULTIPLIER = 2;

    private T[] nodes;
    private Integer index = 0;

    public ArrayBasedStack(Class<T> clazz) {
        nodes = (T[]) Array.newInstance(clazz, DEFAULT_SIZE);
    }

    public ArrayBasedStack(T[] nodes) {
        this.nodes = nodes;
    }

    @Override
    public void push(T node) {
        if (index == nodes.length - 1) {
            nodes = Arrays.copyOf(nodes, nodes.length * SIZE_MULTIPLIER);
        }
        index++;
        nodes[index] = node;
    }

    @Override
    public T pop() {
        if (index == 0) {
            throw new RuntimeException("Stack is empty");
        }
        T node = nodes[index];
        nodes[index] = null;
        index--;
        return node;
    }

    @Override
    public T peak() {
        return nodes[index - 1];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }
}
