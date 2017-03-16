// Alison Lee
// APCS2 pd4
// HW18a -- On the DLL
// 2017-03-15

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
		_head = null ;
		_size = 0 ;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( String x ) {
		if( _head == null ) {
			_head = new DLLNode( x , null, null ) ;
			_size ++ ;
		}
		else {
			DLLNode temp = _head ;
			while( temp.getNext() != null ) {
				temp = temp.getNext() ;
			}
			temp.setNext( new DLLNode( x, null, temp.getPrev() )) ;
			_size ++ ;
		}
		return true ;
	}
	
	public String get( int i ) {
		DLLNode temp = _head ; 
		for( int n = 0 ; n < i ; n ++ ) {
			temp = temp.getNext() ; 
		}
		
		return( temp.getCargo() ) ;
	}
	
	public String set( int i, String x ) {
		String temp = get( i ) ;
		DLLNode current = _head ; 
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
	
	public void add( int index, String newVal ) {
		DLLNode newNode = new DLLNode( newVal, null, null ) ; 
		if( index == 0 ) {
			newNode.setNext( _head ) ;
			_head = newNode ;
		}
		else {
			DLLNode current = _head ;
			for( int i = 0 ; i < index - 1 ; i ++ ) {
				current = current.getNext() ;
			}
			current.setNext( new DLLNode( newVal, current.getNext(), current.getPrev() )) ;
		}
		_size ++ ;
	}
	
	public String remove( int index ) {
		if( index == 0 ) {
			String car = _head.getCargo() ;
			_head = _head.getNext() ;
			_size -- ;
			return car ;
		}
		
		DLLNode current = _head ;
		for( int i = 0 ; i < index - 1 ; i ++ ) {
			current = current.getNext() ;
		}
		String rem = ( current.getNext() ).getCargo() ;
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
	LList james = new LList();

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