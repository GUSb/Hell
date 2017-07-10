package structures.list;

public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object node);

    boolean add(E node);

    E remove(int index);

    boolean remove(Object node);

    E get(int index);

    void clear();

    E set(int index, E node);

    void add(int index, E node);

    int indexOf(Object node);
}
