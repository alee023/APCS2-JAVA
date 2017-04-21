// Bayan Berri, Aryan Bhatt, Alison Lee
// APCS2 pd4
// HW32 -- Getting Past the Velvet Rope
// 2017-04-20

import java.util.ArrayList ;

public class ArrayPriorityQueue {
	
	ArrayList<Integer> APQ ;
	
	public ArrayPriorityQueue() {
		APQ = new ArrayList() ;
	}
	
	// adds an item to this priority queue
	public void add( Integer x ) {
		APQ.add( x ) ;
	}
	
	// returns true if this stack is empty, otherwise return false
	public boolean isEmpty() {
		return( APQ.size() == 0 ) ;
	}
	
	// returns the smallest item stored in this priority queue without removing item
	public Integer peekMin() {
		Integer min = APQ.get( 0 ) ;
		for( Integer i : APQ ) {
			if( min > i ) {
				min = i ;
			}
		}
		
		return min ;
	}
	
	// removes and returns the smallest item stored in this priority queue
	public Integer removeMin() {
		Integer min = peekMin() ;
		for( int i = 0 ; i < APQ.size() ; i ++ ) {
			if( APQ.get( i ) == min ) {
				APQ.remove( i ) ;
			}
		}
		
		return min ;
	}
	
	public static void main( String[] args ) {
		ArrayPriorityQueue test = new ArrayPriorityQueue() ;
		test.add( 2 ) ;
		test.add( 0 ) ;
		test.add( 1 ) ;
		test.add( 2 ) ;
		
		System.out.println( test.peekMin() ) ;
		System.out.println( test.removeMin()) ;
		
		System.out.println( test.removeMin()) ;
		
		System.out.println( test.removeMin()) ;
		
		System.out.println( test.removeMin()) ;
		System.out.println( test.isEmpty() ) ; // true 
	}
}