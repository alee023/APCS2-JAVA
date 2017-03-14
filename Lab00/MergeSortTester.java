public class MergeSortTester {
	public static void populate( int[] arr ) {
		for( int i = 0 ; i < arr.length ; i ++ ) {
			arr[ i ] = ( int )( Math.random() * 101 ) ;
		}
	}
	
	public static void main( String[] args ) {
		int[] one = new int[ 1 ] ; 
		int[] ten = new int[ 10 ] ;
		int[] hun = new int[ 100 ] ;
		int[] twfi = new int[ 250 ] ;
		int[] fivh = new int[ 500 ] ;
		int[] tho = new int[ 1000 ] ;
		
		populate( one ) ;
		populate( ten ) ;
		populate( hun ) ;
		populate( twfi ) ;
		populate( fivh ) ;
		populate( tho ) ;
		
		/*
		long start0 = System.nanoTime() ; 
		Mergesort.sort( one ) ;
		long end0 = System.nanoTime() ;
		long diff0 = end0 - start0 ;
		*/
		/*
		long start1 = System.nanoTime() ; 
		Mergesort.sort( ten ) ;
		long end1 = System.nanoTime() ;
		long diff1 = end1 - start1 ;
		*/
		/*
		long start2 = System.nanoTime() ; 
		Mergesort.sort( hun ) ;
		long end2 = System.nanoTime() ;
		long diff2 = end2 - start2 ;
		*/
		/*
		long start5 = System.nanoTime() ; 
		Mergesort.sort( twfi ) ;
		long end5 = System.nanoTime() ;
		long diff5 = end5 - start5 ;
		*/
		/*
		long start3 = System.nanoTime() ; 
		Mergesort.sort( fivh ) ;
		long end3 = System.nanoTime() ;
		long diff3 = end3 - start3 ;
		*/
		/*
		long start4 = System.nanoTime() ; 
		Mergesort.sort( tho ) ;
		long end4 = System.nanoTime() ;
		long diff4 = end4 - start4 ;
		*/
		
		System.out.println( "TIME IN MS" ) ;
		// System.out.println( diff0 / 1000000.0 ) ;
		// System.out.println( diff1 / 1000000.0 ) ;
		// System.out.println( diff2 / 1000000.0 ) ;
		// System.out.println( diff3 / 1000000.0 ) ;
		// System.out.println( diff4 / 1000000.0 ) ;
		// System.out.println( diff5 / 1000000.0 ) ;
	}
}