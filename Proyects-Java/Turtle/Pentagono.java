import galapagos.*;
class Pentagono{
	public static void main(String[] args){
		Turtle t = new Turtle();
        t.speed(500);

        for(int i = 0; i < 5; i++){
            t.move(55);
            t.turn(72);
        }
  }
}