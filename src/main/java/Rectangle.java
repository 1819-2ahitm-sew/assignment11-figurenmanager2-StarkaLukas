public class Rectangle extends Figure {

    private int[] coordinates;
    private double length;
    private double width;

    public Rectangle(int[] coordinates, double length, double width) {
        this.coordinates = coordinates;
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {

        double area = 0d;

        area = length * width;


        return area;
    }

    @Override
    public double circumference() {
        double circumference = 0d;

        circumference = 2 * length + 2 * width;
        return circumference;
    }

    @Override
    public String toString() {
        String output = "";


        output = "Rechteck mit der Länge " + formatSolution(length) + " und der Breite " + formatSolution(width)+ ": Fläche -> " + formatSolution(area())+ ", Umfang -> " + formatSolution(circumference());

        return output;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
