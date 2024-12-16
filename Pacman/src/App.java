import javax.swing.JFrame;               //Used to create a window

/** 
JFrame frame = new JFrame("My First Window");                    Creates a new JFrame with the title "My First Window".
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            Ensures that the program will exit when the window is closed.
frame.setSize(400, 300);                                         Sets the dimensions of the window to 400 pixels wide and 300 pixels tall.
frame.setVisible(true);                                          Makes the window visible on the screen
frame.add(object/Component)                                      Used to add a component to the JFrame window
**/

/** Frame - 40px and 15 columns to 20 rows */

public class App {
    public static void main(String[] args) throws Exception {

       int row = 21;
       int  col = 19;
       int pixsize = 32;
       int rowc = row*pixsize;     //Each unit has 40 pixsize so totally 20 units makes a row
       int colc = col*pixsize;

       JFrame frame = new JFrame("Pac Man Time :)"); 

       frame.setVisible(true);
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       frame.setResizable(false);          //Used to resize the Window
       

       //Adding a component

       FrameComponent comp1 = new FrameComponent();
       frame.add(comp1);
 
       comp1.requestFocus();
       frame.pack();
       frame.setVisible(true);
   }
    

    }

