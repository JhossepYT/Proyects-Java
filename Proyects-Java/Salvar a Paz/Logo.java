import episunsa.*;
import galapagos.*;
import java.awt.*;

/*
 * Este código pinta una imagen con una sola tortuga haciendo espirales rectangulares, aún 
 * tiene fallas con imágenes de muchos pixeles ya que no termina de pintar completamente bien
 * el centro de la imagen.
*/

public class Logo {
    public static void main(String[] args) {

        

        TurtleDrawingWindow lienzo = crearLienzo(Color.black, true, 1.5);

        Turtle leoDaTurtle = new Turtle(Turtle.NO_DEFAULT_WINDOW);
        
        pintarImagen(lienzo, leoDaTurtle, 4, 200, -200, 100);

    }


    /*
     * Pintar la imagen deseada
     * @ param TurtleDrawingWindow lienzo: Ventana donde se desea pintar
     * @ param Turtle leoDaTurtle: Tortuga con la que se pintará la imagen
     * @ param int speed: Velocidad de la tortuga
     * @ param SimpleImage img: Imagen que se pintará
     * @ param double posX: Posición en el eje de las abscisas donde debe aparecer la tortuga
     * @ param double posY: Posisión en el eje de las ordenadas donde debe aparecer la tortuga
     */
    public static void pintarImagen(TurtleDrawingWindow lienzo, Turtle leoDaTurtle, int penSize, int speed, double posX, double posY){
        SimpleImage img = new SimpleImage("logo.jpg");
        lienzo.add(leoDaTurtle);
        leoDaTurtle.penSize(penSize);
        leoDaTurtle.speed(speed);
        //escondemos la tortuga
        leoDaTurtle.hide();
        leoDaTurtle.jumpTo(posX, posY);
        int alto = img.getHeight() - 1;
        int ancho = img.getWidth() - 1;
        int control = Math.min(alto, ancho);
        int row = 0;
        int column = 0;
        //primero de pinta la fila inferior de la imagen
        pintarfila(leoDaTurtle, img,0 , ancho, 0, false);
        leoDaTurtle.turn(90);
        for(int mypaints = 0; mypaints < control / 2 ; mypaints++){
            //llamamos "pintada" al pintar una columna y una fila, ambas tienen la misma 
            //variación en la pintada, por ello se incrementen 1 al final tanto fila como columna
            if(mypaints % 2 == 0){
                //pinta columna hacia arriba
                pintarColumna(leoDaTurtle, img, row, alto - column, ancho - row, true);//esta bien
                leoDaTurtle.turn(90);
                //pinta fila hacia la izquierda
                pintarfila(leoDaTurtle, img, row, ancho - row, column, true);
                leoDaTurtle.turn(90);
            }else{
                //pinta columna hacia abajo
                pintarColumna(leoDaTurtle, img, column, alto - column, row, false);//esta bien
                leoDaTurtle.turn(90);
                //pinta fila hacia la derecha
                pintarfila(leoDaTurtle, img, row, ancho - row, alto - column, false);
                leoDaTurtle.turn(90);
            }
            row++;
            column++;
        }
    }

    /*
     * Configurar lienzo a las medidas deseadas
     * @ param Color backRound: Define el color del fondo 
     * @ param boolean cuadricula: Definir si se desea cuadriculas en el canvas
     * @ param double zoom: Literalmente como un zoom. Se debe tener en cuenta que el valor
     *                      predeterminado es 1.5, donde aparecen 4.5 cuadriculas a ambos 
     *                      lados, mientras menor sea el numero, se alejará más; si es mayor,
     *                      se acercará más. Además, cada cuadrícula ocupa 25 pixeles de imagen
     *                      aprox.
     * Nota: utilizar solo si es necesario
     */

    public static TurtleDrawingWindow crearLienzo(Color backRound, boolean cuadricula, double zoom){
        TurtleDrawingWindow lienzo = new TurtleDrawingWindow();
        lienzo.setResizable(true);
        lienzo.setTitle("Turtle-Vinci");
        //lienzo.setColor(backRound);
        lienzo.setVisible(true);
        lienzo.setGrid(cuadricula);
        lienzo.setUnit(zoom);
        return lienzo;
    }

    /*
     * Pintar una fila deseada de pixeles
     * @ param Turtle turtleVinci: Tortuga con la cual se pintará
     * @ param SimpleImage img: Imagen de donde se extrae los pixeles
     * @ param int initColumn: Valor por la izquierda de donde se quiere empezar a extraer
     *                    los pixeles
     * @ param int finalColumn: Valor por la derecha de donde se termina de extraer los pixeles
     * @ param int row: La fila que se desea pintar
     * @ param boolean alreves: Decimos que la imagen está alreves si es necesario empezar a
     *                          extraer sus pixeles por derecha
     */

    public static void pintarfila(Turtle turtleVinci, SimpleImage img, int initColumn, int finalColumn, int row, boolean alreves){
        if(!alreves)
            for(int x = initColumn; x < finalColumn; x++){
                Pixel px = img.getPixel(x, row);
                Color color = new Color(px.getRed(), px.getGreen(), px.getBlue());
                turtleVinci.penColor(color);
                turtleVinci.move(2);
            }
        else
            for(int x = finalColumn; x > initColumn; x--){
                Pixel px = img.getPixel(x, row);
                Color color = new Color(px.getRed(), px.getGreen(), px.getBlue());
                turtleVinci.penColor(color);
                turtleVinci.move(2);
            }
    }

    /*
     * Pintar una columna deseada de pixeles
     * @ param Turtle turtleVinci: Tortuga con la cual se pintará
     * @ param SimpleImage img: Imagen de donde se extrae los pixeles
     * @ param int initRow: Valor por la parte superior de donde se quiere empezar a extraer
     *                    los pixeles
     * @ param int finalRow: Valor por la parte inferior de donde se termina de extraer los 
     *                      pixeles
     * @ param int column: Columna que se desea pintar
     * @ param boolean alreves: Decimos que la imagen está alreves si es necesario empezar a
     *                          extraer sus pixeles por abajo
     */

    public static void pintarColumna(Turtle turtleVinci, SimpleImage img, int initRow, int finalRow, int column, boolean alreves) {
        if(!alreves)
            for(int y = initRow; y < finalRow; y++){
                Pixel px = img.getPixel(column, y);
                Color color = new Color(px.getRed(), px.getGreen(), px.getBlue());
                turtleVinci.penColor(color);
                turtleVinci.move(2);
            }
        else
            for(int y = finalRow; y > initRow; y--){
                Pixel px = img.getPixel(column, y);
                Color color = new Color(px.getRed(), px.getGreen(), px.getBlue());
                turtleVinci.penColor(color);
                turtleVinci.move(2);
            }
    }
}	       
