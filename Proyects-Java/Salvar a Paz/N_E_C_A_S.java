import java.awt.Color;
import galapagos.*;
class N_E_C_A_S {
    //El ancho del pincel, es 3 a 2 con las unidades
    public static void main(String[] args) {
        TurtleDrawingWindow playground = new TurtleDrawingWindow();
        playground.setOrigin(200, 100);
        playground.setSize(1000, 500);
        
        playground.setVisible(true);

        Color cuerpo = new Color(1, 1, 1);
        Turtle donatelo = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        playground.add(donatelo);

        donatelo.penSize(15);
        donatelo.speed(500);
        donatelo.bodyColor(cuerpo);
        donatelo.penUp();
        donatelo.jumpTo(5, 5);
        donatelo.move(50);
        donatelo.penDown();
        char_C(donatelo, 0, 200, 0);
        char_A(donatelo, 100, 0, 50);
        char_N(donatelo, 220, 10, 50);
        char_E(donatelo, 0, 100, 200);
        char_S(donatelo, 0, 150, 150);
        char_Y(donatelo, 100, 0, 0);
        
    }
    public static void char_A(Turtle donatelo, int r, int g, int b) {
        //Color pincel
        Color color = new Color(r, g, b);
        donatelo.penColor(color);
        donatelo.hide();
        donatelo.penSize(17);
        //primer palo
        donatelo.turn(90);
        donatelo.move(30);
        // Cabeza
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(-90);
        donatelo.move(10);
        donatelo.penDown();
        donatelo.move(10);
        //Segunda pata
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(-90);
        donatelo.move(10);
        donatelo.penDown();
        donatelo.move(30);
        //traslado para Puente
        donatelo.penUp();
        
        donatelo.turn(-90);       
        donatelo.move(30);

        donatelo.turn(-90);       
        donatelo.move(10);

        donatelo.turn(-90);

        //Puente
        donatelo.penDown();
        donatelo.move(30);

        //Moverse a siguiente origen
        donatelo.penUp();
        donatelo.turn(-90);
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(20);
        donatelo.penDown();

    }
    public static void char_N (Turtle donatelo, int r, int g, int b) {
        Color color = new Color(r, g, b);
        donatelo.hide();
        donatelo.penColor(color);
        donatelo.penSize(17);
        //primer palo
        donatelo.turn(90);
        donatelo.move(40);

        // traslado

        donatelo.penUp();
        donatelo.turn(-180);
        donatelo.move(10);
        donatelo.turn(90);

        //Primer cuadrado
        donatelo.penDown();
        donatelo.move(10);
        //traslación 
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(-90);
        donatelo.move(10);
        donatelo.turn(90);

        //segundo cuadrado
        donatelo.penDown();
        donatelo.move(10);

        //Segundo palo

        donatelo.turn(90);
        donatelo.move(20);
        donatelo.turn(180);
        donatelo.move(40);

        //traslado a nueva letra

        donatelo.penUp();
        donatelo.turn(90);
        donatelo.move(20);
        donatelo.penDown();

    }
    public static void char_E (Turtle donatelo, int r, int g, int b) {
        Color color = new Color(r, g, b);
        donatelo.penColor(color);
        donatelo.hide();
        donatelo.penSize(17);
        //primer palo
        donatelo.turn(90);
        donatelo.move(40);
        //primer sombrero y traslado
        donatelo.turn(-90);
        donatelo.move(30);
        donatelo.turn(180);
        donatelo.move(30);
        donatelo.turn(90);
        donatelo.move(20);
        donatelo.turn(90);
        
        //Segundo sombrero y traslado
        donatelo.move(20);
        donatelo.turn(180);
        donatelo.move(20);
        donatelo.turn(90);
        donatelo.move(20);
        donatelo.turn(90);

        //base
        donatelo.move(30);
        //traslado a nueva letra
        donatelo.penUp();
        donatelo.move(20);
        donatelo.penDown();
    }
    public static void char_C (Turtle donatelo, int r, int g, int b) {
        Color color = new Color(r, g, b);
        donatelo.penColor(color);
        donatelo.hide();
        donatelo.penSize(19);
        //traslado
        donatelo.penUp();
        donatelo.move(30);
        donatelo.turn(90);
        donatelo.move(30);

        //primer cacho
        donatelo.penDown();
        donatelo.move(2);
        //traslado
        donatelo.penUp();
        donatelo.move(8);
        donatelo.turn(90);
        donatelo.move(10);
        //techo
        donatelo.penDown();
        donatelo.move(10);
        //traslado
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(10);
        //Lado izquierdo
        donatelo.penDown();
        donatelo.move(20);
        //traslado
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(10);
        //base
        donatelo.penDown();
        donatelo.move(10);
        // traslado
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(8);
        //ultimo diente
        donatelo.penDown();
        donatelo.move(2);
        //traslado nueva letra
        donatelo.penUp();
        donatelo.turn(180);
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(20);
        donatelo.penDown();
    }
    public static void char_S (Turtle donatelo, int r, int g, int b) { 
        Color color = new Color(r, g, b);
        donatelo.penColor(color);
        donatelo.hide();
        donatelo.penSize(17);
        //base:
        donatelo.move(20);
        //traslado
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(8);
        
        // cuadrado solo:
        donatelo.penDown();
        donatelo.move(2);

        // traslado
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(90);
        donatelo.move(10);

        //base media
        donatelo.penDown();
        donatelo.move(10);
        //traslado:
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(-90);
        donatelo.move(8);

        //segundo cuadrado
        donatelo.penDown();
        donatelo.move(2);
        //traslado
        donatelo.penUp();
        donatelo.move(10);
        donatelo.turn(-90);
        donatelo.move(10);

        //base superior
        donatelo.penDown();
        donatelo.move(20);
        //traslado a sitio base
        donatelo.penUp();
        donatelo.move(20);
        donatelo.turn(-90);
        donatelo.move(40);
        donatelo.turn(90);
        donatelo.penDown();

    }

        public static void char_Y (Turtle donatelo, int r, int g, int b) { 
            Color color = new Color(r, g, b);
            donatelo.penColor(color);
            
            // Desplazarse para la colita
            donatelo.hide();
            donatelo.penSize(17);
            donatelo.penUp();
            donatelo.move(10);
    
            //Colita base
            donatelo.penDown();
            donatelo.move(10);
    
            //Despalzarse para el cuerpo
    
            donatelo.penUp();
            donatelo.move(10);
            donatelo.turn(90);
            donatelo.move(10);
            donatelo.penDown();
    
            //cuerpo
    
            donatelo.move(30);
    
            //Desplazamaniento a cabeza
    
            donatelo.penUp();
            donatelo.turn(90);
            donatelo.move(30);
            donatelo.turn(90);
            donatelo.penDown();
    
            //Cabeza
            donatelo.move(10);
    
            //desplazamiento a medio
            donatelo.penUp();
            donatelo.move(10);
            donatelo.turn(90);
            donatelo.move(10);
            donatelo.penDown();
    
            //Cuerpo
    
            donatelo.move(20);
    
            //desplazamiento a nueva base
    
            donatelo.penUp();
            donatelo.turn(-90);
            donatelo.move(20);
            donatelo.turn(90);
            donatelo.move(20);
            donatelo.penDown();
    
    
    }
}