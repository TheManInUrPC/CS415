import java.util.*;

/**
 * 
 * Number Class.
 * 
 * 
 * @author Darien Blow
 */
public class Number extends Operand
{
    //--------------------- class variables -------------------------------
    
    
    //--------------------- instance variables ----------------------------
    // Use a Hashtable or a HashMap to store information (value) using the id 
    // as the key
    ///////////////////////////////////////////////////////////
    
    
    
    //------------- constructor --------------------------------------------
    /**
     * Note the constructor is private!
     * 
     * @param string String
     */
    public Number( String string )
    {
        opString = string;
    }
    
    //------------------------- toString() -------------------------------
    /**
     * toStringE method.
     * 
     * @return "@" + opString
     * 
     */
    public String toStringE( )
    {
        return opString;
    }
   /**
     * 
     * Eval.
     * 
     */
    public Float eval()
    {
      //Parse the number!
        float num = Float.parseFloat( opString );
        
        
        System.out.println( "Number debug:" + num );
        
        return num;
      
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