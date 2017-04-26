/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gear;

/**
 *
 * @author Murad Salmanov
 */
public class Machine {

    /**
     * @param args the command line arguments
     */
    
        int cellSize=8;
    int dx=6,dy=30;
    int width=100*cellSize+dx;
    int height=100*cellSize+dy;
   
    
    WindowForm wf;
    GraphicPanel graphicPanel;
    public Machine(){
        graphicPanel=new GraphicPanel();
        wf=new WindowForm(width, height, "GEAR");
        wf.add(graphicPanel);
        wf.setVisible(true);
    }
    public static void main(String[] args) {
        new Machine();
    }
    
}
