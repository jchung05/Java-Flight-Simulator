package launcher.avaj.aircraft;

import launcher.avaj.exceptions.*;

public class Coordinates {
  Coordinates(int longitude, int latitude, int height) {
    try {
      if (longitude < 0 || latitude < 0)
        throw new BadCoordinatesException("Your coordinates don't exist in this realm");
      this.longitude = longitude;
      this.latitude = latitude;
      if (height > 100)
        this.height = 100;
      else if (height < 0)
        this.height = 0;
      else
        this.height = height;
    } catch (BadCoordinatesException e) {
      System.out.println(e);
    }
  }

  public int getLongitude() {
    return this.longitude;
  }

  public int getLatitude() {
    return this.latitude;
  }

  public int getHeight() {
    return this.height;
  }

  private int longitude;
  private int latitude;
  private int height;
}