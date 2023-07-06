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
        Picture f1 = wB.repetirH(2).alLado(w).alLado(damaB).alLado(wB);
        Picture f2 = bW.alLado(b).alLado(damaW).alLado(bW.repetirH(2));
        Picture f3 = wB.repetirH(3).alLado(damaW).alLado(b);
        Picture f4 = damaB.alLado(wB.repetirH(3)).alLado(w);
        Picture f5 = wB.repetirH(3).alLado(w).alLado(damaB);
        Picture f6 = b.alLado(damaW).alLado(bW.repetirH(3));
        Picture f7 = wB.repetirH(2).alLado(damaW).alLado(bW).alLado(b);
        Picture f8 = bW.alLado(damaB).alLado(wB.repetirH(2)).alLado(w);

        // Organizar para que no quede feo :) //
        Picture SuperiorHalf = f1.encima(f2.encima(f3.encima(f4)));
        Picture LowerHalf = f5.encima(f6.encima(f7.encima(f8)));


        // Imprimir complete chess //
        Graphics solution = new Graphics(SuperiorHalf.encima(LowerHalf));
        solution.print();

    }
}