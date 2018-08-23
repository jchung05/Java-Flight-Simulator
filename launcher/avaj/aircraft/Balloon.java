package launcher.avaj.aircraft;

public class Balloon extends Aircraft implements Flyable {
  Balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {

  }

  private WeatherTower weatherTower;
}