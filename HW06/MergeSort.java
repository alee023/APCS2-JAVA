// Alison Lee
// APCS2 pd5
// HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2017-02-11

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    public static int[] merge( int[] a , int[] b ) {
		int ai = 0 ;
		int bi = 0 ;
		int[] ab = new int[ a.length + b.length ] ;

		for( int x = 0 ; x < ab.length ; x ++ ) {
			if(( ai != a.length ) && ( bi != b.length )) {
				if( a[ ai ] < b[ bi ] ) {
					ab[ x ] = a[ ai ] ;
					ai ++ ;
				}
				else {
					ab[ x ] = b[ bi ] ;
				bi ++ ;
				}
			}
			else {
				if( ai < a.length ) {
					ab[ x ] = a[ ai ] ;
					ai ++ ;
				}
				else if ( bi < b.length ) {
					ab[ x ] = b[ bi ] ;
					bi ++ ;
				}
			}
		}
	  
		return ab ;
   }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
		if( arr.length == 1 ) {
			return arr ;
		}
		else {
			int[] a = new int[ arr.length / 2 ] ;
			int[] b = new int[ arr.length - a.length ] ;
			
			for( int i = 0 ; i < a.length ; i ++ ) {
				a[ i ] = arr[ i ] ;
			}
			for( int i = 0 ; i < b.length ; i ++ ) {
				b[ i ] = arr[ i + ( arr.length / 2 ) ] ;
			}
			
			return merge( sort( a ) , sort( b )) ;
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

	/// *~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
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
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

