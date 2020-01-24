class MergeSort{ 
    int[] arr;
    
    public void merge(int left, int mid, int right){
      // get the dimensions of subarrays
      int n1 = mid-left+1;
      int n2 = right-mid;

      // temp arrays      
      int[] L = new int[n1];
      int[] R = new int[n2];

      // copy data of the 2 subarrays int the temp ones
      // TODO : can be reduced to one loop and another loop of length |n1-n2|
      for(int i=0; i<n1; i++) L[i] = arr[left+i];
      for(int i=0; i<n2; i++) R[i] = arr[mid+1+i];


      // init indexes
      int i=0, j=0, k=left;
      while (i<n1 && j<n2){  // ordering in asc order
        if(L[i] <= R[j]){
          arr[k] = L[i];
          i++;
        } else{
          arr[k] = R[j];
          j++;
        }
        k++;
      }

      // insert the remaining items
      while(i<n1){
        arr[k] = L[i];
        i++;
        k++;
      }

      while(j<n2){
        arr[k] = R[j];
        j++;
        k++;
      }
       

    }

    public int[] mergeSort(int[] d) {
         arr = d;
         sort(0,arr.length-1);
         return arr;
    }

    // Sort a [start...end] array
    public void sort(int left,int right){
      if(left<right){
        int mid = (int)(left+right)/2; // find the middle element
        
        System.out.println("left : " + left + " mid : " + mid);
        sort(left,mid);
        
        System.out.println("mid+1 : " + (mid+1) + " right : " + right);        
        sort(mid+1,right);

        System.out.println("left : " + left + "mid  " + mid  + " right : " + right);
        merge(left,mid,right);
      }
        
    }

}