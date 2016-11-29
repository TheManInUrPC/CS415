

import java.awt.Color;
import java.awt.event.*;
import wheelsunh.users.*;
import java.awt.Point;


/**
 * Queen.   Fall 2013
 *A draggable queen that snaps to grid and marks attacked squares.
 * 
 * @author mlb
 * 
 */
public class Queen extends ShapeGroup
{ 
    private Image image;
    private int size = QueenApp.SQUARE_SIZE;
    private int baseX = QueenApp.BASE_X;
    private int baseY  = QueenApp.BASE_Y;
    private int queenR, queenC;
    private Square [ ][ ] board;
    private Point last;            // used only for dragging
    
    //------------------------- Constructors --------------------------
    /**
     * Position tile at r, c on the board
     */
    public Queen( int r, int c,  Square b[][] )
    {
        try
        {
            // Assign a new Image to image
        image = new Image( "q2.png" );
        
        if( image != null )
              add(image );
        }
        catch( Exception e )
        {
            System.out.println( "Could not create image");
        }
        

        placeOnSquare( r , c );
        queenR = r;
        queenC = c;
        board = b;
        markAll( );
    }
    
    
    //--------------------------- placeOnSquare( r, c ) --------------
    /*
     *  place the queen on square r,c
     */    
    public void placeOnSquare( int r, int c )
    {
        setLocation( queenC *  size + baseX, queenR *  size + baseY );  
    }
    
    
    //--------------------------- mousePressed ------------------------
    /*
     *  the usual drag procedure.
     */     
    public void mousePressed( MouseEvent me )
    {
        last = me.getPoint( );
    }
    
    
    //--------------------------- mouseReleased -----------------------
    /*
     *   On mouse released get the closest row and column to the current
     *   location.
     */   
    public void mouseReleased( MouseEvent me )
    {
        Point p = me.getPoint( );
        
        queenR = getClosestRow( this.getCenterY( ) );
        queenC = getClosestCol( this.getCenterX( )  );
        
        placeOnSquare(  queenR, queenC  );
        markAll();
    }
    
    //--------------------------- mouseDragged ------------------------
    /*
     *   The usual drag procedure.
     */   
    public void mouseDragged( MouseEvent me )
    {
        Point newLoc = me.getPoint();
        int dx = newLoc.x - last.x;
        int dy = newLoc.y - last.y;
        
        this.setLocation( getXLocation() + dx, getYLocation() + dy );
        last = newLoc;
    }
    
    
    //--------------------------- getClosestColumn -------------------
    /*
     *  
     */   
    private int getClosestCol( int x )
    {
        x -= baseX;
        x /= size;
        if( x < 0 )
        {
            x = 0;
        }
        if( x >  7 )
        {
            x = 7;
        }
       
        
        
        
        return x;  
        
        
        
        

    }
    
    
    //--------------------------- getClosestRow -----------------------
    /*
     * 
     */   
    private int  getClosestRow( int y  )
    {

        y -= baseY;
        y /= size;
        if( y < 0 )
        {
            y = 0;
        }
        if( y >  7 )
        {
            y = 7;
        }
       
        
        
        
        return y;  
    }
    
    
    //--------------------------- markAll -----------------------------
    /*    
     *  call setMark for all squares on the board.
     *  call setMark( true ) if the square is under attack and
     *  setmark( false ) otherwise. Use isAttacked( i, j ) to 
     *  see if a square is under attack.
     */
    private void  markAll( )
    {
        
        for( int i = 0; i < board.length; i++ )
        {
            for( int d = 0; d < board.length; d++ )
            {
                if( isAttacked( i , d ) == true )
                {
                    board[i][d].setMark(true);
                }
                else
                {
                    board[i][d].setMark(false);
                }
            }
        }
         
        
        
        
        
        
    }
    
    //--------------------------- isAttacked --------------------------
    /*
     *  return true if the square at r,c is under attack from the queen
     *  at queenR,queenC
     *  otherwise return false.
     * 
     */   
    private boolean isAttacked( int r, int c )
    {
        boolean answer = false;
        
        if( r == queenR || c == queenC || r + c == queenR + queenC || r - c == queenR - queenC )
        {
          answer = true;
        }
        else
        {
            answer = false;
        }
        

        
        
        
        
        
        
        
        return answer;
    }
    
    
    //------------------------- main -------------------------------
    /**
     * main.
     * @param a String a[]
     */
    public static void main(String a [] )
    {    
        new Frame( 700, 550 );
        new QueenApp( 8, 8 );
    }
} 
