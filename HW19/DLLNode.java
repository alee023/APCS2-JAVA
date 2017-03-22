// Alison Lee
// APCS2 pd4
// HW19 -- Generically Speaking...
// 2017-03-16

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T> 
{

    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode; //pointer to next DLLNode
	private DLLNode<T> _prevNode ; 

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode<T> next, DLLNode<T> prev ) 
    {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev ; 
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }
	
	public DLLNode<T> getPrev() { return _prevNode ; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) 
    {
	T foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode<T> setNext( DLLNode newNext ) 
    {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }
	
	public DLLNode<T> setPrev( DLLNode newPrev ) {
		DLLNode temp = getPrev() ;
		_prevNode = newPrev ;
		return temp ;
	}
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class DLLNode
