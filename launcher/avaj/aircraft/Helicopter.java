package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class Helicopter extends Aircraft implements Flyable {
  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 10,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() + 2
        );
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 5,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight()
        );
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 1,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight()
        );
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 12
        );
    //TODO
    //Make a printout when height <= 0
    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
    //TODO
    //Make a printout for registration to tower
  }

  private WeatherTower weatherTower;
}