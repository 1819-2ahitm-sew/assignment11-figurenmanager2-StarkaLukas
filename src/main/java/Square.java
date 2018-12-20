public class Square extends Figure {

    private int[] coordinates;
    private double length;

    public Square(int[] coordinates, double length) {
        this.coordinates = coordinates;
        this.length = length;
    }

    @Override
    public double area() {
        double area = 0d;

        area = length * length;

        return area;
    }

    @Override
    public double circumference() {
        double circumference = 0d;

        circumference = 4 * length;

        return circumference;
    }

    @Override
    public String toString() {
        String output = "";

        output = "Quadrat mit Seitenlänge " + formatSolution(length)+ ": Fläche -> " + formatSolution(area())+ ", Umfang -> " + formatSolution(circumference());

        return output;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public double getLength() {
        return length;
    }
}
