// Alison Lee
// APCS2 pd4
// HW28 -- Now Let's Consider You Lot at Fake Terry's
// 2017-03-31

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    _front = null ;
		_end = null ;
		_size = 0 ;
	}


    public void enqueue( T enQVal ) 
    {
		if( isEmpty() ) {
			_front = _end = new LLNode<T>( enQVal, null ) ;
		}
		else {
			_end.setNext( new LLNode<T>( enQVal, null ) ) ;
			_end = _end.getNext() ;
		}
		
		_size ++ ;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    { 
		T retVal = _front.getValue() ;
		_front = _front.getNext() ;
		_size -- ;
		
		if( _size == 0 ) {
			_end = null ;
		}
		
		sample() ;
		
		return retVal ;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo: Only the front and some other node has to be swapped.
     * A random number will be generated. A for loop will be used to get to the node at the
     * index of that num. Value at that and the front will be swapped.
     ******************************************/
    public void sample () 
    {
		int rand = ( int )( Math.random() * _size ) ;
		T frontV = _front.getValue() ;
		
		LLNode<T> dummy = _front ;
		for( int i = 0 ; i < rand ; i ++ ) {
			dummy = dummy.getNext() ;
		}
		_front.setValue( dummy.getValue() ) ;
		dummy.setValue( frontV ) ;
    }


    public boolean isEmpty() 
    { 
		return( _size == 0 ) ;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
		String retStr = "" ;
		LLNode<T> dummy = _front ;
		while( dummy != null ) {
			retStr += dummy.getValue() + " " ; 
			dummy = dummy.getNext() ;
		}
		
		return( retStr ) ;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
    }//end main

}//end class RQueue
