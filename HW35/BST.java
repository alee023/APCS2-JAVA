// Alison Lee
// APCS2 pd4
// HW35 -- BSTs is the Perfect Place for Shade
// 2017-05-04

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
	private TreeNode tree ;


    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
		tree = null ;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {
		tree = insertH( tree, newVal ) ;
	}
	
	public TreeNode insertH( TreeNode node, int newVal ) 
    {
     	if( node == null ) {
			node = new TreeNode( newVal ) ;
		}
		else if( node.getValue() > newVal ) {
			node.setLeft( insertH( node.getLeft(), newVal )) ;
		}
		else {
			node.setRight( insertH( node.getRight(), newVal )) ;
		}
		
		return node ;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

	public void preOrderTrav() {
		preOrderTravH( tree ) ;
	}
	
    public void preOrderTravH( TreeNode node ) 
    {
    	System.out.print( node.getValue() + " " ) ;
		if( node.getLeft() != null ) {
			preOrderTravH( node.getLeft()) ;
		}
		if( node.getRight() != null ) {
		preOrderTravH( node.getRight()) ;
		}
	}

	public void inOrderTrav() {
		inOrderTravH( tree ) ;
	}
	
    public void inOrderTravH( TreeNode node ) 
    {
		if( node.getLeft() != null ) {
			inOrderTravH( node.getLeft()) ;
		}
		System.out.print( node.getValue() + " " ) ;
		if( node.getRight() != null ) {
			inOrderTravH( node.getRight()) ;
		}
    }

	public void postOrderTrav() {
		postOrderTravH( tree ) ;
	}
	
    public void postOrderTravH( TreeNode node ) 
    {
		if( node.getLeft() != null ) {
			postOrderTravH( node.getLeft()) ;
		}
		if( node.getRight() != null ) {
			postOrderTravH( node.getRight()) ;
		}
		System.out.print( node.getValue() + " " ) ;
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
    	return searchH( tree, target ) ;
    }
	
	TreeNode searchH( TreeNode node, int target ) {
		if( node.getValue() == target ) {
			return node ;
		}
		else if( target < node.getValue()) {
			return( searchH( node.getLeft(), target )) ;
		}
		else if( target > node.getValue()) {
			return( searchH( node.getRight(), target )) ;
		}
		
		// not found...
		return null ;
	}


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	return heightH( tree ) ;
    }
	
	public int heightH( TreeNode node ) {
		if( node == null ) {
			return 0 ;
		}
		else {
			if( heightH( node.getLeft()) > heightH( node.getRight()) ) {
				return( 1 + heightH( node.getLeft())) ;
			} 
			else {
				return( 1 + heightH( node.getRight())) ;
			}
		}
	}

	
    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
    	return numLeavesH( tree ) ;
    }

	public int numLeavesH( TreeNode node ) {
		if( node == null ) {
			return 0 ;
		}
		else if( node.getLeft() == null && node.getRight() == null ) {
			return 1 ; 
		}
		else {
			return( numLeavesH( node.getLeft()) + numLeavesH( node.getRight())) ;
		}
	}


    //main method for testing
    public static void main( String[] args ) 
    {
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();	

	  //insert your new test calls here...
	  System.out.println( "\nSearch: " + ( arbol.search( 2 )) ) ; // 1 2 3, if inOrderTrav was run on the result
	  System.out.println( "\nHeight: " + arbol.height()) ; // 3
	  System.out.println( "\nNumber of leaves: " + arbol.numLeaves()) ; // 3
    }

}//end class