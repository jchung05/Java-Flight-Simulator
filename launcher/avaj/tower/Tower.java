package launcher.avaj.tower;

//TODO
abstract class Tower {
  public void register(Flyable flyable) {

  }

  public void unregister(Flyable flyable) {

  }

  protected void conditionsChanged() {

  }

  private Flyable[] observers;
}