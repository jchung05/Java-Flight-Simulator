package launcher.avaj.aircraft;

public class JetPlane extends Aircraft implements Flyable {
  JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {

  }

  private WeatherTower weatherTower;
}