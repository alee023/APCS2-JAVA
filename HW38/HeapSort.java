// Alison Lee
// APCS2 pd4
// HW38 -- Sort of Like Magic
// 2017-05-10

public class HeapSort {
	
	public static ALHeap sort( ALHeap arr ) {
		ALHeap heap = new ALHeap() ;
		
		while( !( arr.isEmpty())) {
			heap.add( heap.removeMin()) ;
		}
		
		return heap ;
	}
	
	public static void main( String[] args ) {
		ALHeap stuff = new ALHeap() ;
		for( int i = 0 ; i < 5 ; i ++ ) {
			stuff.add(( int ) Math.random() * 10 ) ;
		}
		System.out.println( stuff ) ;
		
		System.out.println( sort( stuff)) ;
	}
}
