package launcher.avaj.aircraft;

import launcher.avaj.tower.*;
import launcher.avaj.logger.*;

public class Helicopter extends Aircraft implements Flyable {
  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    String identifier = "Helicopter#" + this.name + "(" + this.id + ")";

    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 10,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() + 2
        );
        Logger.getLogger().addLog(identifier + ": This is hot.");
        break;
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 5,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight()
        );
        Logger.getLogger().addLog(identifier + ": It sure is wet outside!");
        break;
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 1,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight()
        );
        Logger.getLogger().addLog(identifier + ": It's hot enough to cook an egg on the dash right now!");
        break;
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 12
        );
        Logger.getLogger().addLog(identifier + ": My rotor is going to freeze!");
        break;
    }

    if (this.coordinates.getHeight() <= 0)
    {
      Logger.getLogger().addLog(identifier + " landing.");
      this.weatherTower.unregister(this);
      Logger.getLogger().addLog("Tower says: " + identifier + " unregistered from the weather tower.");
    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
    Logger.getLogger().addLog("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
  }

  private WeatherTower weatherTower;
}