import java.util.List;

public class Polygon extends Figure {

    private List<int[]> vertices;
    private final int placeX = 0;
    private final int placeY = 1;

    public Polygon(List<int[]> vertices) {
        this.vertices = vertices;
    }

    @Override
    public double area() {
        double area = 0d;

        for (int i = 0; i < vertices.size(); i++) {
            if(i == vertices.size() - 1){
                area += Math.abs((vertices.get(i)[placeX] * vertices.get(0)[placeY]) - (vertices.get(i)[placeY] * vertices.get(0)[placeX]));
            }
            else{
                area += Math.abs((vertices.get(i)[placeX] * vertices.get(i + 1)[placeY]) - (vertices.get(i)[placeY] * vertices.get(i + 1)[placeX]));
            }
        }
        area /= 2;
        return area;
    }

    @Override
    public double circumference() {
        double circumference = 0d;

        for (int i = 0; i < vertices.size(); i++) {
            if(i == vertices.size() - 1){
                circumference += Math.sqrt(((vertices.get(0)[placeX] - vertices.get(i)[placeX]) * (vertices.get(0)[placeX] - vertices.get(i)[placeX])) + ((vertices.get(0)[placeY] - vertices.get(i)[placeY]) * (vertices.get(0)[placeY] - vertices.get(i)[placeY])));
            }
            else{
                circumference += Math.sqrt(((vertices.get(i + 1)[placeX] - vertices.get(i)[placeX]) * (vertices.get(i + 1)[placeX] - vertices.get(i)[placeX])) + ((vertices.get(i + 1)[placeY] - vertices.get(i)[placeY]) * (vertices.get(i + 1)[placeY] - vertices.get(i)[placeY])));
            }

        }
        return circumference;
    }

    @Override
    public String toString() {
        String output = "";
        int counter = 1;

        output += "Polygon mit ";
        for (int i = 0; i < vertices.size(); i++) {
            if(i != 0){
                output += "            ";
            }
            output += "Eckpunkt " + counter++ + " (" + vertices.get(i)[placeX] + "," + vertices.get(i)[placeY] + ")\n";
        }
        output += "Fläche -> " + formatSolution(area()) + ", Umfang -> " + formatSolution(circumference());

        return output;
    }

    public List<int[]> getVertices() {
        return vertices;
    }

    public int getPlaceX() {
        return placeX;
    }

    public int getPlaceY() {
        return placeY;
    }
}
