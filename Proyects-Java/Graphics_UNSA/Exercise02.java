import graphics.*;
class Exercise02{
    public static void main(String[] args){

        // Construir fila invertida //
        Picture casillaBlanca = Picture.casilleroBlanco();
        Picture tablero = casillaBlanca.invertir().alLado(casillaBlanca).repetirH(4);
        Graphics g = new Graphics(tablero);
        g.print();
        
    }
}