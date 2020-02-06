/*
Time Planner
Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur, returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot that satisfies the duration requirement, return an empty array.

Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Each person’s availability is represented by an array of pairs. Each pair is an epoch array of size two. The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot. The input variable dur is a positive integer that represents the duration of a meeting in seconds. The output is also a pair represented by an epoch array of size two.

In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a person’s availability don’t overlap. Further assume that the slots are sorted by slots’ start time.

Implement an efficient solution and analyze its time and space complexities.

Examples:

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 8
output: [60, 68]

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 12
output: [] # since there is no common slot whose duration is 12
Constraints:

[time limit] 5000ms

[input] array.array.integer slotsA

1 ≤ slotsA.length ≤ 100
slotsA[i].length = 2
[input] array.array.integer slotsB

1 ≤ slotsB.length ≤ 100
slotsB[i].length = 2
[input] integer

[output] array.integer
*/





import java.io.*;
import java.util.*;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    int lenA = slotsA.length;
    int lenB = slotsB.length;
    
    int ia = 0;
    int ib = 0;
    
    int result[] ;
    
    while(ia < lenA && ib < lenB){
      int start = Math.max(slotsA[ia][0], slotsB[ib][0]);
      int end   = Math.min(slotsA[ia][1], slotsB[ib][1]);
      
      if ((start + dur) <= end) {
        result = new int[2];
        result[0] = start;
        result[1] = start+dur;
        return result;
      }
      
      if (slotsA[ia][1] < slotsB[ib][1]) ia++;
      else ib++;
      
    }
    result = new int[0];
    return result;
    
    
  }
  
  public static void printArray(int[] arr){
    if (arr == null || arr.length <=0){
      System.out.println("Empty array");
      return;
    }
    for(int i: arr) System.out.print(" "+i); 
    System.out.println("");
    
  }

  public static void main(String[] args) {
    int[] res    = new int[2]; 
    int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
    int[][] slotsB = {{0, 15}, {60, 70}};
    int dur = 8;
      
    res = meetingPlanner(slotsA, slotsB, dur) ;
    printArray(res);
    
    
    
    int[][] slotsAA = {{10, 50}, {60, 120}, {140, 210}};
    int[][] slotsBB = {{0, 15}, {60, 70}};
    dur = 12;
      
    res = meetingPlanner(slotsAA, slotsBB, dur) ;
    printArray(res);
    
    int[][] slotsC = {{10, 50}, {60, 120}, {140, 210}};
    int[][] slotsD = {{0, 15}, {60, 70}};
    dur = 120;
      
    res = meetingPlanner(slotsC, slotsD, dur) ;
    printArray(res);

  }

}


/*
60 68
Empty array
Empty array
*/


