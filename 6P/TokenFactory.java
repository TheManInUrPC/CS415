import java.util.*;

/**
 * TokenFactory: a factory class, which makes tokens from String fields.
 * This is an example of a Factory pattern.
 *
 * 
 * @author Darien Blow
 */
public class TokenFactory
{
    
    /**
     * 
     * TreeNode makeToken method.
     * 
     * 
     * @param s String
     * 
     * @return new Variable( token, token )
     */
    public static TreeNode makeToken( String s )
    {
        String token = s;
        
        ArrayList<String> ops = new ArrayList<String>( );
        
        ops.add( "*" );
        ops.add( "/" );
        ops.add( "%" );        
        ops.add( "-" );
        ops.add( "+" );
        ops.add( "(" );
        ops.add( ")" );
        ops.add( "=" );
        
        
        float v1;
        
        try
        {
            //Parse the tokens
            v1 = Float.parseFloat( token );
            
            return new Number( token );
        }
        catch ( NumberFormatException e ) 
        {
            if( token.length() == 1  )
            {
                if( ops.contains( token ) )
                {
                    
                    return new Operator( token );
                    
                }
            }
            else
            {
                for( int i = 0; i < token.length(); i++ )
                {
                    if( Character.isJavaIdentifierPart
                           ( token.charAt( i ) ) == false )
                    {
                        return new Variable( "Token Error" );
                    }
                }
            }
            
            
        }
        
        return new Variable( token );
    }
    /**
     * This method will sort all operators and set proper precendence.
     * 
     * 
     * 
     */
    public static float sort( TreeNode node )
    {
        if(  node.toString().equals( ")" ) || node.toString().equals( "(" ) || node.toString().equals( "=" )  )
        {
            return 0;
        }
        else if(  node.toString().equals( "-" ) ||  node.toString().equals( "+" ) )
        {
            return 1;
        }
        else if( node.toString().equals( "%" ) || node.toString().equals( "/" ) ||  node.toString().equals( "*" ))
        {
            
            return 2;
            
        }
        else
        {
            return -1;
            
        }
            
        
}
    
    
}


