import java.util.HashMap;


public class Test{

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer,Integer> colors = new HashMap<Integer,Integer>();
        int result = 0 ;
        
        for(int color : ar){
            if (colors.containsKey(color)){
                int tmp = colors.get(color);
                System.out.println("colors.get(color) : " +  tmp);
                colors.put(color,++tmp);
            }else{
                colors.put(color,1);
            }
        }

        for(int color : colors.keySet() ){
            System.out.println("Item : " + color + " Count : " + colors.get(color));
            result += (int) colors.get(color)/2;
        }
        
        System.out.println("Result : " +  result);
        return result;

    }
    
    public static void main(String []args){
        //* test case 01
        int n = 10;
        int[] ar = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3}; // pairs : 4
        //*/
        
        /* test case 02
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};  // pairs : 3
        //*/
        
        /*test case 03
        int n = 15;
        int[] ar = {6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5};  // pairs : 6
        */
        sockMerchant(10, ar);
    }
     
     
}