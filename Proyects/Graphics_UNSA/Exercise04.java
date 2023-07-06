import graphics.*;
class Exercise04{
    public static void main(String[] args){
        
        // Crear las piezas //
        Picture torre = Picture.torre();
        Picture caballo = Picture.caballo();
        Picture alfil = Picture.alfil();
        Picture dama = Picture.dama();
        Picture rey = Picture.rey();

        // Superponer las fichas blancas al tablero //
        Picture pieces = torre.alLado(caballo).alLado(alfil).alLado(dama).alLado(rey).alLado(alfil).alLado(caballo).alLado(torre);
        Picture casillaBlanca = Picture.casilleroBlanco();
        Picture tablero = casillaBlanca.invertir().alLado(casillaBlanca).repetirH(4);
        Graphics g = new Graphics(pieces.superponer(tablero));
        g.print();
        
    }
}