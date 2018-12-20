public class Ellipse extends Figure {

    private int[] coordinates;
    private double mainAxis;
    private double minorAxis;

    public Ellipse(int[] coordinates, double mainAxis, double minorAxis) {
        this.coordinates = coordinates;
        this.mainAxis = mainAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double area() {
        double area = 0d;

        area = Math.PI * mainAxis * minorAxis;

        return area;
    }

    @Override
    public double circumference() {
        double circumference = 0d;
        double lambda = 0d;

        lambda = (mainAxis - minorAxis) / (mainAxis + minorAxis);

        circumference = (mainAxis + minorAxis) * Math.PI * (1 + ((3 * lambda * lambda) / (10 + Math.sqrt(4 - 3 * lambda * lambda))));

        return circumference;
    }

    @Override
    public String toString() {
        String output = "";

        output = "Ellipse mit Hauptachse " + formatSolution(mainAxis) + " und Nebenachse " + formatSolution(minorAxis)+ ": Fläche -> " + formatSolution(area())+ ", Umfang " + formatSolution(circumference());

        return output;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public double getMainAxis() {
        return mainAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }
}
