import episunsa.*;
import galapagos.*;
import java.awt.*;

class PAN {
    public static void main(String[] args) {
        TurtleDrawingWindow win = new TurtleDrawingWindow();
	     win.setGrid(false);
	     //win.setUnit(1.5);
	     win.setOrigin(200, 0);
         win.setSize(1000, 1000);
         SimpleImage a = new SimpleImage("logo.jpg");
	     Turtle pablito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito2 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito3 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito4 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito5 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         pablito2.speed(300);
         pablito2.jumpTo(55, 5);
         pablito3.speed(300);
         pablito5.speed(300);
	     win.add(pablito);
         win.add(pablito2);
         win.add(pablito3);
         win.add(pablito4);
         win.add(pablito5);
	     win.setVisible(true);
         LetrasUPRG.letraP(pablito);
         N_E_A_S.char_A(pablito2, 200,200,0);
         Leo.pintarFoto(win, 220, 120);
         O_D_L_Q.letraD(pablito3, 105, 0);
         Logo.pintarImagen(win, pablito4, 6, 300,0 ,80);
         LettersYHB.workSlv(pablito5, 0, 0, LettersYHB.letterY, 15);
    }
}
