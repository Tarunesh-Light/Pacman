import java.awt.*;
import java.awt.event.*;

//Used to add components inside JFrame
import javax.swing.*;

import java.util.Random;


/**
setLayout(LayoutManager layout):                     Sets the layout manager for the JPanel. This defines how the components within the panel are arranged.

Example: panel.setLayout(new FlowLayout());
getLayout():                                         Returns the current layout manager of the JPanel.

setPreferredSize(Dimension preferredSize):           Sets the preferred size of the JPanel. This is used by layout managers to determine how to size the panel.

Example: panel.setPreferredSize(new Dimension(300, 200));
setMinimumSize(Dimension minSize):                   Sets the minimum size of the JPanel. The layout manager will respect this when determining the size of the panel.

setMaximumSize(Dimension maxSize):                   Sets the maximum size of the JPanel. The layout manager will respect this when determining the size of the panel
*/


public class FrameComponent extends JPanel implements ActionListener,KeyListener{

    int row = 21;
    int  col = 19;
    int pixsize = 32;
    int rowc = row*pixsize;     //Each unit has 40 pixsize so totally 20 units makes a row
    int colc = col*pixsize;
    int pacmanx;
    int pacmany;
    int pacx = 288;
    int pacy =480;
    int gridX;
    int gridY;
    int rgridX;
    int rgridY;
    int redx = 288;
    int redy = 256;
    int bluex = 256;
    int bluey = 288;
    int redeaten=0;
    int i=0;
    int redmove = 0;
    
    Image blueghost;
    Image orangeghost;
    Image pinkghost;
    Image redghost;
    Image sacredghost;

    Image cherry;
    Image food;
    Image wallss;
    Image wallblack;
    
    Image pacmanUpImage;
    Image pacmanDownImage;
    Image pacmanLeftImage;
    Image pacmanImg;
     
    char[][] tileMap = {
        "XXXXXXXXXXXXXXXXXXX".toCharArray(),
        "X        X        X".toCharArray(),
        "X XX XXX X XXX XX X".toCharArray(),
        "X                 X".toCharArray(),
        "X XX X XXXXX X XX X".toCharArray(),
        "X    X       X    X".toCharArray(),
        "XXXX XXXX XXXX XXXX".toCharArray(),
        "OOOX X       X XOOO".toCharArray(),
        "XXXX X XXrXX X XXXX".toCharArray(),
        "O       bpo       O".toCharArray(),
        "XXXX X XXXXX X XXXX".toCharArray(),
        "OOOX X       X XOOO".toCharArray(),
        "XXXX X XXXXX X XXXX".toCharArray(),
        "X        X        X".toCharArray(),
        "X XX XXX X XXX XX X".toCharArray(),
        "X  X     P     X  X".toCharArray(),
        "XX X X XXXXX X X XX".toCharArray(),
        "X    X   X   X    X".toCharArray(),
        "X XXXXXX X XXXXXX X".toCharArray(),
        "X                 X".toCharArray(),
        "XXXXXXXXXXXXXXXXXXX".toCharArray()
    };

    int numberOfRows = tileMap.length;
    int numberOfColumns = tileMap[0].length;

    Random random = new Random();

    FrameComponent(){
    
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(col * pixsize, row * pixsize));

    addKeyListener(this);
    setFocusable(true);

    wallss= new ImageIcon(getClass().getResource("./wall.png")).getImage();
    wallss = wallss.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);
    wallblack = new ImageIcon(getClass().getResource("./wallblack.png")).getImage();
    wallblack = wallss.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

    pacmanImg = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
    pacmanImg = pacmanImg.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

    blueghost = new ImageIcon(getClass().getResource("./blueghost.png")).getImage();
    blueghost = blueghost.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

    orangeghost = new ImageIcon(getClass().getResource("./orangeghost.png")).getImage();
    orangeghost = orangeghost.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

    redghost = new ImageIcon(getClass().getResource("./redghost.png")).getImage();
    redghost = redghost.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

    pinkghost = new ImageIcon(getClass().getResource("./pinkghost.png")).getImage();
    pinkghost = pinkghost.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

    food = new ImageIcon(getClass().getResource("./powerFood.png")).getImage();
 

    if (wallss == null) {
        System.out.println("Wall image not found!");
    }

    
    Timer timer = new Timer(20,this);
    timer.start();

    }

    public void paintComponent(Graphics g) {

        
        super.paintComponent(g);
        draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
 
    public void move(){
        
        int a = random.nextInt(4) +1 ;
       
        rgridX = this.redx / pixsize;
        rgridY = this.redy / pixsize;
    
        if (redmove % 3==0){
        if(a==1)
        {
        if(tileMap[rgridY+1][rgridX]!='X' && rgridY+1 <=numberOfRows) 
        this.redy+=pixsize;
        }

        else if(a==2)
        {
            if(tileMap[rgridY-1][rgridX]!='X'  && rgridY-1 >0)
            this.redy-=pixsize;
        }
        
        else if(a==3){
            if(tileMap[rgridY][rgridX+1]!='X' && rgridX+1 <=numberOfColumns)
            this.redx+=pixsize;
        }
        else if(a==4){
            if(tileMap[rgridY][rgridX-1]!='X'&& rgridX-1 > 0)
            this.redx-=pixsize;}
        }
        redmove+=1;
           // System.out.println(redeaten);
           System.out.println("HHHHH" +redmove);
      
    }

    public void draw(Graphics g) {
       
        int x=0;
        int y=0;


        for(int i=0;i<row;i++,y+=pixsize)
        {
            for(int j=0;j<col;j++){
              
                if(tileMap[i][j]=='X')
                {
                    g.drawImage(wallss, x, y, this);
                    x += pixsize;
                } 
                else if(tileMap[i][j]=='P')
                {   
                    g.drawImage(pacmanImg, this.pacx, this.pacy, this);
                    x += pixsize;
                }
                else if(tileMap[i][j]=='p')
                {  
                    g.drawImage(pinkghost, x, y, this);
                    x += pixsize;
                }
                else if(tileMap[i][j]=='b')
                {  
                    g.drawImage(blueghost, this.bluex, this.bluey, this);
                    x += pixsize;
                }
                else if(tileMap[i][j]=='r')
                {  
                //    System.out.println(x + "gap"+y);
                    if(redeaten==0) {
                    g.drawImage(redghost, this.redx, this.redy, this);
                    x += pixsize;}
                    else if(redeaten == 1){
                        x+=pixsize;
                    }
                    
                }
                else if(tileMap[i][j]=='o')
                {  
                    g.drawImage(orangeghost, x, y, this);
                    x += pixsize;
                }
                else if(tileMap[i][j]=='q')
                {
                    x += pixsize;
                }
                else{
                    x += pixsize/2;
                    y += pixsize/2;
                    g.drawImage(food, x, y, this);
                    x -= pixsize/2;
                    y -= pixsize/2;
                    x+=pixsize;
                }
            } x=0;
        }
     
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
 
    void movement(int key){

        gridX = pacx / pixsize;
        gridY = pacy / pixsize;

        int collisionThreshold = pixsize;

        if(Math.abs(pacx - redx) < collisionThreshold && Math.abs(pacy - redy) < collisionThreshold){
            redeaten = 1;
        }
    
        System.out.println("press");


        if(key == KeyEvent.VK_S && tileMap[gridY+1][gridX]!='X'){
        this.pacy += pixsize;
        this.pacmanImg = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        this.pacmanImg = pacmanImg.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

        if(tileMap[gridY+1][gridX]==' ')
                {
                    System.out.println("downn");
                    tileMap[gridY+1][gridX] ='q';
                }
        }
       
        else if(key == KeyEvent.VK_W && tileMap[gridY-1][gridX]!='X'){
            this.pacy -= pixsize;
            this.pacmanImg = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
            this.pacmanImg = pacmanImg.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);
            
            if(tileMap[gridY-1][gridX]==' ')
                {
                    tileMap[gridY-1][gridX] ='q';
                }
        }
        else if(key == KeyEvent.VK_D &&  tileMap[gridY][gridX + 1]!='X')
        {
            this.pacx += pixsize;
            this.pacmanImg = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
            this.pacmanImg = pacmanImg.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);
            
            if(tileMap[gridY][gridX+1]==' ')
                {
                    tileMap[gridY][gridX+1] ='q';
                }
        }
        else if(key == KeyEvent.VK_A && tileMap[gridY][gridX - 1]!='X' )
        {
            this.pacx -= pixsize;
            this.pacmanImg = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
            this.pacmanImg = pacmanImg.getScaledInstance(pixsize, pixsize, Image.SCALE_SMOOTH);

            if(tileMap[gridY][gridX-1]==' ')
                {
                    tileMap[gridY][gridX-1] ='q';
                }
        }

       

    }
    @Override
    public void keyReleased(KeyEvent e) {
      
       
        System.out.println(e.getKeyCode());
        movement(e.getKeyCode());
    } 

  
}
