package launcher.avaj.provider;

import launcher.avaj.aircraft.*;

public final class WeatherProvider {
  private WeatherProvider() {}

  public static WeatherProvider getProvider() {
    if (weatherProvider == null) {
      weatherProvider = new WeatherProvider();
    }
    
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    Integer i = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
    i = i < 0 ? -i : i;
    return weather[i % 4];
  }

  private static WeatherProvider weatherProvider = null;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
}