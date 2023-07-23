import episunsa.*;
class ParaElRecuerdo{
    public static void main(String[] args){
        SimpleImage img = new SimpleImage("prueba.jpg");
        SimpleImage back = new SimpleImage("background.jpg");

        for(Pixel p : img){
            int avg = ((p.getRed() + p.getGreen() + p.getBlue()) / 3); 
            avg = (int)(avg * 1.5);
            if(p.getGreen() > avg){
                int x = p.getX();
                int y = p.getY();
                Pixel pixel2 = back.getPixel(x, y);
                p.setRed(pixel2.getRed());
                p.setGreen(pixel2.getGreen());
                p.setBlue(pixel2.getBlue());
            }
        }
        img.print();
    }
}