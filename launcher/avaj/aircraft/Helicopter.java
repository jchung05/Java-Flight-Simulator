package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class Helicopter extends Aircraft implements Flyable {
  Helicopter(String name, Coordinates coordinates) {
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