import episunsa.*;
import galapagos.*;
import java.awt.*;

public class Leo{
  public static void main(String[] args) {
    TurtleDrawingWindow lienzo = crearLienzo();
    pintarFoto(lienzo, 200, 0);
  }

  public static void pintarFoto(TurtleDrawingWindow canvas, int x, int y) {
    SimpleImage img = new SimpleImage("profitoPaz.png");
    int imageWidth = img.getWidth();
    int imageHeight = img.getHeight();

    Turtle turtleVinci1 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
    Turtle turtleVinci2 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
    canvas.add(turtleVinci1);
    canvas.add(turtleVinci2);
    turtleVinci1.penSize(5);
    turtleVinci2.penSize(5);

    for (int i = 0; i < imageWidth / 2; i++) {
      turtleVinci1.jumpTo(x + i * 2, y);
      turtleVinci1.heading(-90);
      pintarColumna(canvas, turtleVinci1, img, i, imageHeight);

      turtleVinci2.jumpTo(2 * imageWidth - 2 * i + x - 4, y);
      turtleVinci2.heading(-90);
      pintarColumna(canvas, turtleVinci2, img, imageWidth - i - 1, imageHeight);
    }

    // Libera la memoria de la imagen después de usarla
          turtleVinci1.hide();
      turtleVinci2.hide();
    img = null;
  }

  public static TurtleDrawingWindow crearLienzo() {
    TurtleDrawingWindow lienzo = new TurtleDrawingWindow();
    lienzo.setSize(1084, 746);
    lienzo.setResizable(true);
    lienzo.setOrigin(216, -142);
    lienzo.setBackground(new Color(0, 0, 0));
    lienzo.setTitle("Turtle-Vinci");
    lienzo.setVisible(true);
    lienzo.setGrid(true);
    lienzo.setUnit(2.5);
    return lienzo;
  }

  public static void pintarColumna(TurtleDrawingWindow lienzo, Turtle turtleVinci, SimpleImage img, int x, int imageHeight) {
    turtleVinci.speed(1); // Ajusta la velocidad fuera del bucle

    for (int y = 0; y < imageHeight; y++) {
      Pixel px = img.getPixel(x, y);
      int avg = (px.getRed() + px.getGreen() + px.getBlue()) / 3 + 20;
      Color color = new Color(avg, avg, avg);
      turtleVinci.penColor(color);
      turtleVinci.speed(1000);
      turtleVinci.move(2);
      turtleVinci.bodyColor(new Color((x + y) % 255, (y * x) % 255, (255 + x * 3 + y) % 255));
    }
  }
}


