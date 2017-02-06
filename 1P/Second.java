//+++++++++++++++++++++++++++++ Second.java +++++++++++++++++++++++++++++
//import wheelsunh.users.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/** 
 * Second.java: A simple 2D image of a robot.
 * 
 * @author rdb
 * 
 * Last edited:
 *     01/13/15 rdb: make checkstyle-compatible  
 *                   added coverage computation
 */

public class Second implements AShape
{ 
    //---------------- class variables ---------------------------------
    //--- primitive "coverage" information
    /**
     * CoverageID enum provides a mnemonic code to represent each public method
     *   except display. The display method is not called directly by the app;
     *   it is called asynchronously by the JRE, so it's not guaranteed that
     *   its coverage will get logged before the report is generated.
     */
    private static enum CoverageID 
    {
        ctor_, ctor_ii, ctor_c, setColor_c, setLoc_ii, getX, getY, getColor 
    };
    static boolean[] coverageFlag = // should be same length as enum size (8)
    { false, false, false, false, false, false, false, false };
    
    //---------------- instance variables ------------------------------
    AEllipse    body;
    ARoundRectangle  wheel1;
    ARoundRectangle  wheel2;
    ARectangle  caster;
    ARectangle  head;
    ARectangle  sensor;
    ALine       antenna;
    ARegularPoly poly1;
    ARegularPoly poly2;
    
    ArrayList <AShape> secondArray = new ArrayList <AShape>();
    
    int         x, y;
    Color       bodyColor = java.awt.Color.BLUE;
    
    // ---------------------- Second() ----------------------------------
    /** The constructor creates all the robot parts, and sets a default
      * location and body color (BLUE).
      */
    public Second()
    {   
        secondArray = new ArrayList <AShape>();
        
        wheel1 = new ARoundRectangle( );   
        wheel1.setRoundRect( 20, 10, 20, 40, 40, 10 );
        wheel1.setFrameColor( java.awt.Color.BLACK );
        wheel1.setFillColor( java.awt.Color.YELLOW );
        
        wheel2 = new ARoundRectangle( );     
        wheel2.setRoundRect( 20, 150, 40, 40, 10, 40 );
        wheel2.setFillColor( java.awt.Color.RED );
        wheel2.setFrameColor( java.awt.Color.CYAN );
        
        poly1 = new ARegularPoly( 50, 50, 3, 40 );
        secondArray.add( poly1 );
        poly1.setFillColor( java.awt.Color.BLUE );
        
        poly2 = new ARegularPoly( 90, 150, 6, 40 );
        secondArray.add( poly2 );
        poly2.setFillColor( java.awt.Color.ORANGE );
          
      
        
        covered( CoverageID.ctor_ ); 
    }
    
    // ------------------- Second( int, int ) ---------------------------
    /**
     * Constructor includes an explicit location and default color.
     * 
     * @param xLoc int x-location
     * @param yLoc int y-location
     */
    public Second( int xLoc, int yLoc )
    {   
        this();
        setLocation( xLoc, yLoc );
              
        covered( CoverageID.ctor_ii ); 
    }
    
    // ---------------------- Second( Color ) --------------------------
    /** 
     * Constructor includes explicit color and default location ( 0,0 ).
     * 
     * @param c Color body color
     */
    public Second( Color c )
    {   
        this();
        setColor( c );
        
        
        covered( CoverageID.ctor_c ); 
    }
    
    //--------------------- setColor( Color ) ------------------------- 
    /**
     * set body color to parameter and default colors for all other parts.
     * 
     * @param c Color body color
     */
    public void setColor( Color c )
    {
        bodyColor = c;
        poly1.setFillColor( c );

        covered( CoverageID.setColor_c ); 
    }
    
    //------------------- setLocation( int, int ) --------------------- 
    /**
     * set the location of the robot to the paramters.
     * 
     * @param xLoc int  x-location
     * @param yLoc int  y-locaation
     */
    public void setLocation( int xLoc, int yLoc )
    {
        this.x = xLoc;
        this.y = yLoc;
        
        wheel1.setLocation( x, y + 60 );
        wheel2.setLocation( x + 60, y + 60 );
        
        
       
        poly1.setLocation( x + 35, y + 30 );
       
        
        covered( CoverageID.setLoc_ii ); 
    }
    
    //--------------------- int getXLocation() ------------------------
    /**
     * return the x location of the robot.
     * 
     * @return int x location
     */
    public int getXLocation()
    {
        covered( CoverageID.getX ); 
        return x;       
    }
    
    //--------------------- int getYLocation() ------------------------
    /**
     * return the y location of the robot.
     * 
     * @return int y location
     */
    public int getYLocation()
    {
        covered( CoverageID.getY ); 
        return y;    
    }
    
    //--------------------- int getColor() ----------------------------
    /**
     * return the body color of the robot.
     * 
     * @return Color body color
     */
    public Color getColor()
    {
        covered( CoverageID.getColor );
        return bodyColor;    
    }
    
    //----------------------- display( Graphics2D ) -------------------
    /**
     * display - calls draw and fill awt methods (this is an rdb method).
     * 
     * @param brush2D  java.awt.Graphics2D 
     */
    public void display( java.awt.Graphics2D brush2D )
    {
        ///////////////////////////////////////////////////////////////
        // For every A-object created in the Second constructor (7)
        //   invoke that object's display method with "brush2D" as the 
        //   the parameter:
        //   body, wheel1, wheel2, caster, head, sensor, antenna.
        ///////////////////////////////////////////////////////////////
//        
//        body.display( brush2D );
          wheel1.display( brush2D );
          wheel2.display( brush2D );
//        caster.display( brush2D );
//        head.display( brush2D );
//        sensor.display( brush2D );
//        antenna.display( brush2D );
          poly1.display( brush2D );
          poly2.display( brush2D );
        
    }
    //---------------------- covered( String ) ---------------------------
    /**
     * Confirm that a method has been called, but finding its code in the
     * coverage string and capitalizing it.
     * 
     * @param mId CoverageID
     */
    private static void covered( CoverageID mId )
    {
        coverageFlag[ mId.ordinal() ] = true;
    }   
    //---------------------- coverageInfo() ---------------------------
    /**
     * Return a string describing the current state of coverage information.
     * 
     * @return String
     */
    private static String coverageInfo()
    {
        int methodCount = coverageFlag.length;
        int count = 0;
        for ( int i = 0; i < coverageFlag.length; i++ )
        {
            if ( coverageFlag[ i ] )
                count++;
        }
        System.out.println();
        
        return count + " of " + methodCount + " methods called.";
    }   
    
    //------------------------  main ----------------------------------
    /**
     * Unit test for Second.
     * 
     * @param args String[] Command line araguments
     */
    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Second test" );
        frame.setSize( 400, 300 );  // define window size
        
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        // Second variables need to be "final" in order to be accessed 
        //   inside the implicitly declared anonymous class that extends 
        //   JPanel below.
        
        // Minimal test: use each constructor
        final Second bot1 = new Second();
     

        bot1.getColor();
       
        //////////////////////////////////////////////////////////
        // Create at least 3 additional Seconds.
        //   You must use every method of Second at least once, including the
        //   "get" methods. The coverage is printed at the end; all output 
        //   should be all caps if you have satisfied this requirement.
        ///////////////////////////////////////////////////////////
        
        
       
        // Create anonymous JPanel child w/ override for paintComponent
        JPanel panel = new JPanel()
        {
            public void paintComponent( Graphics g )
            {
                bot1.display( (Graphics2D) g );
                ///////////////////////////////////////////////////
                // invoke display method of the 2nd and 3rd Second
                //       objects.
                ///////////////////////////////////////////////////
           
            
                
            }
        }; 
        frame.add( panel );        // add it to the frame
        frame.setVisible( true );  // make it visible.        
        
        System.out.println( "AWTBOT coverage info: " + Second.coverageInfo() );
    }
}
