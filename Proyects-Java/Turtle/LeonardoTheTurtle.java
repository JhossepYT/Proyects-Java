import episunsa.*;
import galapagos.*;
import java.awt.*;

public class LeonardoTheTurtle {
    public static void main(String[] args) {

        SimpleImage img = new SimpleImage("episunsa.jpg");

        TurtleDrawingWindow lienzo = crearLienzo();

        Turtle[] leoDaTurtle = new Turtle[img.getWidth()];

        for(int x = 0; x < img.getWidth(); x++) {
            leoDaTurtle[x] = new Turtle(Turtle.NO_DEFAULT_WINDOW);
            leoDaTurtle[x].jumpTo(x * 2, 0);
            lienzo.add(leoDaTurtle[x]);
            leoDaTurtle[x].heading(-90.0);
            leoDaTurtle[x].penSize(5);
            pintarColumna(lienzo, leoDaTurtle[x], img, x);
        }
    }
    
    public static TurtleDrawingWindow crearLienzo(){
        TurtleDrawingWindow lienzo = new TurtleDrawingWindow();
        lienzo.setSize(1084, 746);
        lienzo.setResizable(true);
        lienzo.setOrigin(216, -142);
        lienzo.setBackground(new Color(0, 0, 0));
        lienzo.setTitle("Turtle-Vinci");
        lienzo.setVisible(true);
        lienzo.setGrid(false);
        lienzo.setUnit(2.5);
        return lienzo;
    }

    public static void pintarColumna(TurtleDrawingWindow lienzo, Turtle turtleVinci, SimpleImage img, int x) {
                for(int y = 0; y < img.getHeight(); y++){
                        Pixel px = img.getPixel(x, y);
                        Color color = new Color(px.getRed(), px.getGreen(), px.getBlue());
                        turtleVinci.penColor(color);
                        turtleVinci.speed((x + y) % 35 + y + 5);
                        turtleVinci.move(2);
                        turtleVinci.bodyColor(new Color((x + y) % 255, (y * x) % 255, (255 + x * 3 + y) % 255));
        }
    }
}	       
