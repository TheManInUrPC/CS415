/**
 * RegularPolyTest.java -- this is a skeleton for a program to 
 *             thoroughly test the ARegularPoly class.
 * 
 *  It needs to be significantly expanded. 
 *       1. At the very least, every public method of ARegularPoly needs 
 *          to be invoked at least once -- even methods you didn't edit! 
 *          You must verify that you didn't break them. 
 *       2. And, every option of every method you did write needs to be
 *          tested thoroughly.
 *          
 * @author rdb
 * Last edited: 01/01/14
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RegularPolyTest extends JPanel
{
    //-------------- instance variables ------------------------------
    private ARegularPoly p1, p2, p3, p4, p5;
    //------------------ constructor ---------------------------------
    public RegularPolyTest( )
    {
        ////////////////////////////////////////////////////////
        // Create enough ARegularPoly objects to show that you 
        //   have thoroughly tested this code. At the very least,
        //   your tests should cause the execution of every public method
        //   in the class (not just the ones you had to write).
        ////////////////////////////////////////////////////////
        
        p1 = new ARegularPoly( 15, 0, 5, 15 );
        p1.setRadius( 40 );
        
        p2 = new ARegularPoly( 90, 90, 7, 150 );
        p2.setFrameColor( Color.BLUE );
        p2.setRotation( 30 );
        p2.setFillColor( Color.RED );
            
        p3 = new ARegularPoly( 350, 20, 6, 70 );
        p3.setThickness( 5 );
        p3.setFrameColor( Color.YELLOW );
        p3.setRotation( 45 );
        p3.setColor( Color.MAGENTA );
 
        p4 = new ARegularPoly( 65, 65, 3, 90 );
        p4.setLineWidth( 6 );
        p4.setColor( Color.GRAY );
        p4.setLocation( 300, 250 );
        
        p5 = new ARegularPoly( 50, 50, 8, 60 );
        Point q = new Point( 400, 150 );
        p5.setLocation( q );
        p5.getYLocation();
        p5.getXLocation();
        p5.moveBy( 20, 20 );
        p5.setFillColor( Color.ORANGE );
        p5.setFrameColor( Color.BLUE );
           
        
    }
    //------------- paintComponent( Graphics ) ----------------------
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        //////////////////////////////////////////////////////////
        // draw the objects you created in the constructor
        //////////////////////////////////////////////////////////
        Graphics2D brush2D = ( Graphics2D ) g;
        p1.display( brush2D );
        p2.display( brush2D );
        p3.display( brush2D );
        p4.display( brush2D );
        p5.display( brush2D );
    }
    
    //------------------------ main -----------------------------------
    public static void  main( String[] args )
    {
        JFrame f = new JFrame( "ARegularPoly test" );
        f.setSize( 700, 600 );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JPanel panel = new RegularPolyTest();
        f.add( panel );
        f.setVisible( true ); 
    }            
}