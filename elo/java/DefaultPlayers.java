public class DefaultPlayers{
  public static Player getBeginnerInstance(String name){
    return new Player(name, 700, 40);
  }

  public static Player getIntermediateInstance(String name){
    return new Player(name, 1000, 40);
  }

  public static Player getAdvancedInstance(String name){
    return new Player(name, 1500, 40);
  }
}
