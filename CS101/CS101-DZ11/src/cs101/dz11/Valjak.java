package cs101.dz11;

public class Valjak implements Izracunljiv {

    private double h;
    private double r;

    public Valjak() {
    }

    public Valjak(double h, double r) {
        this.h = h;
        this.r = r;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Valjak{" + "h=" + h + ", r=" + r + '}';
    }

    @Override
    public double racunajPovrsinu() {
        return 2 * Math.PI * r * (r + h);
    }

    @Override
    public double racunajObim() {
        return Math.PI * (r * r) * h;
    }
}
