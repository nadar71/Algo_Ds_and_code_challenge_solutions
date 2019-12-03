using System.IO;
using System;

class Program
{
    
    static int sockMerchant(int n, int[] ar) {
        // array storing num of socks for each color  
        // worste case size : n different colors, no pairs 
        // defaukt init with 0
        int[,] spc      = new int[n,2];       // color code / socks num for that color        
        // num of total pairs
        int    result   = 0;
        
        // store socks count per each color
        for(int i=0;i < n;i++){
            Console.WriteLine("ar["+i+"] : "+ar[i]);
            for(int j=0;j < n;j++){
                
                if(spc[j,0] == ar[i]){ 
                    spc[j,1]++;
                    Console.WriteLine("MATCH : spc["+j+",0] : "+spc[j,0]+
                    ";ar["+i+"] : "+ar[i]+"; PAIRS for "+ar[i]+" : "+((int)spc[j,1]/2)+"\n");
                    break;
                    
                }else
                if(spc[j,0] == 0){
                    spc[j,0] = ar[i];
                    spc[j,1]++;
                    Console.WriteLine("NOT MATCH, NEW : spc["+j+",0] : "+spc[j,0]+"; ar["+i+"] : "+ar[i]);
                    break;
                }
                
                Console.WriteLine("SOCKS COUNT :  spc["+j+",1] : "+spc[j,1]+"\n");
                
            }
        }
        
        // total pairs amount
        for(int i=0;i<n-1;i++){
            Console.WriteLine("Colors : "+spc[i,0]+" Socks : "+spc[i,1]);
            result += (int)spc[i,1]/2;
        }
        Console.WriteLine("result : "+result);
        return result;
    }
    
    static void Main()
    { 
        /*
        int n = 10;
        int[] ar = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3}; // pairs : 4
        */
        
        /*
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};  // pairs : 3
        */
        
        int n = 15;
        int[] ar = {6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5};  // pairs : 6
        
        sockMerchant(15, ar);
        
    }
    

}