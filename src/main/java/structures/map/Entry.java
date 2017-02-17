package structures.map;

class Entry<K, V> {

    K key;
    V value;
    int hash;
    Entry<K, V> next;

    public Entry(K key, V value, int hash, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public Entry() {
    }
}