package launcher.avaj.aircraft;

import launcher.avaj.tower.WeatherTower;

public interface Flyable {
  public void updateConditions();
  public void registerTower(WeatherTower WeatherTower);
}