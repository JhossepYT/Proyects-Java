import java.awt.Color;
import galapagos.*;
public class LetrasUPRG {
	public static void main(String[] args) {
		 TurtleDrawingWindow win = new TurtleDrawingWindow();
	     win.setGrid(false);
	     //win.setUnit(1.5);
	     win.setOrigin(200, 0);
	     Turtle pablito = new Turtle(Turtle.NO_DEFAULT_WINDOW);
	     win.add(pablito);
	     win.setVisible(true);
	     
	     //Lo puedes modificar para que se acomode, es que si esta en (0, 0) se desborda xd.
	     pablito.jumpTo(2, 0);
	     LetrasUPRG.letraU(pablito,0,0,0);
	     LetrasUPRG.letraP(pablito,0,0,0);
	     LetrasUPRG.letraR(pablito,0,0,0);
	     LetrasUPRG.letraG(pablito,0,0,0);
	}
	
	public static void letraU(Turtle u, int r, int g, int b) {
        Color color = new Color(r, g, b);
		u.bodyColor(color);
		u.penSize(9); u.hide();
		u.speed(4000);
		u.penUp(); u.turn(90); u.move(50); u.turn(180);
		u.penDown();
		//1ra columna
		for(int i = 0; i < 11; i++) {
			cuadraditoXd(u);
			u.move(5);
		}
		u.penUp(); cuadraditoXd(u); u.move(5);
		u.turn(90); u.move(4); u.penDown();
		//base fila
		for(int i = 0; i < 8; i++) {
			cuadraditoXd(u);
			u.move(4);
		}
		u.penUp(); u.turn(90); u.move(5); u.turn(-90); u.penDown();
		//2da columna
		for(int i = 0; i < 11; i++) {
			cuadraditoXd(u);
			u.turn(90); u.move(5); u.turn(-90);
		}
		//pocicionar para la siguiente letra
		u.penUp(); u.turn(-90); u.move(50); u.turn(90); u.move(15); u.penDown();
	}
	
	public static void letraP(Turtle p, int r, int g, int b) {
        Color color = new Color(r, g, b);
		p.bodyColor(color);
		p.penSize(9); p.hide();
		p.speed(4000);
		//columna vertebral xd
		for(int i = 0; i < 12; i++) {
			cuadraditoXd(p);
			p.turn(90); p.move(5); p.turn(-90);
		}
		p.move(4); p.turn(-90); p.move(5); p.turn(90);
		//1ra fila
		for(int i = 0; i < 8; i++) {
			cuadraditoXd(p);
			p.move(4);
		}
		p.turn(-90);
		//columna
		for(int i = 0; i < 4; i++) {
			cuadraditoXd(p);
			p.move(5);
		}
		p.turn(-90);
		//2da fila
		for(int i = 0; i < 8; i++) {
			cuadraditoXd(p);
			p.move(5);
		}
		//pocicionar para la siguiente letra
		p.penUp(); p.turn(90); p.move(30); p.turn(90); p.move(46); p.penDown();
	}
	
	public static void letraR(Turtle r, int j, int g, int b) {
        Color color = new Color(j, g, b);
		r.bodyColor(color);
		r.penSize(9); r.hide();
		r.speed(4000);
		for(int i = 0; i < 12; i++) {
			cuadraditoXd(r);
			r.turn(90); r.move(5); r.turn(-90);
		}
		r.move(4); r.turn(-90); r.move(5); r.turn(90);
		//1ra fila
		for(int i = 0; i < 8; i++) {
			cuadraditoXd(r);
			r.move(4);
		}
		r.turn(-90);
		//columna
		for(int i = 0; i < 5; i++) {
			cuadraditoXd(r);
			r.move(5);
		}
		r.turn(-90);
		//2da fila
		for(int i = 0; i < 8; i++) {
			cuadraditoXd(r);
			r.move(5);
		}
		r.penUp(); r.turn(90); r.move(5); r.turn(90); r.move(16); r.turn(-90); r.penDown();
		//colita xd
		for(int i = 0; i < 5; i++) {
			cuadraditoXd(r);
			r.move(5); r.turn(90); r.move(4); r.turn(-90);
		}
		//pisicionar 
		r.penUp(); r.turn(90); r.move(10); r.penDown(); 
	}
	public static void letraG(Turtle g, int r, int o, int b) {
        Color color = new Color(r, o, b);
		g.bodyColor(color);
		g.penSize(9); g.hide();
		g.speed(4000);
		g.penUp(); g.move(40); g.turn(90); g.move(30);
		g.turn(90); g.move(24); g.turn(180); g.penDown();
		// colita
		for(int i = 0; i < 6; i++) {
			cuadraditoXd(g);
			g.move(4);
		}
		g.turn(180); g.move(4); g.turn(90);
		for(int i = 0; i < 6; i++) {
			cuadraditoXd(g);
			g.move(5);
		}
		g.penUp(); g.turn(-180); g.move(5); g.turn(90); g.penDown();
		//fila de la base
		for(int i = 0; i < 8; i++) {
			cuadraditoXd(g);
			g.move(4);
		}
		g.turn(-90);
		// columna vertebral
		for(int i = 0; i < 10; i++) {
			cuadraditoXd(g);
			g.move(5);
		}
		g.turn(-90);
		for(int i =  0; i < 9; i++) {
			cuadraditoXd(g);
			g.move(4);
		}
	}

    public static void cuadraditoXd(Turtle pablito) {
    	for(int i = 0; i < 2; i++) {
    		pablito.move(4); pablito.turn(90);
    		pablito.move(5); pablito.turn(90);
    	}
    }
}