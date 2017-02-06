/**
 * RoundTest.java -- a skeleton for a comprehensive test of
 *    ARoundRectangle. This should be expanded sufficiently that
 *    it is clear from looking at the output that you have tested
 *    the ARoundRectangle thoroughly and understand its parameters.
 * 
 */
import javax.swing.*;
import java.awt.*;

public class RoundTest extends JPanel
{
    //-------------- instance variables ------------------------------
    ARoundRectangle rr0, rr1, rr2, rr3, rr4;
    //------------------ constructor ---------------------------------
    public RoundTest( )
    {
        //ARoundRectangle rr0 = 
        //          new ARoundRectangle( 90, 90, 140, 140, 180, 180 );
        rr0 = new ARoundRectangle( 90, 90, 140, 140, 90, 90 );
        rr0.setArcSize( 10, 30 );
        
        rr1 = new ARoundRectangle( 5, 80, 100, 100, 30, 30 );
        rr1.setColor( Color.CYAN );
        rr1.setLocation( 30, 250 );
        
        rr2 = new ARoundRectangle( 255, 200, 140, 140, 90, 90 );
        rr2.setColor( Color.MAGENTA );
        rr2.getXLocation();
        rr2.getYLocation();
        
        rr3 = new ARoundRectangle( 104, 50, 140, 140, 90, 90 );
        Point p = new Point( 200, 50 );
        rr3.setLocation( p );
        rr3.setFillColor( Color.YELLOW );
        rr3.getColor();
        rr3.getFillColor();
        
        rr4 = new ARoundRectangle( 0 , 0, 140, 140, 90, 90 );
        rr4.setFrameColor( Color.GREEN );
        rr4.setThickness( 15 );
        rr4.setLineWidth( 7 );
        rr4.setSize( 120, 140 );
        rr4.moveBy( 40, 40  );
        rr4.getFrameColor();
  
        
    }
    //------------- paintComponent( Graphics ) ----------------------
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        //////////////////////////////////////////////////////////////
        // invoke display method of all AShape objects
        //////////////////////////////////////////////////////////////
        Graphics2D brush2D = ( Graphics2D ) g;
         rr0.display( brush2D );
         rr1.display( brush2D );
         rr2.display( brush2D );
         rr3.display( brush2D ); 
         rr4.display( brush2D );
    }
    
    //------------------------ main -----------------------------------
    public static void  main( String[] args )
    {
        JFrame f = new JFrame( "ARoundRectangle test" );
        f.setSize( 500, 400 );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JPanel panel = new RoundTest();
        f.add( panel );
        f.setVisible( true ); 
    }            
}