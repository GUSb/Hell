package structures.map;

@SuppressWarnings("unchecked")
public class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_THRESHOLD = 8;

    private int size;
    private int threshold;
    private int capacity;

    private Entry<K, V>[] table;

    public HashMap() {
        this(DEFAULT_CAPACITY);
        threshold = DEFAULT_THRESHOLD;
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }

    public V put(K key, V value) {

        int hash = key.hashCode();
        int index = index(hash);
        V oldValue = get(key);

        Entry<K, V> old = table[index];

        if (old == null) {

            table[index] = new Entry<>(key, value, key.hashCode(), null);
            increment();

        } else {
            Entry<K, V> copy = old;
            while (copy != null) {

                if (old.hash == key.hashCode() && old.key.equals(key)) {
                    table[index] = new Entry<>(key, value, key.hashCode(), null);
                }

                copy = copy.next;
            }
        }

        return oldValue;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = index(hash);
        Entry<K, V> pair = table[index];

        while (pair != null) {
            if (pair.hash == hash && key.equals(pair.key)) {
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

    public V remove(K key) {
        int hash = key.hashCode();
        int index = index(hash);
        Entry<K, V> pair = table[index];
        V deleted = null;

        if (pair != null && pair.hash == key.hashCode() && pair.key.equals(key)) {
            deleted = pair.value;
            table[index] = pair.next;
            decrement();
        } else if (pair != null) {
            Entry<K, V> copy = pair;

            while (copy != null) {
                if (copy.next != null && copy.next.hash == key.hashCode() && copy.next.key.equals(key)) {
                    deleted = copy.next.value;
                    copy.next = copy.next.next;
                    decrement();
                    break;
                }
                copy = copy.next;
            }

            table[index] = pair;
        }

        return deleted;
    }

    public int size() {
        return size;
    }

    private int index(int hash) {
        return Math.abs(hash % capacity);
    }

    private void increment() {
        ++size;
    }

    private void decrement() {
        --size;
    }
}
