package structures.map;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Entry)) {
            return false;
        }

        Entry other = (Entry) obj;
        return Objects.equals(other.key, this.key)
                && Objects.equals(other.value, this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return String.format("Key: %s Value: %s", key, value);
    }
}