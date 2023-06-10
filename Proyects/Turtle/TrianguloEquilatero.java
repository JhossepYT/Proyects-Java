import galapagos.*;
class TrianguloEquilatero{
	public static void main(String[] args){
		Turtle t = new Turtle();
		t.speed(500);
		
		int i = 0;
		while(i < 3){
			t.move(50);
			t.turn(120);
			i++;
		}
	}
}