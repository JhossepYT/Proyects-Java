import graphics.*;
class Exercise01{
    public static void main(String[] args){

        // Construir fila //
        Picture casillaBlanca = Picture.casilleroBlanco();
        Picture tablero = casillaBlanca.alLado(casillaBlanca.invertir()).repetirH(4);
        Graphics g = new Graphics(tablero);
        g.print();
        
    }
}