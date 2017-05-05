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
	  arbol.preOrderTrav(); // 4 2 1 3 5 6

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav(); // 1 2 3 4 5 6
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav(); // 1 3 2 6 5 4
    
	}

}//end class
