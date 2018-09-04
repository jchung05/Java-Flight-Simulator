package launcher.avaj.aircraft;

import launcher.avaj.tower.*;
import launcher.avaj.logger.*;

public class Balloon extends Aircraft implements Flyable {
  Balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    String identifier = "Balloon#" + this.name + "(" + this.id + ")";

    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 2,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() + 4
        );
        Logger.getLogger().addLog(identifier + ": Balloon melt");
        break;
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 5
        );
        Logger.getLogger().addLog(identifier + ": Balloon wet");
        break;
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 3
        );
        Logger.getLogger().addLog(identifier + ": Balloon no see");
        break;
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 15
        );
        Logger.getLogger().addLog(identifier + ": Balloon cold");
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
    Logger.getLogger().addLog("Tower says: Balloon#" + this.name + "(" + this.id + ") registered to the tower.");
  }

  private WeatherTower weatherTower;
}