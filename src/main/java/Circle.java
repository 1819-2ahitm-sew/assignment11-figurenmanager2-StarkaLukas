public class Circle extends Figure {

    private int[] coordinates;
    private double radius;

    public Circle(int[] coordinates, double radius) {
        this.coordinates = coordinates;
        this.radius = radius;
    }

    @Override
    public double area() {
        double area = 0d;

        area = Math.PI * radius * radius;

        return area;
    }

    @Override
    public double circumference() {
        double circumference = 0d;

        circumference = 2 * Math.PI * radius;

        return circumference;
    }

    @Override
    public String toString() {
        String output = "";

        output = "Kreis mit Radius " + formatSolution(radius) + ": Fläche -> " + formatSolution(area())+ ", Umfang -> " + formatSolution(circumference());

        return output;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public double getRadius() {
        return radius;
    }
}
