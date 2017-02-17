package patterns.creational.factory;

public abstract class Guitar {

    private GuitarType type;

    public Guitar(GuitarType type) {
        this.type = type;
        prepareDetails();
    }

    protected abstract void construct();

    public GuitarType getType() {
        return type;
    }

    public void setType(GuitarType type) {
        this.type = type;
    }

    private void prepareDetails() {
        // TODO : prepare details for guitar
    }
}
