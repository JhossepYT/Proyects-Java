import graphics.*;
class Exercise05_Fix{
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
        Graphics g = new Graphics(pieces.invertir().superponer(tablero));
        g.print();
        
//------------------------------------------------------------------------------------------------------------------------------------//

        //En caso fuera un error, y el color del tablero estuviera al revez, esta seria la solución //

        // Crear las piezas //
        Picture torre1 = Picture.torre();
        Picture caballo1 = Picture.caballo();
        Picture alfil1 = Picture.alfil();
        Picture dama1 = Picture.dama();
        Picture rey1 = Picture.rey();

        // Superponer las fichas negras al tablero //
        Picture pieces1 = torre1.alLado(caballo1).alLado(alfil1).alLado(dama1).alLado(rey1).alLado(alfil1).alLado(caballo1).alLado(torre1);
        Picture casillaBlanca1 = Picture.casilleroBlanco();
        Picture tablero1 = casillaBlanca1.alLado(casillaBlanca1.invertir()).repetirH(4);
        Graphics c = new Graphics(pieces1.invertir().superponer(tablero1));
        c.print();
        
    }
}
