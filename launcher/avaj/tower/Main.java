package launcher.avaj.tower;

import launcher.avaj.aircraft.*;
import launcher.avaj.exceptions.*;
import launcher.avaj.provider.*;
import launcher.avaj.logger.*;
import java.io.*;
import java.util.*;

class Main {
  private static WeatherTower weatherTower = new WeatherTower();

  public static void main(String[] args) {
    try {
      if (args.length == 1) {
        File file = new File(args[0]);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Integer numSimulations = 0;
        String line = null;

        if ((line = br.readLine()) != null) {
          numSimulations = Integer.valueOf(line);
        }
        //System.out.println(numSimulations);
        while ((line = br.readLine()) != null) {
          String []arr = line.split("\\s+");
          if (arr.length != 5) {
            throw new InvalidArgumentException("Incorrect number of arguments for AircraftFactory");
          }
          Flyable f = AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
          
          if (f != null) {
            f.registerTower(weatherTower);
          }
        }

        for (Integer i = 1; i <= numSimulations; i += 1) {
          Logger.getLogger().addLog("");
          Logger.getLogger().addLog("Day " + i);
          weatherTower.changeWeather();
        }
        Logger.getLogger().writeInFile();
        br.close();
      }
      else {
        throw new InvalidArgumentException("Incorrect number of arguments for Simulator program");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e);
    }
  }
}
/*
import static java.lang.Integer.parseInt;

public class Main {

    public static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws InvalidArgumentException {
        if (args.length != 1) {
              throw new InvalidArgumentException("Incorrect number of arguments for Simulator program");
        }
        try {
            weatherTower = new WeatherTower();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int countSimulation = 0;
            if (line != null && !line.equals("")) {
                try {
                    countSimulation = parseInt(line);
                } catch (NumberFormatException e) {
                    System.err.println("First line must be a number - count of "
                            + "simulation");
                    System.exit(0);
                }
                while ((line = reader.readLine()) != null && !line.equals("")) {
                    String []arr = line.split("\\s+");
                    if (arr.length != 5) {
                      throw new InvalidArgumentException("Incorrect number of arguments for AircraftFactory");
                    }
                    Flyable f = AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
          
                    flyables.add(f);
                }
                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 0; i < countSimulation; i++) {
                    weatherTower.changeWeather();
                }
                if (args.length == 2 && args[1].equals("-p"))
                    Logger.getLogger().loggerShowLog();
                Logger.getLogger().writeInFile();
            } else {
              throw new InvalidArgumentException("Incorrect number of arguments for AircraftFactory");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cant find file " + args[0]);
        } catch (IOException e) {
            System.err.println("Cant find in first line count of simulations");
        } catch (NumberFormatException e) {
            System.err.println("Coordinates must be positive integer number");
        }
    }
}
*/