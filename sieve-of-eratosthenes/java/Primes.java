public class Primes{
  public static boolean[] sieve(int n){
    int sqn = (int)Math.sqrt(n);
    boolean[] notPrimes = new boolean[n]; //Take advantage of javas default values
    notPrimes[0] = true;
    for(int p = 2; p<sqn; p++){
      if(!notPrimes[p - 1]){
        for(int k = 2*p; k<=n; k += p){
          notPrimes[k - 1] = true;
        }
      }
    }
    return notPrimes;
  }

  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    boolean[] notPrimes = sieve(n);
    for(int i = 0; i < notPrimes.length; i++){
      if(!notPrimes[i]){
        System.out.println(i + 1);
      }
    }
  }
}
