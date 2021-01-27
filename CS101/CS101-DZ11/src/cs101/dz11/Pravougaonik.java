package cs101.dz11;

public class Pravougaonik implements Izracunljiv {

    private double a;
    private double b;

    public Pravougaonik() {
    }

    public Pravougaonik(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double racunajPovrsinu() {
        return a * b;
    }

    @Override
    public double racunajObim() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        return "Pravougaonik{" + "a=" + a + ", b=" + b + '}';
    }
}
