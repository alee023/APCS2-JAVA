// Team LeeLi -- Alison Lee, Kevin Li
// APCS2 pd 4
// HW04 -- Where In the Array Is Carmen San Numero?
// 2017-02-05

public class MissingNum {
	
	public static int findM( int[] arr ) {
		int retInt = -1 ;
		
		for( int i : arr ) {
			/* negates the value at arr[ i ] - 1 if it isn't already negative. 
			It has to be arr[ i ] - 1 because the array is index is [ 0 , n - 1 ] while containing values of [ 1 , n ] */
			int n = Math.abs( i ) - 1 ;
			// checks to see if it was already negated
			if( arr[ n ] > 0 ) {
				arr[ n ] *= -1 ;
			}
		}
		
		// At this point, there should only be one element in the array that is positive. The index of that element + 1 is equal to the missing value. 
		for( int i = 0 ; i < arr.length ; i ++ ) {
			if( arr[ i ] > 0 ) {
				retInt =  i + 1 ;
			}
		}
		
		return retInt ;
	}
	
	public static void main( String[] args ) {
		int[] arr = { 1 , 3 , 5 , 2 , 3 } ;
		System.out.println( findM( arr )) ; // 4
		
		int[] arr1 = { 1 , 2 , 4 , 2 , 5 } ;
		System.out.println( findM( arr1 )) ; // 3
		
		int[] arr2 = { 1 , 3 , 3 , 4 } ;
		System.out.println( findM( arr2 )) ; // 2
	}
}