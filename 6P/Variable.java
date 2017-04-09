import java.util.*;

/**
 * 
 * Variable Class.
 * 
 * @author Darien Blow
 * 
 */
public class Variable extends Operand
{
    //--------------------- class variables -------------------------------
    
    
    //--------------------- instance variables ----------------------------
    // Use a Hashtable or a HashMap to store information (value) using the id 
    // as the key
    ///////////////////////////////////////////////////////////
    private String val;
    private float sVal;
    
    
    
    //------------- constructor --------------------------------------------
    /**
     * Note the constructor is private!
     * 
     * @param string String
     * @param v String
     */
    public Variable( String string )
    {
        opString = string;
        
        SymbolTable.instance().getValue( string );
    }
    
    //------------------------- toString() -------------------------------
    /**
     * 
     * toStringE method.
     * @return "@" + opString;
     */
    public String toStringE()
    {
        val = opString.toString();
        return val;
        
    }
    //------------------------ Evaluate dat stuff! ---------------------//
    /**
     * 
     * Evaluate method.
     * 
     * @return sVal
     * 
     */
    public Float eval()
    {
      
      
     
      return SymbolTable.instance().getValue( opString );
    }
      
    //--------------------------- main -----------------------------------
    /**
     * Simple unit testing for Operand.
     * 
     * @param args String[]
     */
    public static void main( String[] args )
    {
        
    }
}