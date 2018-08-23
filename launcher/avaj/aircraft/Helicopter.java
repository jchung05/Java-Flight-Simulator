package launcher.avaj.aircraft;

public class Helicopter extends Aircraft implements Flyable {
  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {

  }

  private WeatherTower weatherTower;
}