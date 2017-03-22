// Alison Lee
// APCS2 pd4
// HW19 -- Generically Speaking...
// 2017-03-16

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList<T> implements List<T> 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
		_head = null ;
		_size = 0 ;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( T x ) {
		if( _head == null ) {
			_head = new DLLNode<T>( x , null, null ) ;
			_size ++ ;
		}
		else {
			DLLNode<T> temp = _head ;
			while( temp.getNext() != null ) {
				temp = temp.getNext() ;
			}
			temp.setNext( new DLLNode<T>( x, null, temp.getPrev() )) ;
			_size ++ ;
		}
		return true ;
	}
	
	public T get( int i ) {
		DLLNode<T> temp = _head ; 
		for( int n = 0 ; n < i ; n ++ ) {
			temp = temp.getNext() ; 
		}
		
		return( temp.getCargo() ) ;
	}
	
	public T set( int i, T x ) {
		T temp = get( i ) ;
		DLLNode<T> current = _head ; 
		for( int n = 0 ; n < i ; n ++ ) {
			if( current.getNext() == null ) {
				break ;
			}
			else {
				current = current.getNext() ;
			}
		}
		current.setCargo( x ) ;
		return temp ;
	}
	
	public void add( int index, T newVal ) {
		DLLNode<T> newNode = new DLLNode<T>( newVal, null, null ) ; 
		if( index == 0 ) {
			newNode.setNext( _head ) ;
			_head = newNode ;
		}
		else {
			DLLNode<T> current = _head ;
			for( int i = 0 ; i < index - 1 ; i ++ ) {
				current = current.getNext() ;
			}
			current.setNext( new DLLNode<T>( newVal, current.getNext(), current.getPrev() )) ;
		}
		_size ++ ;
	}
	
	public T remove( int index ) {
		if( index == 0 ) {
			T car = _head.getCargo() ;
			_head = _head.getNext() ;
			_size -- ;
			return car ;
		}
		
		DLLNode<T> current = _head ;
		for( int i = 0 ; i < index - 1 ; i ++ ) {
			current = current.getNext() ;
		}
		T rem = ( current.getNext() ).getCargo() ;
		current.setNext( ( current.getNext() ).getNext()) ;
		_size -- ;
		
		return rem ; 
	}

    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	LList<String> james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	
	// ===============================================================
	james.remove( 3 ) ;
	System.out.println( "james after removal at 3: " + james ) ;
	
	james.add( 3 , "i need sleep" ) ;
	System.out.println( "james after addition at 3: " + james ) ;
	
    }

}//end class LList