import galapagos.*;
import java.awt.Color;

public class M_I_T_Z{
    public static void main(String[] args) {
        Turtle t = new Turtle();
        letraT(t,0,0, 0, 0, 0, 0);
    }
    public static void letraI(Turtle t,int x ,int y, int v, int b, int n, int m){
        
        t.penColor(new Color(b, n, m));
        t.hide();
        t.jumpTo(x,y);
        t.speed(v);
        t.penSize(17);
        t.jumpTo(x + 10,y + 45);
        t.move(30);
        t.jumpTo(x + 10,y + 5);
        t.move(30);
        t.jumpTo(x + 24,y + 40);
        t.turn(-90);
        t.move(30);
    }
    public static void letraT(Turtle t,int x ,int y, int v, int b, int n, int m){
        
        t.penColor(new Color(b, n, m));
        t.hide();
        t.jumpTo(x,y);
        t.speed(v);
        t.penSize(20);
        t.jumpTo(x+5,y + 45);
        t.move(40);
        t.jumpTo(x + 22,y + 45);
        t.turn(-90);
        t.move(35);
    }
    public static void letraM(Turtle t,int x ,int y, int v, int b, int n, int m){
        
        t.penColor(new Color(b, n, m));
        t.hide();
        t.jumpTo(x+5,y);
        t.speed(v);
        t.penSize(17);
        t.turn(90);
        t.move(45);
        t.turn(-135);
        t.move(15*Math.sqrt(2));
        t.turn(90);
        t.move(15*Math.sqrt(2));
        t.turn(-135);
        t.move(45);

    }
        public static void letraZ(Turtle t,int x ,int y, int v, int b, int n, int m){
        
        t.penColor(new Color(b, n, m));
        t.hide();
        t.jumpTo(x+32,y+5);
        t.speed(v);
        t.penSize(15);
        t.turn(180);
        t.move(45);
        t.turn(-135);
        t.move(43*Math.sqrt(2));
        t.turn(135);
        t.move(43);

    }
}
