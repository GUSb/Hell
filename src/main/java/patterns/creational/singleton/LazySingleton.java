package patterns.creational.singleton;

public class LazySingleton {

    public static LazySingleton instance = null;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance == null) {
            return instance = new LazySingleton();
        }
        return instance;
    }
}
