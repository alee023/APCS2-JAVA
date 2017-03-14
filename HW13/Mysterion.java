// Alison Lee
// APCS2 pd4
// HW13 -- We Be Dem
// 2017-03-06

public class Mysterion {
	/* I'm not sure what this method does. However, because of the swapping, it seems like part of a sorting algorithm. 
	*/
	public static int mysterion( int[] arr , int a , int b , int c ) {
		int d ; // for swapping
		
		int v = arr[ c ] ;
		// swap arr[ c ], arr[ b ]
		d = arr[ c ] ;
		arr[ c ] = arr[ b ] ;
		arr[ b ] = d ;
		
		int s = a ;
		for( int i = a ; i < b ; i ++ ) {
			if( arr[ i ] > v ) {
				// swap arr[ s ], arr[ i ]
				d = arr[ s ] ;
				arr[ s ] = arr[ i ] ;
				arr[ i ] = d ;
				
				s ++ ;
			}
		}
		// swap arr[ b ], arr[ s ]
		d = arr[ b ] ;
		arr[ b ] = arr[ s ] ;
		arr[ s ] = d ;
		
		return s ;
	}
	
	public static String printArr( int[] arr ) { 
		String retStr = "[ " ;
		for( int i : arr ) {
			retStr += i + ", " ;
		}
		retStr = retStr.substring( 0 , retStr.length() - 2 ) + " ]" ;
		return retStr ;
	}
	
	public static void main( String[] args ) {
		int[] arr = new int[ 8 ] ;
		for( int i = 0 ; i < 8 ; i ++ ) {
			arr[ i ] = ( int )( Math.random() * 20 ) ;
		}
		
		int a = ( int )( Math.random() * 8 ) ; 
		int b = ( int )( Math.random() * 8 ) ; 
		int c = ( int )( Math.random() * 8 ) ; 
		
		System.out.println( "BEFORE: " + printArr( arr )) ;
		System.out.println( mysterion( arr , 1 , 5 , 2 )) ;
		System.out.println( "a: " + a + "\nb: " + b + "\nc: " + c ) ;
		System.out.println( "AFTER: " + printArr( arr )) ;
	}
}