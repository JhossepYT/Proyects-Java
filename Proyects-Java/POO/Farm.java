import java.util.*;
class Farm{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Pato donald = new Pato("cuack", false, "black", 300, 0.5);

    donald.setColor(sc.nextLine());
    donald.setAge(sc.nextInt());
    donald.setSize(sc.nextDouble());
    System.out.println("Color " + donald.getColor());
    System.out.println("Edad " + donald.getAge());
    System.out.println("Tamaño " + donald.getSize());
    sc.close();
  }
}
