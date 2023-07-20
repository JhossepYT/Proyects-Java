import galapagos.*;
import java.awt.*;

class PAN2 {
    public static void main(String[] args) {
        TurtleDrawingWindow win = new TurtleDrawingWindow();
	     win.setGrid(false);
	     //win.setUnit(1.5);
	     win.setOrigin(200, 0);
         win.setSize(1000, 1000);
	     Turtle pablito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito2 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito6 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         Turtle pablito7 = new Turtle(Turtle.NO_DEFAULT_WINDOW);
         pablito2.speed(300);
         pablito2.jumpTo(52, 5);
         pablito7.speed(1000000);
         pablito7.penColor(Color.white);
	     win.add(pablito7);
         win.add(pablito2);
         win.add(pablito6);
         win.add(pablito);
         pablito7.jumpTo(-1000, 0);
         pablito7.move(2000);
         pablito7.turn(90);
         pablito7.jumpTo(0, -1000);
         pablito7.move(2000);
	     win.setVisible(true);
         LetrasUPRG.letraP(pablito);
         N_E_C_A_S.char_A(pablito2, 200,200,0);
         M_I_T_Z.letraZ(pablito6, 110, 0, 100);
    }
}
