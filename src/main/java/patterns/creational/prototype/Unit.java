package patterns.creational.prototype;

public interface Unit<T> extends Cloneable {
    public abstract T clone() throws CloneNotSupportedException;
}
