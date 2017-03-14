/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  Procedure for merge sort:

  Given an ArrayList of com
  parable items, arr:
  1. Check if arr.size() is greater than one.
  2. If arr.size() is greater than one, then split it in half and repeat the comparison with the two new ArrayLists until the last two ArrayLists each have a size of exactly one.
  3. Since we know for sure that an AL of one is sorted, at this point, the last two ALs should return their item to the AL that gave them the item.
  4. Now, in order to sort for an AL of arr.size() > 1 (ascending order):
  --create a new AL
  --compare the top item of one lower AL(AL that cards were distributed to) to the top item of the other lower AL
  --place the lesser value item into the new AL and repeat until there are no more cards in either lower ALs
  5. Repeat this gathering and sorting of items until there is one final AL that has the same number of items as arr.
  ======================================*/

public class Mergesort {

    /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int indA = 0;
	int indB = 0;
	int[] ret = new int[a.length + b.length];

	for(int x = 0; x < ret.length; x++){
	    if(indA == a.length){
		ret[x] = b[indB];
		indB++;
	    }
	    else if(indB == b.length){
		ret[x] = a[indA];
		indA++;
	    }
	    else if(a[indA] < b[indB]){
		ret[x] = a[indA];
		indA++;
	    }
	    else{
		ret[x] = b[indB];
		indB++;
	    }
	}	
	return ret;
    }//end merge()

    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int len = arr.length;
	int[] ret = new int[len];
	
	if(len <= 1){
	    return arr;
	}
	else{
	    int[] ret1 = new int[len/2];
	    int[] ret2 = new int[len - (len/2)];
	    for(int x = 0; x < ret1.length; x++){
		ret1[x] = arr[x];
	    }
	    for(int x = 0; x < ret2.length; x++){
		ret2[x] = arr[ret1.length+x];
	    }
	    ret = merge(sort(ret1), sort(ret2));
	    return ret;
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
