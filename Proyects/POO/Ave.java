public class Ave {
  // PROPIEDADES
  String sound;
  boolean fly;

  //    CONSTRUCTOR
  public Ave (String sonido, boolean volar) {
    this.sound = sonido;
    this.fly = volar;
  }

  // METODOS
  public static void Picar() {
    System.out.println("Picó");
  }

  public boolean getFly() {
    return fly;
  }
  public String getSound() {
    return sound;
  }
}
