class Mergesort{ 
    int[] arr;
    
    public void merge(int l, int m, int r){
      // get the dimensions of subarrays
      int n1 = m-l+1;
      int n2 = r-m;

      // temp arrays      
      int[] L = new int[n1];
      int[] R = new int[n2];

      // copy data of the 2 subarrays int he temp ones
      // TODO : can be reduced to one loop and another loop of length |n1-n2|
      for(int i=0; i<n1; i++) L[i] = arr[l+i];
      for(int i=0; i<n2; i++) R[i] = arr[m+1+i];


      // init indexes
      int i=0, j=0, k=l;
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

    public int[] sorting(int[] arr) {
    	   this.arr = arr;
    	   sort(0,arr.length-1);
    	   return arr;
    }

    // Sort a [l...r] array
    public void sort(int l,int r){
      if(l<r){
        int m = (int)(l+r)/2; // find the middle element
        sort(l,m);
        sort(m+1,r);

        merge(l,m,r);
      }
        
    }

}
