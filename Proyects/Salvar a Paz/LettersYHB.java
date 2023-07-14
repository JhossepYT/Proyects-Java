import galapagos.*;
import java.awt.*;

public class LettersYHB{
    public static final int[][] letterY = {{0,1}, {1,1}, {2,1}, {2,2}, {3,2}, {4,2}, {4,3}, {4,4}, {5,4}, {6,4}, {7,4}, {8,4}, {9,4}, {4,5}, {2,6}
                                            , {3,6}, {4,6}, {0,7}, {1,7}, {2,7}, {3,7}};
    public static final int[][] shadeY = {};
    public static final int[][] letterH = {};
    public static final int[][] shadeH = {};
    public static final int[][] letterB = {};
    public static final int[][] shadeB = {};

    
    public static void workSlv(Turtle tortuga, double jumpx, double jumpy, int[][] src, int grosor){
        tortuga.heading(0.0);
        tortuga.penSize(grosor);
        for(int i = 0; i< 10; i++){
            tortuga.jumpTo(jumpy, jumpx - 5*i);
            for(int e = 0; e<8; e++){
                Color colorg = Color.black;
                tortuga.penColor(colorg);
                if(on(i, e, src)){
                    tortuga.penDown();
                }else{
                    tortuga.penUp();
                }
                tortuga.move(5);
            }
        }
    }
    public static boolean on(int posx, int posy, int[][] src){
        for(int[] current : src ){
            if(posx == current[0] && posy == current[1]) return true;
        }
        return false;
    }
}