import galapagos.*;
class Pentagono{
	public static void main(String[] args){
		Turtle t = new Turtle();
        t.speed(500);


        int i = 0;
        while(i < 5){
            t.move(55);
            t.turn(72);
            i++;
        }
  }
}