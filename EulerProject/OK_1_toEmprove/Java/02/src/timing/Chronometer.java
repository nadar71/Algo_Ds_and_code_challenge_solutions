package timing;


import java.util.*;

public class Chronometer{
  Calendar startTime;
  Calendar endTime;
  
  
  public void run(Thread thread) {
    // registra l'ora di sistema all'inizio dell'esecuzione
    startTime = Calendar.getInstance();
    // manda in esecuzione il thread passato come parametro, quello di cui si vuole quanto impiega
    // ad essere eseguito
    thread.start();
    try {
      // attende la fine dell'esecuzione
      thread.join();
    }
    catch (InterruptedException e) {}
    // registra l'ora di sistema alla fine dell'esecuzione
    endTime = Calendar.getInstance();
    
    // stampa il tempo trascorso
    System.out.println("\nFINITO");
    
    //System.out.println(this.getElapsedTime());
  }
  
  
  // calcola il tempo trascorso e restituisce
  // una stringa descrittiva
  public String getElapsedTime() {
    
    int minutes = endTime.get(Calendar.MINUTE)- startTime.get(Calendar.MINUTE);
    
    int seconds = endTime.get(Calendar.SECOND)- startTime.get(Calendar.SECOND);
    
    if (seconds < 0) {
      minutes--;
      seconds += 60;
    }
    
    int milliseconds = endTime.get(Calendar.MILLISECOND)- startTime.get(Calendar.MILLISECOND);
    
    if (milliseconds < 0) {
      seconds--;
      milliseconds += 1000;
    }
    
    return Integer.toString(minutes) + " minuti, " + seconds + " secondi, " + milliseconds + " millisecondi";
  }
 
  

}