public class Picture {
    // Declare components of the picture
    private Square vehicleBody;
    private Square vehicleWindow;
    private Square additionalSquare; // New additional square
    private Circle wheel1;
    private Circle wheel2;
    private Triangle treeTop;
    private Square treeBase;
    private Circle sun;

    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // Initialize components for the picture
        vehicleBody = new Square();
        vehicleWindow = new Square();
        additionalSquare = new Square(); // Initialize the additional square
        wheel1 = new Circle();
        wheel2 = new Circle();
        treeTop = new Triangle();
        treeBase = new Square();
        sun = new Circle();
    }

    /**
     * Draw this custom picture.
     */
    public void draw() {
        // Vehicle Body settings
        vehicleBody.changeColor("blue");
        vehicleBody.moveVertical(150);  // Position the vehicle body lower
        vehicleBody.moveHorizontal(50);
        vehicleBody.changeSize(70);
        vehicleBody.makeVisible();

        // Vehicle Window settings
        vehicleWindow.changeColor("pink");
        vehicleWindow.moveVertical(160); // Position the window slightly lower to fit within the vehicle body
        vehicleWindow.moveHorizontal(95);
        vehicleWindow.changeSize(20);
        vehicleWindow.makeVisible();

        // Vehicle's trunk settings (e.g., could be a chimney or other feature)
        additionalSquare.changeColor("blue");
        additionalSquare.moveVertical(180); // Position it at the same level as the window
        additionalSquare.moveHorizontal(110); // Offset slightly to the right of the vehicle
        additionalSquare.changeSize(40);
        additionalSquare.makeVisible();

        // Wheels of the Vehicle
        wheel1.changeColor("black");
        wheel1.moveHorizontal(150);
        wheel1.moveVertical(200);  // Position the wheel below the vehicle body
        wheel1.changeSize(20);
        wheel1.makeVisible();

        wheel2.changeColor("black");
        wheel2.moveHorizontal(105);
        wheel2.moveVertical(200);  // Position the second wheel below the vehicle body
        wheel2.changeSize(20);
        wheel2.makeVisible();

        // Tree Top settings
        treeTop.changeColor("green");
        treeTop.changeSize(100, 40);
        treeTop.moveHorizontal(220);
        treeTop.moveVertical(140);  // Position the tree top higher
        treeTop.makeVisible();

        // Tree Base settings
        treeBase.changeColor("red");
        treeBase.moveVertical(210);  // Position the tree base below the tree top
        treeBase.moveHorizontal(200);
        treeBase.changeSize(20);
        treeBase.makeVisible();

        // Sun settings
        sun.changeColor("yellow");
        sun.moveHorizontal(170);
        sun.moveVertical(50);  // Position the sun in the sky
        sun.changeSize(50);
        sun.makeVisible();
    }

    /**
     * Change this picture to black-and-white display
     */
    public void setBlackAndWhite() {
        vehicleBody.changeColor("black");
        vehicleWindow.changeColor("white");
        additionalSquare.changeColor("black");
        wheel1.changeColor("black");
        wheel2.changeColor("black");
        treeTop.changeColor("black");
        treeBase.changeColor("black");
        sun.changeColor("black");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor() {
        vehicleBody.changeColor("blue");
        vehicleWindow.changeColor("black");
        additionalSquare.changeColor("red");
        wheel1.changeColor("black");
        wheel2.changeColor("black");
        treeTop.changeColor("green");
        treeBase.changeColor("red");
        sun.changeColor("yellow");
    }
}


/**The Picture class represents a scene consisting of a vehicle, tree, and sun, constructed from various shape components. 
 *Each shape (like Square, Circle, and Triangle) is represented by an object with configurable properties such as color, position, and size. 
 
Class Fields
The class has several fields that store the different components of the picture:

Vehicle components: vehicleBody, vehicleWindow, additionalSquare, wheel1, and wheel2.
Tree components: treeTop and treeBase.
Sun: sun.
Each of these fields represents a part of the scene and is an instance of a particular shape class.

Constructor
java
Copy code
public Picture()
The constructor initializes each shape component by creating new instances of Square, Circle, or Triangle.
 This step prepares the objects for use in the draw method.

Draw Method
The draw() method positions and displays each shape to create the picture.

Vehicle Body:

The vehicleBody is a blue square moved to a lower position (vertical 150) and positioned horizontally at 50.
 Its size is set to 70, making it large enough to serve as the main body of the vehicle.
Vehicle Window:

The vehicleWindow is a pink square positioned within the vehicleBody to look like a window.
 It is slightly smaller, with a size of 20, and positioned at 160 vertical and 95 horizontal.
Additional Square (Trunk):

additionalSquare is another part of the vehicle, colored blue, and positioned at 180 vertically and 110 horizontally, slightly offset to the right. 
It’s sized 40, suggesting it might represent something like a chimney or trunk on the vehicle.
Vehicle Wheels:

wheel1 and wheel2 are black circles, each with a size of 20, representing the vehicle's wheels. 
They are positioned just below the vehicle body at 200 vertical. The wheels are horizontally spaced, with wheel1 at 150 and wheel2 at 105.
Tree:

Tree Top: treeTop is a green triangle with a larger width (100) than height (40), creating a cone shape for the top of the tree. 
It is positioned at 220 horizontal and 140 vertical.
Tree Base: treeBase is a small red square, representing the trunk, positioned below the treeTop at 210 vertical and 200 horizontal.
Sun:

sun is a yellow circle representing the sun, placed at 50 vertical and 170 horizontal, with a size of 50 to make it large and noticeable in the sky.
Color Manipulation Methods
The class includes two methods to switch the scene between color and black-and-white modes:

setBlackAndWhite():

Changes each component’s color to either black or white.
The vehicleWindow is white to represent contrast, while all other components are set to black.
setColor():

Restores the original color scheme for each component (e.g., blue for the vehicleBody, yellow for the sun, green for the treeTop, etc.).
These methods allow the scene to switch between two different visual styles dynamically.

*/




































