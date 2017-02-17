package patterns.creational.factory;

public class AcousticGuitar extends Guitar {

    public AcousticGuitar() {
        super(GuitarType.ACOUSTIC);
        construct();
    }

    @Override
    protected void construct() {
        // TODO : implementation
    }
}
