package launcher.avaj.tower;

import java.util.*;
import launcher.avaj.aircraft.*;

abstract class Tower {
  public void register(Flyable flyable) {
    observers.add(flyable);
  }

  public void unregister(Flyable flyable) {
    observers.remove(flyable);
  }

  protected void conditionsChanged() {
    //TODO
  }

  private List<Flyable> observers = new ArrayList<Flyable>();
}