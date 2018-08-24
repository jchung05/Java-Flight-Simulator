package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class Balloon extends Aircraft implements Flyable {
  Balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude() + 2,
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() + 4
        );
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 5
        );
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 3
        );
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude(),
          this.coordinates.getHeight() - 15
        );
    }
    //TODO
    //Make a printout when height <= 0
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
    System.out.println("Balloon" + this.name + "(" + this.id + ") registered to the tower.");
  }

  private WeatherTower weatherTower;
}