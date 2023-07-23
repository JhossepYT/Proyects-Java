import graphics.*;
class Test{
    public static void main(String[] args) {
        Picture f1 = Picture.torre().alLado(Picture.caballo().alLado(Picture.alfil().alLado(Picture.dama().alLado(Picture.rey().alLado(Picture.alfil().alLado(Picture.caballo().alLado(Picture.torre())))))));
        Picture f1_n = f1.invertir(); 
        Picture p = Picture.peon().repetirH(8);
        Picture p_n = p.invertir();
        Picture f = Picture.casilleroBlanco().alLado(Picture.casilleroBlanco().invertir()).repetirH(4);
        Picture f_r = f.invertir();
        Picture relleno = f_r.encima(f).repetirV(2);
        Picture filasblancas = f1.superponer(f.invertir());
        Picture peonesblancos = p.superponer(f);
        Picture peonesnegros = p_n.superponer(f.invertir());
        Picture filasnegras = f1_n.superponer(f);
        Picture chess = filasblancas.encima(peonesblancos).encima(relleno).encima(peonesnegros).encima(filasnegras);
        Graphics g = new Graphics(chess);
        g.print();
    }
}