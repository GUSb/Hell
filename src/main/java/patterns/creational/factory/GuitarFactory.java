package patterns.creational.factory;

public class GuitarFactory {

    public static Guitar constructGuitar(GuitarType type) {
        Guitar guitar = null;

        switch (type) {
            case ACOUSTIC :
                guitar = new AcousticGuitar();
                break;
            case ELECTRIC :
                guitar = new ElectricGuitar();
                break;
            default :
                // TODO : throw exception
                break;
        }

        return guitar;
    }
}
