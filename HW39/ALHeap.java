// Alison Lee
// APCS2 pd4
// HW37 -- Heap o' Trouble
// 2017-05-09

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap 
{
    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
		_heap = new ArrayList<Integer>() ;
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { 
		// would return( _heap.toString()) work?
		String retStr = "" ;
		
		for( int i : _heap ) {
			retStr += i + " " ;
		}
		
		return retStr ;
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 

	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    { 
		return _heap.get( 0 ) ;
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     * Algo: adds to end of _heap. if it's not heap-like (meaning that the value is less than parent),
     * 		 then it will swap with parent
     * 
     *****************************************************/
    public void add( Integer addVal ) 
    { 
		// adds to the END
		_heap.add( addVal ) ;
		int index = _heap.size() - 1 ;
		
		while( index > 0 && _heap.get( index ) < _heap.get(( index - 1 ) / 2 )) {
			swap( index, ( index - 1 ) / 2 ) ;
			index = ( index - 1 ) / 2 ;
		}
    } //O(logn)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * Algo: switch min (at index 0) with last element. remove last element (now the min).
     * 		 put element at index 0 in its appropriate spot
     * 
     *****************************************************/
    public Integer removeMin() 
    {
		if( isEmpty()) {
			return null ;
		}
		Integer min = peekMin() ;
		swap( 0, _heap.size() - 1 ) ;
		_heap.remove( _heap.size() - 1 ) ;
		
		while( minChildPos( min ) != -1 ) {
			int mc = minChildPos( min ) ;
			swap( min, mc ) ;
			min = mc ;
		}
		
		return min ;
    }//O(logn)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {		
		if( pos < 0 || ( pos * 2 + 2 >= _heap.size())) {
			return -1 ;
		}
		
		int lc = _heap.get( pos * 2 + 1 ) ;
		int rc = _heap.get( pos * 2 + 2 ) ;

		return minOf( lc, rc ) ;
    }//O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) 
    {

	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);


    }//end main()

}//end class ALHeap
