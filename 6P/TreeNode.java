/**
 * TreeNode - an abstract class representing a token in an expression.
 *             subclasses are Operator and Operand
 * 
 * @author Darien Blow
 */

public abstract class TreeNode
{
     //----------------------class variables-------------------//
     public TreeNode right = null;
     public TreeNode left = null;
     //Have float value for evaluation.
     public float val;
     /**
      * 
      * Eval method
      * 
      * @return float eval()
      */
     abstract public Float eval();
    /**
     * Method designed to return values from subclasses.
     * 
     * 
     * @return opString
     */
    abstract public String toStringE();
    
    /**
     * 
     * toString method.
     * 
     * @return toString() 
     */
    public String toString()
    {
        return toStringE();
    }

    //------------------ main unit test ------------------------
    /**
     * some basic unit tests.
     * @param args String[]
     */
    public static void main( String[] args )
    {
        try 
        {
            
            TreeNode plus  = TokenFactory.makeToken( "+" );
            TreeNode times = TokenFactory.makeToken( "*" );
            TreeNode a     = TokenFactory.makeToken( "a" );
            TreeNode one   = TokenFactory.makeToken( "1" );

            System.out.println( a + " " + plus + " " + one + " "
                               + times + " " + a );
        }
        catch ( Exception e ) 
        {
            System.out.println( "Bad token: " + e );
        }
    }
}
