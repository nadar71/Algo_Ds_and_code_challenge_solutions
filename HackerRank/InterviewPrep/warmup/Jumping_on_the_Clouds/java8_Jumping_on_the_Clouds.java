/*
Emma is playing a new mobile game that starts with consecutively numbered clouds. 
Some of the clouds are thunderheads and others are cumulus. 

She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. 

She must avoid the thunderheads. 

Determine the ** MINIMUM NUMBER OF JUMPS ** it will take Emma to jump from her starting position to the last cloud. 
It is always possible to win the game.


Function Description
--------------------
Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.
jumpingOnClouds has the following parameter(s):
c: an array of binary integers

Input Format
The first line contains an n integer , the total number of clouds. 
The second line contains n space-separated binary c[i] integers describing clouds 
where  0 < c[i] < 0.

Output Format
Print the minimum number of jumps needed to win the game.

Sample Input 0
7
0 0 1 0 0 1 0

Sample Output 0
4



Sample Input 1
6
0 0 0 0 1 0

Sample Output 1
3

SOLUTION SKETCHES.
- start from a single item
- look forward of 2 position : if =1, look forward of 1, check (must be 0 because the    
  game has always a winning state, sot it allows at last one jump), 
  then jump there

cost ?
Optimize ?



*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
      int index = 0;
      int end   = c.length-1;
      int count = 0;
      while ( index < end){
          if ( ( ((index + 2)<= end) && (c[index + 2] == 1) )|| 
               (index > end) ) {
             index++;                
          } else {
            index += 2;
          }
          count++;
      } 
      return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
