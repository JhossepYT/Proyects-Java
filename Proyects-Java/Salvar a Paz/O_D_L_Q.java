import galapagos.*;
import java.awt.*;
public class O_D_L_Q{
    public static void cuadrado(Turtle t, int x , int y){
        // Este método solo dibuja cuadrados, sirve como base para el resto//
        int i = 0;
        while(i <= 10){
            t.jumpTo(x, y);
            t.move(2);
            y++;
            i++;
        }
    }
    public static void letraO(Turtle t, int x , int y, int r, int g, int b){
        // El (x, y) son las coordenadas de inicio de la letra, inicia en la esquina inferior izquierda//
        Color color = new Color(r, g, b);
        t.penColor(color);
        t.speed(800);
        t.penSize(14);
        t.jumpTo(x, y);
        int x1 = x;
        int y1 = y + 10;
        for(int i = 0; i < 3; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
        y1 = y;
        x1 = x + 10;
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 40;
        }
        y1 = y;
        x1 = x + 20;
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 40;
        }
        y1 = y + 10;
        x1 = x + 30;
        for(int i = 0; i < 3; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
    }
    public static void main(String [] args){
        Turtle t = new Turtle();
        t.speed(300);
        Color color = new Color(0, 0, 0);
        t.hide();
        t.penColor(color);
        int x = 0;
        int y = 0;
        letraO(t, x, y, 0,0,0);
        x += 50;
        letraD(t, x, y,60, 200, 255);
        x += 50;
        letraL(t, x, y,60, 200, 255);
        x += 50;
        letraQ(t, x, y,60, 200, 255);
    }
    public static void lienzo(TurtleDrawingWindow pintura){
        pintura.setGrid(false);
        pintura.setVisible(true);
        pintura.setOrigin(0, 0);

    }
    public static void letraD(Turtle t, int x , int y, int r, int g, int b){
        // El (x, y) son las coordenadas de inicio de la letra, inicia en la esquina inferior izquierda//
        Color color = new Color(r, g, b);
        t.penColor(color);
        t.jumpTo(x, y);
        int x1 = x;
        int y1 = y;
        for(int i = 0; i < 5 ; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
        t.jumpTo(x + 10, y);
        y1 = y;
        x1 = x + 10;
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 40;
        }
        t.jumpTo(x + 20, y);
        y1 = y;
        x1 = x + 20;
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 40;
        }
        t.jumpTo(x + 30, y + 10);
        y1 = y + 10;
        x1 = x + 30;
        for(int i = 0; i < 3; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
    }
        public static void letraL(Turtle t, int x , int y, int r, int g, int b){
        // El (x, y) son las coordenadas de inicio de la letra, inicia en la esquina inferior izquierda//
        Color color = new Color(r, g, b);
        t.penColor(color);
        t.jumpTo(x, y);
        int x1 = x;
        int y1 = y;
        for(int i = 0; i < 5 ; i++){
            cuadrado(t, x1, y1);
            y1+= 8;
        }
        t.jumpTo(x + 10, y);
        y1 = y;
        x1 = x + 10;
        for(int i = 0; i < 1; i++){
            cuadrado(t, x1, y1);
            y1+= 6;
        }
        t.jumpTo(x + 20, y);
        y1 = y;
        x1 = x + 20;
        for(int i = 0; i < 1; i++){
            cuadrado(t, x1, y1);
            y1+= 6;
        }
        t.jumpTo(x + 30, y + 10);
        y1 = y;
        x1 = x + 30;
        for(int i = 0; i < 1; i++){
            cuadrado(t, x1, y1);
            y1+= 6;
        }
    }
    public static void letraQ(Turtle t, int x , int y,int r, int g, int b){
        // El (x, y) son las coordenadas de inicio de la letra, inicia en la esquina inferior izquierda//
        Color color = new Color(r, g, b);
        t.penColor(color);
        t.jumpTo(x, y);
        int x1 = x;
        int y1 = y + 10;
        for(int i = 0; i < 3; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
        t.jumpTo(x + 10, y);
        y1 = y;
        x1 = x + 10;
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 40;
        }
        t.jumpTo(x + 20, y);
        y1 = y + 10;
        x1 = x + 20;
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 30;
        }
        t.jumpTo(x + 30, y + 10);
        y1 = y;
        x1 = x + 30;
        for(int i = 0; i < 1; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
        y1+= 10; 
        for(int i = 0; i < 2; i++){
            cuadrado(t, x1, y1);
            y1+= 10;
        }
    }
}
