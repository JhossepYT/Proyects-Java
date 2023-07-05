public class Pato extends Ave {
  private String color;
  private int age;
  private double size;

  public Pato (String sonido, boolean volar, String color, int edad, double tamano) {
    super(sonido, volar);
    this.color = color;
    this.age = edad;
    this.size = tamano;
  }

  public String getColor() {
    return color;
  }
  public int getAge() {
    return age;
  }
  public double getSize() {
    return size;
  }
  public void setColor(String color){
    this.color = color;
  }
  public void setAge(int age){
  this.age = age;
  }
  public void setSize(Double size){
  this.size = size;
  }
}