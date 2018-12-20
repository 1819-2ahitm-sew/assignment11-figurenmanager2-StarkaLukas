import javafx.stage.Screen;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class DrawingFigure extends Figure {

    private List<Figure> figures = new ArrayList<>();
    private final int placeX = 0;
    private final int placeY = 1;

    public DrawingFigure(List<Figure> figures) {
        this.figures = figures;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double circumference() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
    public void setup(){
        size(800, 800);
    }
    public void settings() {
        background(0);
    }

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }
    public void draw(){
            for (int i = 0; i < figures.size(); i++) {
                if(figures.get(i) instanceof Polygon){
                    fill(255, 0, 0);
                    rect(0,0, 100, 100);
                }else if(figures.get(i) instanceof Rectangle){
                    fill(0, 255, 0);
                    rect(((Rectangle) figures.get(i)).getCoordinates()[placeX] ,((Rectangle) figures.get(i)).getCoordinates()[placeY] , (float) ((Rectangle) figures.get(i)).getLength(),(float) ((Rectangle) figures.get(i)).getWidth());
                    System.out.println();
                }else if(figures.get(i) instanceof Square){
                    fill(0, 0, 255);
                    rect(((Square) figures.get(i)).getCoordinates()[placeX] ,((Square) figures.get(i)).getCoordinates()[placeY] , (float) ((Square) figures.get(i)).getLength(),(float) ((Square) figures.get(i)).getLength());
                }
                else if(figures.get(i) instanceof Ellipse){
                    fill(0, 255, 255);
                    ellipse(((Ellipse) figures.get(i)).getCoordinates()[placeX], ((Ellipse) figures.get(i)).getCoordinates()[placeY], (float) ((Ellipse) figures.get(i)).getMainAxis(), (float) ((Ellipse) figures.get(i)).getMinorAxis());
                }
                else if(figures.get(i) instanceof Circle){
                    fill(255, 0, 255);
                    ellipse(((Circle) figures.get(i)).getCoordinates()[placeX], ((Circle) figures.get(i)).getCoordinates()[placeY],(float) ((Circle) figures.get(i)).getRadius(), (float) ((Circle) figures.get(i)).getRadius());
                }
            }
        }

}

