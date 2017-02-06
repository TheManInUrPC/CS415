/** 
 * AWTPanel.java: Swing panel for AWT draw assignment.
 * 
 * This is a framework for the main display window for an 
 * awt application. 
 *      
 * @author rdb
 * 01/10/08 
 * 01/22/11 rdb modified for start code for P1, Spring 2011
 */

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class AWTPanel extends JPanel
{ 
    //-------------------- instance variables ----------------------
    //
    // declare here (among other things) the variables that reference
    //   AWT display objects (ellipses, rectangles, lines, etc.)
    //private House     robot1, robot2;
    
    ArrayList <AShape> shapeList = new ArrayList <AShape>();
    
    private First frst1;
    private First frst2;
    
    //------------- Constructor ---------------------------------
    /**
     * Create awt objects to be displayed.
     */
    public AWTPanel( String [] args ) 
    {
        // Create objects you want to display using awt graphical objects.
        // Use wheels-like "wrapper" classes, ARectangle, AEllipse, ALine
        // The ARectangle and AEllipse classes are minor variations of
        // SmartRectangle and SmartEllipse from the Sanders and van Dam.
        //
        // References to the objects you create need to be saved in an
        //   ArrayList or Vector of AShape objects.
        //
        
        this.shapeList = new ArrayList <AShape>();

        makeScene();
       
        
    }  
    
    //------------------- makeScene() ----------------------------
    /**
     * Create the objects that make up the scene.
     */
    private void makeScene()
    {
   
        ARectangle rect1 = new ARectangle( Color.BLUE );
        rect1.setLocation( 100, 100 );
        rect1.setSize( 40, 40 );
        shapeList.add( rect1 );
        
        ARectangle rect2 = new ARectangle( Color.RED );
        rect2.setLocation( 200, 200 );
        rect2.setSize( 20, 60 );
        shapeList.add( rect2 );
        
        ALine line1 = new ALine();
        line1.setColor( Color.BLACK );
        line1.setPoints( 120, 120, 210, 230 );
        shapeList.add( line1 );
        
        AEllipse ell1 = new AEllipse( Color.CYAN );
        ell1.setLocation( 10, 400  );
        ell1.setSize( 40, 10 );
        shapeList.add( ell1 );
        
        AEllipse ell2 = new AEllipse( Color.MAGENTA );
        ell2.setLocation( 400, 400 );
        ell2.setSize( 30, 30 );
        shapeList.add( ell2 );
        
        ALine line2 = new ALine();
        line2.setColor( Color.BLACK );
        line2.setPoints( 25, 405, 415, 415 );  
        shapeList.add( line2 );
      
        ARoundRectangle roundRect1 = new ARoundRectangle( Color.ORANGE );
        shapeList.add( roundRect1 );
        
        ARoundRectangle roundRect2 = new ARoundRectangle( 50, 50 );
        shapeList.add( roundRect2 );
        
        frst1 = new First( 300, 20 );
        shapeList.add( frst1 );
        
        frst2 = new First( 150, 20 );
        shapeList.add( frst2 );
    
    }
    
    //------------- paintComponent ---------------------------------------
    /**
     * This method is called from the Java environment when it determines
     * that the JPanel display should be updated; you need to 
     * make appropriate calls here to re-draw the graphical images on
     * the display. Each object created in the constructor above should 
     * have its "fill" and/or "draw" methods invoked with a Graphics2D 
     * object. The Graphics object passed to paintComponent will be a 
     * a Graphics2D object, so it can be coerced to that type and
     * passed along to the "display" method of the objects you created.
     * 
     * Note that the "display" method is not an awt method; it is a
     * convenience method defined by the "wrapper" classes. 
     * The display method usually passes the graphical objects to both 
     * the Graphics2D.fill and Graphics2D.draw methods, except in the 
     * case of ALine graphical objects which cannot be "filled".
     */
    public void paintComponent( Graphics aBrush )
    {
        super.paintComponent( aBrush );
        Graphics2D newBrush = (Graphics2D) aBrush; // coerce to Graphics2D
        
        //////////////////////////////////////////////////////////////
        // invoke display( newBrush ) for all A-objects in scene
        //////////////////////////////////////////////////////////////
        
         for ( int i = 0; i < shapeList.size(); i++ ) 
        {
                 shapeList.get( i ).display( newBrush );
        }
    }
    //-------------------- main ------------------------------------------
    /**
     * Invoke AWTApp.main
     */
    public static void main( String[] args )
    {
        AWTApp.main( args );
    }
}
