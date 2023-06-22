import episunsa.*;
class TestImage{
    public static void main(String[] args){
        SimpleImage img = new SimpleImage("stop.jpg");
        SimpleImage back = new SimpleImage("leaves.jpg");

        for(Pixel p : img){
            int avg = ((p.getRed() + p.getGreen() + p.getBlue()) / 3); 
            avg = (int)(avg * 1.5);
            if(p.getRed() > avg){
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