public class Pato extends Ave{
  private String color;
  private int age;
  private double size;

  public Pato (String sonido, boolean volar, String color, int edad, double tamano){
    super(sonido, volar);
    this.color = color;
    this.age = edad;
    this.size = tamano;
  }

  public String getColor(){
    return color;
  }
  public int getAge(){
    return age;
  }
  public double getSize(){
    return size;
  }
  public void setColor(String colorsito){
    this.color = colorsito;
  }
  public void setAge(int edad){
  this.age = edad;
  }
  public void setSize(Double tamaño){
  this.size = tamaño;
  }
}