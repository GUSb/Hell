package structures.map;

@SuppressWarnings("unchecked")
public class Map<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_THRESHOLD = 8;

    private int size;
    private int threshold;
    private int capacity;

    private Entry<K, V>[] table;

    public Map() {
        this(DEFAULT_CAPACITY);
        threshold = DEFAULT_THRESHOLD;
    }

    public Map(int capacity) {
        this.capacity = capacity;
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }

    public boolean put(K key, V value) {

        if (value == null) {
            return false;
        }

        int hash = key.hashCode();
        int index = index(hash);

        Entry<K, V> old = table[index];
        table[index] = new Entry<>(key, value, key.hashCode(), old);

        size++;
        return true;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = index(hash);
        Entry<K, V> pair = table[index];

        while (pair != null) {
            if (pair.key.hashCode() == hash && key.equals(pair.key)) {
                return pair.value;
            } else {
                pair = pair.next;
            }
        }

        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean remove(K key) {
        int hash = key.hashCode();
        int index = index(hash);
        Entry<K, V> pair = table[index];

        Integer oldSize = size;
        delete(pair, key);
        return oldSize > size;
    }

    public int size() {
        return size;
    }

    private Entry<K, V> delete(Entry<K, V> node, K key) {

        if (node != null && node.hash == key.hashCode()) {
            node = node.next;
            --size;
        } else if (node != null) {
            delete(node.next, key);
        }

        return node;
    }

    private int index(int hash) {
        return Math.abs(hash % capacity);
    }
}
