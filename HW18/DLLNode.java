// Alison Lee
// APCS2 pd4
// HW18a -- On the DLL
// 2017-03-15

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode 
{

    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
	private DLLNode _prevNode ; 

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode next, DLLNode prev ) 
    {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev ; 
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }
	
	public DLLNode getPrev() { return _prevNode ; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) 
    {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) 
    {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }
	
	public DLLNode setPrev( DLLNode newPrev ) {
		DLLNode temp = getPrev() ;
		_prevNode = newPrev ;
		return temp ;
	}
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) 
    {

	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", null, null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null, null ) );
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	/* A naive list traversal:
	   while( first != null ) {
	   System.out.println( first );
	   first = first.getNext();
	   }
	*/

	//Q: When head ptr moves to next node in list,
	//   what happens to the node it just left?

	//A: garbage collector reclaims that memory

	//...so better: (w/o moving first pointer)
	DLLNode temp = first; //create ptr to first so JGC doesn't take it
	while( temp != null ) {
	    System.out.println( temp );
	    temp = temp.getNext();
	}
	
    }//end main

}//end class DLLNode
