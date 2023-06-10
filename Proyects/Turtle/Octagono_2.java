import galapagos.*;
class Octagono_2{
    public static void main(String[] args){
        Turtle t = new Turtle();
        t.speed(500);
        
        int i = 0;
        while(i < 8){
            t.move(50);
            t.turn(45);
            i++;
        }
    }
}