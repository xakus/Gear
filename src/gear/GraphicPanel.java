/**
 *
 * @author Murad Salmanov
 */
package gear;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class GraphicPanel extends JPanel implements Runnable {

    public int fSize;
    public int bSize;
    private int[][] matrix;
    long oldTime = System.nanoTime();
    Color bachgroundColor = new Color(10, 170, 25);
    Color borderColor = new Color(10, 170, 25);
    Color emptyColor = new Color(100, 50, 25);// new Color(230, 220, 220);
    Color wallColor = new Color(200, 100, 50);//new Color(10, 170, 25); //new Color(150, 70, 25);
    Color stepColor = new Color(150, 70, 25);//new Color(187, 255, 255);
    Color[] colorOfNumbers = new Color[]{Color.BLUE, Color.GREEN, Color.ORANGE, Color.CYAN,
        Color.RED, Color.MAGENTA, Color.BLACK, Color.PINK};
    double ang = 0;
    Polygon polygon = new Polygon();

    public GraphicPanel(int fSize, int bSize, int[][] matrix) {
        this.matrix = matrix;
        this.fSize = fSize;
        this.bSize = bSize;

        t.start();

    }

    public GraphicPanel() {

        t.start();
    }

    @Override
    public void paint(Graphics g) {
        int width = fSize * bSize;
        int height = fSize * bSize;
        int cell = 0;
        int dearSize = 32;
     
           
            ang -=  (Math.PI/360)*3;
            

        
        g.clearRect(0, 0, g.getClip().getBounds().width, g.getClip().getBounds().height);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, g.getClip().getBounds().width, g.getClip().getBounds().height);
        
        this.setBackground(bachgroundColor);
       
        double dAng =  (360/(dearSize*2));
        g.setColor(Color.darkGray);
        Gear g1=new Gear();
        Gear g2=new Gear();
        Gear g3=new Gear();
        Gear g4=new Gear();
        Gear g5=new Gear();
        Gear g6=new Gear();
        g.fillPolygon(g1.drawGear(100, 100, 40, 50, dearSize, -ang) ); 
        g.setColor(Color.darkGray);
        g.fillPolygon(g2.drawGear(191, 100, 40, 50, dearSize, ang+g1.getRealAngleR()) ); 
        g.setColor(Color.darkGray);
        g.fillPolygon(g3.drawGear(191, 191, 40, 50, dearSize, -ang+g2.getRealAngleR()) ); 
        //drawStar(100, 191, 40, 50, dearSize, -ang + dAng, g, polygon);
        g.setColor(emptyColor);
        g.fillPolygon(g4.drawGear(238, 238, 16, 50/2, dearSize/2, ang+g3.getRealAngleR()+45.0) ); 
        g.setColor(Color.RED);
        g.fillPolygon(g5.drawGear(261, 261, 5, 50/4, dearSize/4,-ang+g4.getRealAngleR()) );   
        g.setColor(Color.black);
        g.fillPolygon(g6.drawGear(261+147, 261+147, 190, 200, dearSize*4,ang+g5.getRealAngleR()) ); 
        super.setBackground(bachgroundColor);
        
    }

    
   
    Thread t = new Thread(this);

    @Override
    public void run() {

        while (true) {
            repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(GraphicPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
