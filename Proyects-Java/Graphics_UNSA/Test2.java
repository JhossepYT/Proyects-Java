import graphics.*;
class Test2{
public static void main(String[] args){
    Picture c = Picture.casilleroBlanco();
    Picture tablero = c.alLado(c.invertir()).repetirH(4).encima(c.invertir().alLado(c).repetirH(4)).repetirV(4);
    Graphics g = new Graphics(tablero);
    g.print();
}

public static Picture generarFila(int n){
    Picture cuadro = null;
    Picture tablero = null;
    for(int i = 0; i < 8; i++){
        cuadro = Picture.casilleroBlanco();
        if(i % 2 == 0)
        cuadro = cuadro.invertir();
        if(i == n)
        cuadro = Picture.dama().superponer(cuadro);
        if(i == 0){
            tablero = cuadro;
            continue;
        }
        tablero = tablero.alLado(cuadro);
    }
    return tablero;
    }
}