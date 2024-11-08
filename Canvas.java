import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example. 
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 *
 * @version 2006.03.30
 */
public class Canvas
{
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    private static Canvas canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("BlueJ Shapes Demo", 500, 500, 
                                         Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- instance part -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;
    
    /**
     * Create a Canvas.
     * @param title    title to appear in Canvas Frame
     * @param width    the desired width for the canvas
     * @param height   the desired height for the canvas
     * @param bgColor the desired background color of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     * @param  referenceObject  an object to define identity for this shape
     * @param  color            the color of the shape
     * @param  shape            the shape object to be drawn on the canvas
     */
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, String color, Shape shape)
    {
        objects.remove(referenceObject);   // just in case it was already there
        objects.add(referenceObject);      // add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }
 
    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased 
     */
    public void erase(Object referenceObject)
    {
        objects.remove(referenceObject);   // just in case it was already there
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground color of the Canvas.
     * @param  newColor   the new color for the foreground of the Canvas 
     */
    public void setForegroundColor(String colorString)
    {
        if(colorString.equals("red")) {
            graphic.setColor(Color.red);
        }
        else if(colorString.equals("black")) {
            graphic.setColor(Color.black);
        }
        else if(colorString.equals("blue")) {
            graphic.setColor(Color.blue);
        }
        else if(colorString.equals("yellow")) {
            graphic.setColor(Color.yellow);
        }
        else if(colorString.equals("green")) {
            graphic.setColor(Color.green);
        }
        else if(colorString.equals("pink")) {
            graphic.setColor(Color.magenta);
        }
        else if(colorString.equals("white")) {
            graphic.setColor(Color.white);
        }
        else if(colorString.equals("orange")){
            
            graphic.setColor(Color.orange);
        }
        else
        {
            graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * Redraw ell shapes currently on the Canvas.
     */
    private void redraw()
    {
        erase();
        for(Object shape : objects) {
            shapes.get(shape).draw(graphic);
        }
        canvas.repaint();
    }
       
    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }


    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class ShapeDescription
    {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color)
        {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic)
        {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }

}

/**Class Overview
--Canvas Singleton: The class is designed as a singleton, meaning only one instance of Canvas can be created.
 This is enforced by the canvasSingleton static field and getCanvas() factory method. 
 If no instance exists, getCanvas() creates one, otherwise, it returns the existing instance.
--Class Fields

(1)frame: This JFrame object is the main window that displays the canvas.
(2)canvas: An instance of CanvasPane (an inner class extending JPanel) where shapes are drawn.
(3)graphic: A Graphics2D object that provides drawing capabilities for the canvas.
(4)backgroundColor: Specifies the background color of the canvas.
(5)canvasImage: Stores the offscreen image for the canvas, allowing for smoother redrawing.
(6)objects: A list to track the order of objects drawn on the canvas.
(7)shapes: A hashmap to store each shape's reference object and its corresponding ShapeDescription (a helper class).

--Constructor
The constructor is private to enforce singleton behavior.
 It initializes the JFrame and CanvasPane objects, sets the background color,and prepares the objects list and shapes hashmap.

--Core Methods

(1)setVisible(boolean visible):

Makes the Canvas visible and initializes the Graphics2D context if it’s the first time the canvas is displayed. 
The background color is set, and the canvas is prepared for drawing.
draw(Object referenceObject, String color, Shape shape):

(2)Adds or updates a shape on the canvas. 
It associates each shape with a referenceObject (used as a unique identifier), 
stores it in the objects list, and maps it to a ShapeDescription in the shapes hashmap.
 This enables easy management and updating of shapes. The redraw() method is called to refresh the display.
erase(Object referenceObject):

(3)Removes a shape from the objects list and shapes hashmap, then calls redraw() to update the canvas.
setForegroundColor(String colorString):

(4)Sets the color for drawing on the canvas based on a color string (e.g., "red", "blue").
 If an unrecognized color is provided, it defaults to black.
wait(int milliseconds):

(5)Pauses the execution for a specified time, useful for animations.
redraw():

(6)Clears the canvas and redraws each shape in the order specified by objects. 
Each shape’s color and position are restored as they were.
erase():

(7)Clears the entire canvas by filling it with the background color.
 This does not repaint immediately but prepares it for the next redraw() call.
Inner Classes
CanvasPane:

(8)Extends JPanel and overrides paint(Graphics g) to draw canvasImage onto the CanvasPane component,
 ensuring the latest state of canvasImage is always displayed.
ShapeDescription:

(9)Associates a Shape with a specific color. The draw(Graphics2D graphic) method sets the color, 
then draws the shape on the graphic context.
Usage Summary
To use this class:

(10)Call Canvas.getCanvas() to get the singleton instance.
Use draw(referenceObject, color, shape) to draw shapes.
Use erase(referenceObject) to remove specific shapes.
setForegroundColor() and wait() provide additional control for color settings and animations.
This class simplifies shape manipulation on a canvas and is built to support a clean,
 manageable interface for educational purposes, especially for basic graphics projects in environments like BlueJ.


*/






































