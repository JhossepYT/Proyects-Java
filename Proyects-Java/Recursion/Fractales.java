import java.awt.Color;
import galapagos.*;

public class Fractales {
    public static void main(String[] args) {
        TurtleDrawingWindow win = new TurtleDrawingWindow();
        win.setGrid(false);
        Turtle pablito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        Turtle jaimito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        Turtle jacinto = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        Turtle jerusalen = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        Turtle manito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        Turtle piecito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        win.add(pablito);
        win.add(jaimito);
        win.add(jacinto);
        win.add(jerusalen);
        win.add(manito);
        win.add(piecito);
        win.setVisible(true);
        int length = 400;

        pablito.penSize(2);
        pablito.speed(3900);
        pablito.hide();
        jaimito.penSize(2);
        jaimito.speed(3900);
        jaimito.hide();
        /*
         * jacinto.penSize(3); jacinto.speed(3900); jacinto.hide();
         * jerusalen.penSize(3); jerusalen.speed(3900); jerusalen.hide();
         * manito.penSize(3); manito.speed(3900); manito.hide();
         * piecito.penSize(3); piecito.speed(3900); piecito.hide();
         */

        pablito.penColor(Color.ORANGE);
        pablito.jumpTo(-100, 0);
        jaimito.penColor(Color.BLUE);
        jaimito.jumpTo(-length / 2.0, 0);
        /*
         * jacinto.penColor(Color.MAGENTA); jacinto.jumpTo(-length * 2 / 2.0, 0);
         * jerusalen.penColor(Color.CYAN); jerusalen.jumpTo(-length * 2 / 2.0, 0);
         * manito.penColor(Color.BLACK); manito.jumpTo(-length * 3/ 2.0, 0);
         * piecito.penColor(Color.RED); piecito.jumpTo(-length * 3/ 2.0, 0);
         */

        fractalitosXd(pablito, length);
        // fractalitos2Xd(jaimito, length);
        /*
         * fractalitosXd(jacinto, length);
         * fractalitos2Xd(jerusalen, length);
         * fractalitosXd(manito, length);
         * fractalitos2Xd(piecito, length);
         */
    }

    public static void fractalitosXd(Turtle pablito, double length) {
        if (length < 20) {
            pablito.move(length);
            // pablito.turn(60);
            return;
        }
        length /= 3;
        pablito.turn(60);
        fractalitosXd(pablito, length);
        pablito.turn(60);
        fractalitosXd(pablito, length);
        pablito.turn(-120);
        fractalitosXd(pablito, length);
        pablito.turn(60);
        fractalitosXd(pablito, length);

        pablito.turn(-120);
        fractalitosXd(pablito, length);
        pablito.turn(60);
        fractalitosXd(pablito, length);
        pablito.turn(-120);
        fractalitosXd(pablito, length);
        pablito.turn(60);
        fractalitosXd(pablito, length);

        pablito.turn(-120);
        fractalitosXd(pablito, length);
        pablito.turn(60);
        fractalitosXd(pablito, length);
        pablito.turn(-120);
        fractalitosXd(pablito, length);
        pablito.turn(60);
        fractalitosXd(pablito, length);
    }

    public static void triangulo(Turtle pablito, double length) {
        pablito.move(length);
        pablito.turn(120);
        pablito.move(length);
        pablito.turn(120);
        pablito.move(length);
        pablito.turn(120);
    }
}