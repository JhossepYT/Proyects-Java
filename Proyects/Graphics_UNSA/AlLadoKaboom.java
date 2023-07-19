import graphics.*;
class AlLadoKaboom {
    public static void main(String[] args) {
        Picture caballo = Picture.caballo();
        Picture whiteCell = Picture.casilleroBlanco();
        Picture peon = Picture.peon();
        //Graphics p = new Graphics(Picture.alfil().encima(blackCell).alLado(Picture.peon().superponer(whiteCell).encima(blackCell)).repetirV(4).repetirH(4));
        //Graphics display = new Graphics(Picture.alfil().encima(blackCell).alLado(Picture.peon().superponer(whiteCell)).repetirV(4).repetirH(4));
        Graphics a = new Graphics(caballo.alLado(peon).encima(whiteCell).repetirH(4));
        a.print();
    }
}
