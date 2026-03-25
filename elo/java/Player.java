public class Player{
  private static int c = 400;
  private int k;

  private String name;
  private double rating;

  public Player(String name, double rating, int k){
    this.name = name;
    this.rating = rating;
    this.k = k;
  }

  public static int getC(){
    return c;
  }

  public static void setC(int newC){
    c = newC;
  }

  public double getRating(){
    return this.rating;
  }
  
  public void setRating(double rating){
    this.rating = rating;
  }
  
  public int getK(){
    return this.k;
  }

  public void setK(int k){
    this.k = k;
  }

  public double predict(Player opponent){
    double exp = (double)(opponent.rating - this.rating)/c;
    return 1/(1 + Math.pow(10, exp));
  }

  /**
   * This takes an expectation and not an opponent
   * This is so we can store the expectation and use it for both results
   * If we used a player instead, we would have to change the elo of one player before the other
   * This would make it impractical to accurately change the second player
   * We could change both players in this method (make it static) instead
   */
  public void result(double outcome, double expectation){
    rating += k * (outcome - expectation);
  }
}
