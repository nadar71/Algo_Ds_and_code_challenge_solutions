


class MergeSort_02{
	int[] arr;
	int[] tmpArr;

	
	public void merge(int lowerIdx, int  middleIdx, int  upperIdx){
		int lowerStart = lowerIdx;
		int lowerEnd   = middleIdx;
		int upperStart = middleIdx + 1;
		int upperStop  = upperIdx;

		int idx = lowerIdx;

		System.out.println("idx : " + idx + " lowerStart : " + lowerStart + " lowerEnd : " + lowerEnd  + " upperStart : " + upperStart + " upperStop : " + upperStop);
		while (lowerStart <= lowerEnd && upperStart <= upperStop){
			if (arr[lowerStart] < arr[upperStart]) 
				tmpArr[idx++] = arr[lowerStart++];
			else
				tmpArr[idx++] = arr[upperStart++];
		}

		while (lowerStart <= lowerEnd){
			tmpArr[idx++] = arr[lowerStart++];
		}

		while (upperStart <= upperStop){
			tmpArr[idx++] = arr[upperStart++];
		}

		for(int i = lowerIdx; i <= upperIdx; i++)
			arr[i] = tmpArr[i];
	}

  
  
  
  public int[] mergeSort(int[] d){
		arr = d;
		int length = d.length;
		tmpArr = new int[length];
		sort(0, length-1);
		
		return arr;
	}
	
	
	
	public void sort(int lowerIdx, int upperIdx) {
		if (lowerIdx < upperIdx) {
			int midIdx = (int) (lowerIdx + upperIdx) / 2;

			System.out.println("lowerIdx : " + lowerIdx + " midIdx : " + midIdx);
			sort(lowerIdx, midIdx);

			System.out.println("midIdx + 1 : " + (midIdx + 1) + " upperIdx : " + upperIdx);
			sort(midIdx + 1, upperIdx);

			System.out.println("lowerIdx : " + lowerIdx + "midIdx  " + midIdx  + " upperIdx : " + upperIdx);
			merge(lowerIdx, midIdx, upperIdx);
		}

	}


}

