package structures.stack;

public interface Stack<T> {

  void push(T node);

  T pop();

  T peak();

  boolean isEmpty();

  Stack<T> reverse();

  int size();
}
