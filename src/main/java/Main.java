import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends PApplet {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Figure> figures = new ArrayList<>();



    public static void main(String[] args) {
        PApplet.main("Main", args);
        int input = 0;

        do {
            interpretInput(input);
            System.out.printf("1 - Eingabe eines Polygons%n2 - Eingabe eines Rechtecks%n3 - Eingabe eines Quadrats%n4 - Eingabe einer Ellipse%n5 - Eingabe eines Kreises%n6 - Ausgabe aller Figuren%n7 - Beenden des Programmes%n%nEingabe: ");
            input = scanner.nextInt();
            while ((input < 1) || (input > 7)) {
                System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
                input = scanner.nextInt();
            }
        } while (input != 7);
    }

    private static void interpretInput(int input) {
            switch (input) {
            case 1:
                createPolygon();
                System.out.print("\n");
                break;
            case 2:
                createRectangle();
                System.out.print("\n");
                break;
            case 3:
                createSquare();
                System.out.print("\n");
                break;
            case 4:
                createEllipse();
                System.out.print("\n");
                break;
            case 5:
                createCircle();
                System.out.print("\n");
                break;
            case 6:
                outputFigures();
                System.out.print("\n");
                break;
            }
    }

    private static void createPolygon() {
        String coordinates = "";
        int countVerticles = 1;
        List<int[]> verticles = new ArrayList<>();

        while(!coordinates.equalsIgnoreCase("ende")) {
            System.out.printf("Geben Sie Eckpunkt %d des Polygons im Format (x,y) ein oder, wenn Sie die Eingabe beenden wollen, geben Sie 'ende' ein: ", countVerticles);
            coordinates = scanner.next();

            if(coordinates.equalsIgnoreCase("ende")){
                if(countVerticles < 4){
                    System.out.printf("%n!!! Sie dürfen hier die Eingabe noch nicht beenden !!!%nBitte erneut eingeben: ");
                    coordinates = scanner.next();

                    while (proofCorrectCoordinates(coordinates) != 1) {
                        System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
                        coordinates = scanner.next();
                    }
                    verticles.add(getCoordinates(coordinates));
                    countVerticles++;
                }
            }
            else {
                while (proofCorrectCoordinates(coordinates) != 1) {
                    System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
                    coordinates = scanner.next();
                }
                verticles.add(getCoordinates(coordinates));
                countVerticles++;
            }

        }
        figures.add(new Polygon(verticles));
    }

    private static void createRectangle() {
        String coordinates = "";
        double length = 0d;
        double width = 0d;

        System.out.print("Geben Sie die Koordinaten des Rechtecks im Format (x,y) ein: ");
        coordinates = scanner.next();
        while(proofCorrectCoordinates(coordinates) != 1){
            System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
            coordinates = scanner.next();
        }

        System.out.print("Geben Sie die Länge des Rechtecks ein: ");
        length = scanner.nextDouble();

        System.out.print("Geben Sie die Breite des Rechtecks ein: ");
        width = scanner.nextDouble();

        figures.add(new Rectangle(getCoordinates(coordinates), length, width));
    }

    private static void createSquare() {
        String coordinates = "";
        double length = 0d;

        System.out.print("Geben Sie die Koordinaten des Quadrats im Format (x,y) ein: ");
        coordinates = scanner.next();
        while(proofCorrectCoordinates(coordinates) != 1){
            System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
            coordinates = scanner.next();
        }

        System.out.print("Geben Sie die Seite des Quadrats ein: ");
        length = scanner.nextDouble();

        figures.add(new Square(getCoordinates(coordinates), length));
    }

    private static void createEllipse() {
        String coordinates = "";
        double mainAxis = 0d;
        double minorAxis = 0d;

        System.out.print("Geben Sie die Koordinaten der Ellipse im Format (x,y) ein: ");
        coordinates = scanner.next();
        while(proofCorrectCoordinates(coordinates) != 1){
            System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
            coordinates = scanner.next();
        }

        System.out.print("Geben Sie die Hauptachse der Ellipse ein: ");
        mainAxis = scanner.nextDouble();

        System.out.print("Geben Sie die Nebenachse der Ellipse ein: ");
        minorAxis = scanner.nextDouble();

        figures.add(new Ellipse(getCoordinates(coordinates), mainAxis, minorAxis));

    }

    private static void createCircle() {
        String coordinates = "";
        double radius = 0d;


        System.out.print("Geben Sie die Koordinaten des Kreises im Format (x,y) ein: ");
        coordinates = scanner.next();
        while(proofCorrectCoordinates(coordinates) != 1){
            System.out.printf("%n!!! Ungültige Eingabe !!!%nBitte erneut eingeben: ");
            coordinates = scanner.next();
        }

        System.out.print("Geben Sie den Radius des Kreises ein: ");
        radius = scanner.nextDouble();

        figures.add(new Circle(getCoordinates(coordinates), radius));
    }

    private static int[] getCoordinates(String coordinates) {
        String[] parts;

        parts = coordinates.split(",");

        int[] coordinatesInt = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            coordinatesInt[i] = Integer.parseInt(parts[i]);
        }

        return coordinatesInt;
    }

    private static int proofCorrectCoordinates(String coordinates) {
        char actualChar = '0';
        int countComma = 0;

        for (int i = 0; i < coordinates.length(); i++) {
            actualChar = coordinates.charAt(i);
            if (actualChar == ',') {
                countComma++;
            }
        }
        return countComma;
    }

    private static void outputFigures() {
        List<Figure> figuresSorted = sortArrayList();
        if (figuresSorted.size() != 0) {
            System.out.printf("Datenanzeige nach Fläche sortiert:%n====================================%n");
            for (Figure actualFigure : figuresSorted) {
                System.out.println(actualFigure.toString());
            }
            //DrawingFigure drawingFigure = new DrawingFigure(figuresSorted);
            //drawingFigure.draw();
        }
        else{
            System.out.printf("Sie haben noch keine Einträge erstellt.%n");
        }
    }

    private static List<Figure> sortArrayList() {
            List<Figure> figuresUnsorted = new ArrayList<>();
            figuresUnsorted = figures;
            double lowestArea = Integer.MAX_VALUE;
            List<Figure> figuresSorted = new ArrayList<>();
            int indexOfLowest = Integer.MAX_VALUE;

        for (int i = 0; i < figuresUnsorted.size();) {
            for (int j = 0; j < figuresUnsorted.size(); j++) {
                if ((figuresUnsorted.get(j).area()) < lowestArea) {
                    lowestArea = figuresUnsorted.get(j).area();
                    indexOfLowest = j;
                }
            }
            figuresSorted.add(figuresUnsorted.get(indexOfLowest));
            figuresUnsorted.remove(indexOfLowest);
            lowestArea = Integer.MAX_VALUE;
        }
        return figuresSorted;
    }
    public void settings(){
        size(800, 800);
    }
    public void setup(){
        background(0);
    }
}

