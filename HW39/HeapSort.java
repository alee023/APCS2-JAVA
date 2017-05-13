// Alison Lee
// APCS2 pd4
// HW39 -- Heaping Piles of Sordidness
// 2017-05-10

public class HeapSort {
	
	public static void sort( int[] data ) {
		maxHeapify( data, 0 ) ;
		for( int i = data.length - 1 ; i > 0 ; i -- ) {
			swap( data, 0, i ) ;
			maxHeapify( data, 0 ) ;
		}
	}
	
	public static void maxHeapify( int[] arr, int pos ) {
		for( int i = arr.length - 1 ; i > 0 ; i -- ) {
			while( i < arr.length - 1 ) {
				int mc = maxChildPos( arr, pos ) ;

				if( mc == -1 ) {
					return ;
				}
				else if( arr[ i ] < arr[ mc ] ) {
					swap( arr, pos, mc ) ;
					i = mc ;
				}
			}
		}
	}
	
	public static int maxChildPos( int[] arr, int pos ) 
    {		
		if( pos < 0 || ( pos * 2 + 2 >= arr.length )) {
			return -1 ;
		}
		
		int lc = arr[ pos * 2 + 1 ] ;
		int rc = arr[ pos * 2 + 2 ] ;

		return maxOf( lc, rc ) ;
    }//O(1)
	
	public static int maxOf( int x, int y ) {
		if( x > y ) {
			return x ;
		}
		return y ;
	}
	
	public static void swap( int[] arr, int x, int y ) {
		int temp = arr[ x ] ;
		arr[ x ] = arr[ y ] ;
		arr[ y ] = temp ;
	}
	
	public static void print( int[] arr ) {
		for( int i : arr ) {
			System.out.print( i + " " ) ;
		}
		System.out.println() ;
	}
	
	public static void main( String[] args ) {
		int[] a = { 4, 1, 9, 3, 5, 8, 2 } ;
		print( a ) ;
		sort( a ) ;
		print( a ) ; // { 1, 2, 3, 4, 5, 8, 9 }
	}
}