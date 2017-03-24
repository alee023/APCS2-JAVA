/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
		_stack = new String[ _stackSize ] ;
		_stackSize = 0 ;
    }

    //means of insertion
    public void push( String s ) 
    {
		if( !( isFull() )) {
			_stack[ _stackSize ] = s ;
			_stackSize ++ ;
		}
    }

    //means of removal ("top pancake"/last element)
    public String pop( ) 
    { 
		String last = _stack[ _stackSize - 1 ] ;
		if( !( isEmpty() )) {
			_stack[ _stackSize - 1 ] = null ;
			_stackSize -- ;
		}
		return last ;
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
		return( _stackSize == 0 ) ;
    }

    //chk for fullness
    public boolean isFull() 
    {
		return( _stack[ _stackSize - 1 ] != null ) ;
    }

}//end class Latkes

