
/*
status : OK
first method:
- calculate the max multiple for each number
- define how much multiple they under this max multiple
- one for cicle to calculate the multiple for each number
*/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  int maxMul3,numOf3,maxMul5,numOf5,maxNum; 
  int totale = 0;
  int w=0, tmp1, tmp2;
  int const term=1000;
  
  maxMul3 = (term - (term % 3)) ; //max multiple space
  if (maxMul3==term) maxMul3 -= 3;
  numOf3 = maxMul3 / 3;
  //printf("\nThe max multiple of 3 is : %i and the numOf3 %i ",maxMul3,numOf3);
  
  maxMul5 = (term - (term % 5)) ; //max multiple space
  if (maxMul5==term) maxMul5 -= 5;
  numOf5 = maxMul5 / 5;
  //printf("\nThe max multiple of 5 is : %i and the numOf3 %i \n",maxMul5,numOf5);
  
  if (numOf5>numOf3) maxNum = numOf5; else maxNum = numOf3;
  //printf("\nDEBUG: maxNum : %i \n",maxNum);
  for(w=1;w<=maxNum;w++){
   if (maxNum==numOf3) {
      tmp1 = 3*w;                 
      totale += tmp1;
      tmp2 = 5*w;
      //printf(" 3 : %i : %i - \n",tmp1, totale);
      if ( (w<=numOf5)&& ((tmp2%3)!= 0 ) ) {totale += tmp2;/*printf(" 5 : %i : %i - \n",tmp2,totale);*/}
     }
   else if (maxNum==numOf5) {
      tmp1 = 5*w;                 
      totale += tmp1;
      tmp2 = 3*w;
      //printf(" 5 : %i : %i - \n",tmp1, totale);
      if ( (w<=numOf3)&& ((tmp2%5)!= 0 )  ) {totale += tmp2;/*printf(" 3 : %i : %i - \n",tmp2,totale);*/}
     }
   
  }
  printf("\nTotale : %i ", totale);
  system("PAUSE");	
  return 0;
}
