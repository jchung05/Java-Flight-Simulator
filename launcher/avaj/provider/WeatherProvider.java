package launcher.avaj.provider;

import launcher.avaj.aircraft.*;

public class WeatherProvider {
  private WeatherProvider() {}

  static {
    try {
      weatherProvider = new WeatherProvider();

    } catch(Exception e){
      throw new RuntimeException("Bad singleton instantiation");
    }
  }

  public static WeatherProvider getProvider() {
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    //TODO
    return "";
  }

  private static WeatherProvider weatherProvider;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
}