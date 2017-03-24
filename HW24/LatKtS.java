// Alison Lee
// APCS2 pd4
// HW 23 -- Stack: What Is It Good For?
// 2017-03-24

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
		Latkes temp = new Latkes( s.length() ) ;
		String retStr = "" ;
		for( int i = 0 ; i < s.length() ; i ++ ) {
			temp.push( s.substring( i, i + 1 )) ;
		}
		for( int i = 0 ; i < s.length() ; i ++ ) {
			retStr += temp.pop() ;
		}
		
		return retStr ;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    { 
		if( s.length() % 2 == 1 ) {
			return false ;
		}
		
		Latkes opens = new Latkes( s.length() ) ;
		for( int i = 0 ; i < s.length() - 1 ; i ++ ) {
			String ch = s.substring( i, i + 1 ) ;
			if( ch.equals( "(" ) || ch.equals( "[" ) || ch.equals( "{" ) ) {
				opens.push( ch ) ;
			}
			else {
				if( isMatch( opens.pop(), ch ) == false ) {
					return false ;
				}
			}
		}
		
		return true ;
	}

	public static boolean isMatch( String open, String close ) {
		return( ( open.equals( "(" ) && close.equals( ")" ))
				|| ( open.equals( "[" ) && close.equals( "]" )) 
				|| ( open.equals( "{" ) && close.equals( "}" )) ) ;
	}
	
    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    }

}//end class LatKtS
