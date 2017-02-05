//Team Battery -- Alison Lee, Angela Kim
//APCS2 pd04
//HW02 -- I Am Still Searching
//2017-02-03

/*
Our algorithm begins at the value at the bottom left corner of the array (possible with top right also, but our code is specific to the bottom left); in other words, the largest value of the first row. We keep track of our position with int vars row(rows) and col(columns) and inside of a while loop, compare the value at our position to the target number. If our value is larger than the target, we move one index in the negative direction(upwards). If our value is smaller than the target number, then we move one index in the positive direction(to the right). We repeat this in a while loop until we find the target number or otherwise go through the entire matrix. 
*/

public class MatrixFinder {
	public static String sort( int[][] arr, int n ) {
		// starting off at bottom left
		int row = arr.length -1 ;
		int col = 0 ;
		
		while( row >= 0 && col <= arr[ 0 ].length -1 ) {
			if( arr[ row ][ col ] == n ) {
				return( "( " + row + ", " + col + " )" ) ;
			}
			// if "selected" element is less than target, "move" right (positive direction)
			else if( arr[ row ][ col ] < n ) {
				col++ ;
			}
			// more than target -> "move" up (negative direction)
			else {
				row-- ;
			}
		}
		
		// nothing was equal to the target in the while loop so return -1
		return "( -1, -1 )" ;
	}
	
	public static void main( String[] args ) {
		int[][] mat =  { { 2, 6, 7, 11}, { 3, 8, 10, 12}, { 4, 9, 11, 13}, { 5, 15, 16, 18} };
		System.out.println( sort( mat , 19 )) ;
		System.out.println( sort( mat , 11 )) ;
		System.out.println( sort( mat , 7 )) ;
	}
}