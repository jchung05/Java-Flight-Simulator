package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class Balloon extends Aircraft implements Flyable {
  Balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {

  }

  @Override
  public void registerTower(WeatherTower weatherTower) {

  }

  private WeatherTower weatherTower;
}