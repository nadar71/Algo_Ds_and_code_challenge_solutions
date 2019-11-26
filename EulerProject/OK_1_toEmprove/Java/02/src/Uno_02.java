import java.util.*;
import java.io.*;

import timing.*;

public class Uno_02 extends Thread{

  static int sum=0;

  public void run(){
   for(int i=1;i<1000;i++)
   	if (((i%3)==0) || ((i%5)==0) ) sum += i;
   System.out.println("Result : " + sum);
   }
  
  
  public static void main(String args[]){
  	Chronometer chron = new Chronometer();
  	Uno_02 problem = new Uno_02();
  	
  	chron.run(problem);
  	System.out.println(chron.getElapsedTime());
  	
  	}
  
  
  
}