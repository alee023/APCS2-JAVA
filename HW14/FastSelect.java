// Alison Lee
// APCS2 pd4
// HW 14 -- So So Fast
// 2017-03-07

public class FastSelect {
	// ==================== HELPER ============================
	//swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
	
	public static int partition( int arr[], int left, int right, int pivPos ) {
		int v = arr[ pivPos ] ;

		swap( pivPos, right, arr ) ;
		int s = left ;

		for( int i = left ; i < right ; i ++ ) {
			if ( arr[ i ] <= v) {
			swap( i, s, arr ) ;
			s ++ ; }
		}
		swap( s, right, arr ) ;

		return s;
    } // end partition
	
	// ========================= HELPER ===============================
	
	/*
	In: array, y-value, ...
	Out: y-th smallest value in the array
	
	If y is less than the number of numbers less than the partition (hi), lower hi. If y is greater, then increase lo. 
	Once there are y - 1 values before y, then stop and return arr[ y ] 
	*/
	public static int search( int[] arr, int a, int lo, int hi ) {
		if( lo == hi ) {
			return arr[ lo ] ;
		}
		else {
			int i = partition( arr, lo, hi, hi ) ;
			if( i  == a - 1 ) {
				return arr[ i ] ;
			}
			else if( i > a - 1 ) {
				return search( arr, a, lo, i - 1 ) ;
			}
			else {
				return search( arr, a , i + 1, hi ) ;
			}
		}
	}
	
	public static void main( String[] args ) {
		int[] arr = buildArray( 10, 100 ) ;
		printArr( arr ) ;
		System.out.println( search( arr, 4, 0, arr.length - 1 ) ) ;
		printArr( arr ) ;
	}

}