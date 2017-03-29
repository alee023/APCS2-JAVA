// Alison Lee
// APCS2 pd4
// HW26 -- The English Do Not Wait In Front
// 2017-03-28

/*****************************************************
 * class LLQueue
 * uses a singly-linked nodes to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
	{ 
        _front = null ;
        _end = null ;
	}

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
        if( isEmpty() ) {
            _end = new LLNode<T>( enQVal, null ) ;
            _front = _end ;
        }
        _end = new LLNode<T>( enQVal, _end ) ;
    }//O(1)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
        if( isEmpty()) {
            System.out.println( "Empty queue. Cannot dequeue." ) ;
            return null ;
        }
        
        LLNode<T> dummy = _end ;
        while( dummy.getNext() != _front ) {
            dummy = dummy.getNext() ;
        }
        T retVal = ( dummy.getNext()).getValue() ;
        _front = dummy ;
        dummy.setNext( null ) ;
        
        return retVal ;
    }//O(n)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
        return( _front.getValue()) ;
    }//O(1)


    public boolean isEmpty() 
    {
        return( _front == null ) ;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
        String retStr = "" ;
        LLNode<T> dummy = _end ;
        while( dummy != null ) {
            retStr = dummy.getValue() + " " + retStr ; 
            // or retStr += dummy.getValue() for reverse
            dummy = dummy.getNext() ;
        }
        
        return retStr ; 
    }//O(n)



    public static void main( String[] args ) {

	  Queue<String> LLQueuelJ = new LLQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...

	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );

	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );

    }//end main

}//end class LLQueue
