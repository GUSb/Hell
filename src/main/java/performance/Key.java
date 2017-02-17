package performance;

import java.util.Objects;

public class Key {
    private int id;

    public Key(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Key)) return false;

        Key other = (Key) obj;
        return Objects.equals(other.id, this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
