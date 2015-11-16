package patterns.creational.factory;

public class ElectricGuitar extends Guitar {

    public ElectricGuitar() {
        super(GuitarType.ELECTRIC);
        construct();
    }

    @Override
    protected void construct() {
        // TODO : implementation
    }
}
