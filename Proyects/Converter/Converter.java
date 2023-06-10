import java.util.*;
class Converter{
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  double centimeters;
  centimeters = sc.nextDouble();
  double inches;
  inches = centimeters / 2.54;
  System.out.println(inches);
  sc.close();
 }
}