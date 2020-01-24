

public class Main{

  public static void printArray(int[] arr){
    for(int i:arr) System.out.print(i + " "); 
    System.out.println("");

  }
  
  public static void main(String args[]){
    SelectionSort bs = new SelectionSort();
    int[] arr = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};

    printArray(bs.sortingMovMax(arr));
    
    int[] arr2 = {2,3,4,665,3,2,4,6,8,9,3,2,12,13,47,89,18,14};
    printArray(bs.sortingMovMin(arr2));


  }

}

/*
665 89 47 18 14 13 12 9 8 6 4 4 3 3 3 2 2 2                                                                                           
2 2 2 3 3 3 4 4 6 8 9 12 13 14 18 47 89 665 
*/