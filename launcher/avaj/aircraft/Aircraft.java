package launcher.avaj.aircraft;

abstract class Aircraft {
  protected Aircraft(String name, Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
  }

  private long nextId() {

  }
  
  protected long        id;
  protected String      name;
  protected Coordinates coordinates;
  private static long   idCounter;
}