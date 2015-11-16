package patterns.creational.prototype;

public class Archer implements Unit<Archer> {

    @Override
    public Archer clone() {
        Archer archer = null;
        try {
            archer = (Archer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return archer;
    }
}
