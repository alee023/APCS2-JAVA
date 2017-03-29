// Alison Lee
// APCS2 pd4
// HW25 -- What a Racket
// 2017-03-27

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
 * <<< YOUR PROCEDURE HERE >>>
 * 
 * STACK OF CHOICE: LLStack by Clyde
 * b/c people also using the provided LLStack will have the same code. Troubeshooting 
 * will be easier as a result.
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
		String ret = "" ;
		// base case
		if( ( expr.substring( 1 )).indexOf( "(" ) == -1 ) { // no more expr inside
			String[] exprA = expr.split( " " ) ; // [ "(", op, "num", "num" ... ]
			int op ;
			if( exprA[ 1 ] == "+" ) {
				op = 1 ;
			} 
			else if( exprA[ 2 ] == "-" ) {
				op = 2 ;
			}
			else { // assuming no div sign, etc.
				op = 3 ;
			}
			LLStack<String> stack = new LLStack<String>() ;
			for( int i = 2 ; i < exprA.length - 1 ; i ++ ) {
				stack.push( exprA[ i ] ) ;
			}
			Integer retVal = Integer.parseInt( unload( op, stack )) ;
		}
		else {
			int start = ( expr.substring( 1 )).indexOf( "(" ) ;			
			int end = ( expr.substring( 1 )).indexOf( ")" ) ; 
			
			ret += evaluate( expr.substring( start, end + 1 )) + expr.substring( end ) ;
			ret = evaluate( ret ) ;
		}
		
		return ret ;
    }


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operator to
     *           sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
		int n ;
		int retStr = 0 ; 
		if( op == 1 ) {
			while( !( numbers.isEmpty())) {
				n = Integer.parseInt( numbers.pop() ) ;
				retStr += n ;
			}
		}
		// assuming there will be only two numbers (not "( - 5 3 1 )")
		else if( op == 2 ) {
			retStr = Integer.parseInt( numbers.pop() ) ;
			retStr = Integer.parseInt( numbers.pop() ) - retStr ; // first - last (1st pop)
		}
		else if( op == 3 ) {
			while( !( numbers.isEmpty())) {
				n = Integer.parseInt( numbers.pop()) ;
				retStr *= n ;
			}
		}
		return( retStr + "" ) ;
    }


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4

    }//main

}//end class Scheme
