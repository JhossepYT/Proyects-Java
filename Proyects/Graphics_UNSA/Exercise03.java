import graphics.*;
class Exercise03{
    public static void main(String[] args){

        // Filas del tablero de chess //
        Picture casillaBlanca = Picture.casilleroBlanco();
        Picture fila1 = casillaBlanca.alLado(casillaBlanca.invertir()).repetirH(4);
        Picture fila2 = fila1.invertir();
        Picture casillas = fila2.encima(fila1).repetirV(2);
        Graphics g = new Graphics(casillas);
        g.print();
        
    }
}