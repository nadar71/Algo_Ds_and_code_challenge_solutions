/*
Emprovement : use only odds index
*/



public class SieveOfEratostene{
    boolean[] flags;

    // get all prime number  <= n
    public boolean[] createSieve(int n){
      flags = new boolean[n+1];

      // init flags all to true
      init();
      

      int prime = 2; // starting with this prime
      int sqrt  = (int)Math.sqrt(n);

      while ( prime <= sqrt ) {
        crossOff(prime);          // set to false all the prime multiple
        prime = nextPrime(prime); // go for the next prime
      }  

      return flags;
    }

    // init flags
    public void init(){
      for(int i=2; i< flags.length; i++) flags[i] = true;
    }

    // starting from prime*prime : k < prime is already been checked in previous k*prime checking
    // that is, checks only multiples, submultiples are already been checked.
    public void crossOff(int prime){
      
      for(int i = prime*prime; i < flags.length; i += prime)
         flags[i] = false; 
    }


    public int nextPrime(int prime){
      int next = prime + 1;
      while (next < flags.length  && !flags[next] )
         next++;
      
      return next;
    }


    public void printArray(){
      for(int i=0; i<flags.length; i++)
         if (flags[i]) System.out.print(i+" ");
      System.out.println("");
    }

}

