package launcher.avaj.aircraft;

import launcher.avaj.tower.*;

public class JetPlane extends Aircraft implements Flyable {
  JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    String identifier = "JetPlane#" + this.name + "(" + this.id + ")";

    System.out.printf("%s", identifier);
    switch(weatherTower.getWeather(this.coordinates)) {
      case "SUN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude() + 10,
          this.coordinates.getHeight() + 2
        );
        System.out.println(": It's hot enough to cook an egg on the dash right now!");
        break;
      case "RAIN":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude() + 5,
          this.coordinates.getHeight()
        );
        System.out.println(": It's raining. Better watch out for lightning.");
        break;
      case "FOG":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude() + 1,
          this.coordinates.getHeight()
        );
        System.out.println(": These high beams aren't really helping, I can't see anything!");
        break;
      case "SNOW":
        this.coordinates = new Coordinates(
          this.coordinates.getLongitude(),
          this.coordinates.getLatitude() - 7,
          this.coordinates.getHeight()
        );
        System.out.println(": OMG! Winter is coming!");
        break;
    }

    if (this.coordinates.getHeight() <= 0)
    {
      System.out.println(identifier + " landing.");
      this.weatherTower.unregister(this);
      System.out.println("Tower says: " + identifier + " unregistered from the weather tower.");
    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
    System.out.println("JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
  }

  private WeatherTower weatherTower;
}