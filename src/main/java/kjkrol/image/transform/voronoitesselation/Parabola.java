package kjkrol.image.transform.voronoitesselation;

import javafx.geometry.Point2D;

import java.util.function.Function;

/**
 * @author Karol Krol
 */
public class Parabola implements Function<Double, Double> {

    private final double a;
    private final double b;
    private final double c;

    private Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Parabola build(final Point2D focusPoint, final double lineYPos) {
        final double bcSum = focusPoint.getY() + lineYPos;
        final double bcDif = focusPoint.getY() - lineYPos;
        final double a = 1.0 / (2.0 * bcDif);
        final double b = - focusPoint.getX() / bcDif;
        final double c = Math.pow(focusPoint.getX(), 2) * a + bcSum / 2;
        return new Parabola(a, b, c);
    }

    @Override
    public Double apply(Double x) {
        return Math.pow(x, 2) * this.a + x * this.b - this.c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}