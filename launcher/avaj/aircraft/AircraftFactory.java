package launcher.avaj.aircraft;

abstract class AircraftFactory {
  private AircraftFactory() {}

  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
  {
    Coordinates coordinates = null;
    try {
      coordinates = new Coordinates(longitude, latitude, height);
    } catch (Exception e) {
      System.out.println("Your coordinates don't exist in this realm");
    }

    try {
      switch(type) {
        case "Balloon":
          return new Balloon(name, coordinates);
        case "Helicopter":
          return new Helicopter(name, coordinates);
        case "JetPlane":
          return new JetPlane(name, coordinates);
        default:
          throw new Exception("Bad aircraft type");
      }
    } catch (Exception e) {
      System.out.println(e);
    } return null;
  }
}