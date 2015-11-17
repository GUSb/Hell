package exercises.stack;

public interface Stack<T> {

    void push(T node);

    T pop();

    T peak();

    boolean isEmpty();
}
