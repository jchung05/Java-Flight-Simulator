package launcher.avaj.aircraft;

import launcher.avaj.exceptions.*;

public abstract class AircraftFactory {
  private AircraftFactory() {}

  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws BadAircraftException, MisspelledBalloonException
  {
    Coordinates coordinates = null;
    try {
      coordinates = new Coordinates(longitude, latitude, height);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e);
      System.exit(0);
    }

    try {
      switch(type) {
        case "Baloon":
          throw new MisspelledBalloonException("You spelled balloon wrong bruh");
        case "Balloon":
          return new Balloon(name, coordinates);
        case "Helicopter":
          return new Helicopter(name, coordinates);
        case "JetPlane":
          return new JetPlane(name, coordinates);
        default:
          throw new BadAircraftException("Bad aircraft type");
      }
    } catch (Exception e) {
      System.out.println(e);
    } return null;
  }
}