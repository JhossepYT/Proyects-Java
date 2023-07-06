import graphics.*;
class Exercise06{
    public static void main(String[] args){
        // Filas del tablero de chess //
        Picture casillaBlanca = Picture.casilleroBlanco();
        Picture fila = casillaBlanca.alLado(casillaBlanca.invertir()).repetirH(4);
        Picture filaInvertida = fila.invertir();
        Picture tablero = fila.encima(filaInvertida).repetirV(2);

        // Crear las piezas //
        Picture torre = Picture.torre();
        Picture caballo = Picture.caballo();
        Picture alfil = Picture.alfil();
        Picture dama = Picture.dama();
        Picture rey = Picture.rey();

        // Superponer las fichas blancas al tablero //
        Picture pieces = torre.alLado(caballo).alLado(alfil).alLado(dama).alLado(rey).alLado(alfil).alLado(caballo).alLado(torre);
        Picture whiteline = pieces.superponer(fila);
        Picture blackline = pieces.superponer(filaInvertida);


        // Fila de Peones //
        Picture peones = Picture.peon().repetirH(8);
        Picture peonesInvertidos = peones.invertir();
        Picture filaPeones = peones.superponer(tablero.invertir());
        Picture filaPeonesInvertidos = peonesInvertidos.superponer(tablero);

        // Imprimir complete chess //
        Graphics chess = new Graphics(whiteline.encima(filaPeones).encima(tablero).encima(filaPeonesInvertidos).encima(blackline));
        chess.print();

    }
}