import java.util.HashMap;

public class Main{

  public static void findRepeating(int[] arr){
    HashMap<Integer,Integer> ht = new HashMap<>();

    for(int i=0;i<arr.length;i++) {
      if (ht.get(arr[i]) != null) System.out.println("Number which repeats : "+arr[i]); 
      else ht.put(arr[i],1);
    }
      
  }

  public static void main(String args[]){    
    int[] data ={8,9,12,6,0,6,7,1,2,3,8,10,4,4,2,2,4,10,12,56};     
    findRepeating(data);    
  }
}