import java.util.*;

/**
 * 
 * Operator Class.
 * 
 * @author Darien Blow
 * 
 */
public class Operator extends TreeNode
{
    //--------------------- class variables -------------------------------
    
    //--------------------- instance variables ----------------------------
    // Use a Hashtable or a HashMap to store information (value) using the id 
    // as the key
    ///////////////////////////////////////////////////////////
    
    private String opString1;
    
    
    
    //------------- constructor --------------------------------------------
    /**
     * Note the constructor is private!
     * 
     * @param string String
     */
    public Operator( String string )
    {
        opString1 = string;
    }
    
    //------------------------- toString() -------------------------------
    /**
     * toStringE method.
     * 
     * @return "@" + opString
     * 
     */
    public String toStringE()
    {
        return opString1;
    }
     //------------------------ Evaluate dat stuff! ---------------------//
    /**
     * 
     * Evaluate method.
     * 
     * 
     * 
     */
    public Float eval()
    {
      if( opString1.equals( "=" ) )
      {
        SymbolTable.instance().setValue( left.toStringE(), right.eval() );
        return right.eval();
      }
      else if( opString1.equals( "*" ) )
      {
        //Multiply left and right
        return ( left.eval() * right.eval() );
      }
      else if( opString1.equals( "/" ) )
      {
        //HE WILL NOT DIVIDE US
        return ( left.eval() / right.eval() );
      }
      else if( opString1.equals( "%" ) )
      {
        
        return ( left.eval() % right.eval() );
       
        
      }
      else if( opString1.equals( "+" ) )
      {
        return ( left.eval() + right.eval() );
      }
      else if( opString1.equals( "-" ) )
      {
        return (left.eval() - right.eval() );
        
      }
      else
      {
         System.out.println( "Please enter a valid operator " );     
         
         return null;
      }  
      
    }

    //--------------------------- main -----------------------------------
    /**
     * Simple unit testing for Operator.
     * 
     * @param args String[]
     */
    public static void main( String[] args )
    {
        
    }
}