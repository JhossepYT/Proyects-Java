import graphics.*;
class Exercise07{
    public static void main(String[] args){
        // Recuadros y variantes de recuadros para el tablero //
        Picture w = Picture.casilleroBlanco();
        Picture b = w.invertir();
        Picture wB = w.alLado(b);
        Picture bW = b.alLado(w);

        // Crear dama y sus variantes //
        Picture d = Picture.dama();
        Picture damaW = d.superponer(w);
        Picture damaB = d.superponer(b);

        // Build one solution for Eight Queens puzzle //
        Picture f1 = bW.repetirH(2).alLado(b).alLado(damaW).alLado(bW);
        Picture f2 = wB.alLado(w).alLado(damaB).alLado(wB.repetirH(2));
        Picture f3 = bW.repetirH(3).alLado(damaB).alLado(w);
        Picture f4 = damaW.alLado(bW.repetirH(3)).alLado(b);
        Picture f5 = bW.repetirH(3).alLado(b).alLado(damaW);
        Picture f6 = w.alLado(damaB).alLado(wB.repetirH(3));
        Picture f7 = bW.repetirH(2).alLado(damaB).alLado(wB).alLado(w);
        Picture f8 = wB.alLado(damaW).alLado(bW.repetirH(2)).alLado(b);

        // Organizar para que no quede feo :) //
        Picture SuperiorHalf = f1.encima(f2.encima(f3.encima(f4)));
        Picture LowerHalf = f5.encima(f6.encima(f7.encima(f8)));


        // Imprimir complete chess //
        Graphics solution = new Graphics(SuperiorHalf.encima(LowerHalf));
        solution.print();

    }
}