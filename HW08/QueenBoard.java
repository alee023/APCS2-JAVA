// Alison Lee
// APCS2 pd4
// HW08 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2017-02-22

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard {
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * Starts on the top leftmost square and puts a queen down. Invokes the addQueen method, which will "mark" the squares horizontal and diagonal to the square where the queen was just placed.
	 A for loop goes through the rows, and recursion occurs on the columns.
	 If a queen can't be added legally, then it "backtracks" by removing the queen.
     */
    public boolean solve() {
		return( solveH( 0 )) ;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) {
		if( col == _board.length ) {
			return true ;
		}
		for( int row = 0 ; row < _board.length ; row ++ ) {
			if( addQueen( row , col )) {
				if( solveH( col + 1 )) {
					return true ;
				}
				else {
				removeQueen( row , col ) ;
				}
			}
		}
		return false;
    }


    //print a valid placement of n queens
    public void printSolution() {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
		for( int i = 0 ; i < _board.length ; i ++ ) {
			for( int j = 0 ; j < _board.length ; j ++ ) {
				if( _board[ i ][ j ] <= 0 ) {
					System.out.print( "_   " ) ;
				}
				else {
					System.out.print( "Q   " ) ;
				}
			}
			System.out.println( "\n" ) ;
		}
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Adds a queen in the square (of the row-col input), and updates the squares horizontal and diagonal to it by subtracting 1 from their values
     * precondition: row and col are given. They are integers and should be in range.
     * postcondition: returns either true or false depending on the row-col. If it doesn't return false, it will place a a queen and change the values in the squares horizontal and diagonal to the queen square, to indicate whether those squares are available or not for the next queens. 
     */
    private boolean addQueen(int row, int col) {
		// checks if a queen can be added there
		if(_board[row][col] != 0){
			return false;
		}

		// places queen
		_board[row][col] = 1;

		// ? -- counter
		int offset = 1;

		// runs until it reaches end column of the board. Decreases value in the squares
		while(col+offset < _board[row].length) {
			// decreases values in squares horizontal to the square where the new queen was placed
			_board[row][col+offset]--;

			// diagonally
			if( row - offset >= 0 ) {
				_board[row-offset][col+offset]--;
			}
			if( row + offset < _board.length ) {
				_board[row+offset][col+offset]--;
			}
			// next column
			offset++;
		}
		return true;
    }


    /***
     * Removes queen in the square (of the row-col input), and updates the squares horizontal and diagonal to it by adding 1 to their values
     * precondition: row and col are given and should be in range (< # of squares per side)
     * postcondition: returns true or false depending on the row-col given. If it doesn't return false, it will remove a queen and update the corresponding squares.
     */
    private boolean removeQueen(int row, int col) {
		// checks to see if this square holds a queen. If not, the method returns false
		if ( _board[row][col] != 1 ) {
			return false;
		}
		_board[row][col] = 0;	// square is open, meaning a queen can be placed there
		int offset = 1;	        // counter

		// increases value in squares horizontal and diagonal to the square where the queen was just removed
		while( col+offset < _board[row].length ) {
			_board[row][col+offset]++;
			if( row - offset >= 0 ) {
				_board[row-offset][col+offset]++;
			}
			if( row + offset < _board.length ) {
				_board[row+offset][col+offset]++;
			}
			offset++;
		}
		return true;
    }


    /***
     * Prints board, with numbers in the squares instead of queens and _s (as opposed to the output of the printSolution method)
     * precondition: _board exists
     * postcondition: Prints out board with integer numbers <= 1. 
     */
    public String toString() {
		String ans = "";
		for( int r = 0; r < _board.length; r++ ) {
			for( int c = 0; c < _board[0].length; c++ ) {
				ans += _board[r][c]+"\t";
			}
			ans += "\n";
		}
		return ans;
    }


    //main method for testing...
    public static void main( String[] args ) {
		/*
		QueenBoard b = new QueenBoard(5);
        System.out.println(b);
		b.addQueen(3,0);
		b.addQueen(0,1);
        System.out.println(b);
		b.removeQueen(3,0);
        System.out.println(b);
		*/
		
		QueenBoard eight = new QueenBoard( 8 ) ;
		eight.solve() ;
		eight.printSolution() ;
		
    }//end main()
    
}//end class
