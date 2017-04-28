/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gear;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author Murad Salmanov
 */
public class Gear {

    private double koordX,
            koordY,
            innerRadius,
            outerRadius,
            startAngleR,
            realAngleR,
            startAngLenght,
            stepLenght;
    private int numRays;
    private int[] x, y;
    private double lenght=0.0;
    private Polygon polygon;

    public double getKoordX() {
        return koordX;
    }

    public void setKoordX(double koordX) {
        this.koordX = koordX;
    }

    public double getKoordY() {
        return koordY;
    }

    public void setKoordY(double koordY) {
        this.koordY = koordY;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    public double getStartAngleR() {
        return startAngleR;
    }

    public void setStartAngleR(double startAngleR) {
        this.startAngleR = startAngleR;
    }

    public double getRealAngleR() {
        return realAngleR;
    }

    public void setRealAngleR(double realAngleR) {
        this.realAngleR = realAngleR;
    }

    public int getNumRays() {
        return numRays;
    }

    public void setNumRays(int numRays) {
        this.numRays = numRays;
    }
    
   public double getLenght (){
       return lenght;
   }
   public static double degreeToRadian(double angle){
       double radian ;
       radian=(angle*Math.PI)/180.0;
       return radian; 
   }
     public static double radianToDegree(double angle){
       double radian ;
       radian=(angle*180.0)/Math.PI;
       
       return radian; 
   }
    public double startAngLenght(){
        double l;
        l= degreeToLenght((180.0/(double)(numRays)));
        return l;
    }
    private double radianToLenght(double angle) {

       // realAngleR =(angleToRadian((180.0/(double)(numRays)))+angle);
        realAngleR =radianToDegree(angle);
        lenght=(Math.PI*outerRadius*realAngleR)/180.0;
        return lenght;
    }
    private double degreeToLenght(double angle) {

       // realAngleR =(angleToRadian((180.0/(double)(numRays)))+angle);
        realAngleR =angle;
        lenght=(Math.PI*outerRadius*realAngleR)/180.0;
        return lenght;
    }
   private double lengthToRadian(double l){
       return degreeToRadian(((180.0*l)/(Math.PI*outerRadius)));
   }
   private double lengthToDegree(double l){
       return ((180.0*l)/(Math.PI*outerRadius));
   }
    public Gear() {

        this.koordX = 0;
        this.koordY = 0;
        this.innerRadius = 0;
        this.outerRadius = 0;
        this.startAngleR = 0;
        this.numRays = 0;
        x = new int[numRays * 2];
        y = new int[numRays * 2];
    }

    public Gear(double koordX,
            double koordY,
            double innerRadius,
            double outerRadius,
            int numRays,
            double startAngleR) {
        x = new int[numRays * 2];
        y = new int[numRays * 2];
        this.koordX = koordX;
        this.koordY = koordY;
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.startAngleR = startAngleR;
        this.numRays = numRays;
        polygon = drawGear(koordX, koordY, numRays, startAngleR,0,0);
    }

    public Polygon drawGear(double koordX, double koordY,
            int numRays,double startAngleR,double stepLenght,double startAngLenght ) {
            
        this.stepLenght=stepLenght;
        this.koordX = koordX;
        this.koordY = koordY;
        this.startAngleR =degreeToRadian(startAngleR) ;
        this.numRays = numRays*2;
        this.outerRadius= (numRays*this.stepLenght)/(2*Math.PI);
        this.innerRadius=this.outerRadius-8.0;
        this.startAngLenght=startAngLenght;
        radianToLenght(this.startAngleR);
        x = new int[numRays * 2];
        y = new int[numRays * 2];
        //angleToLenght(lengthToAngle(this.startAngleR ));
        polygon = new Polygon();
        double deltaAngleR = Math.PI / (double)  this.numRays;
        for (int i = 0; i <  this.numRays * 2.0; i++) {
            //double angleR =lengthToAngle(angleToLenght(lengthToAngle(this.startAngleR )+angleToRadian(angle)))+ (double) i * deltaAngleR;
            double angleR =lengthToRadian(this.startAngleR)+(double) i * deltaAngleR;
            double ca = Math.cos(angleR);
            double sa = Math.sin(angleR);
            double relX = ca;
            double relY = sa;
            if ((i & 2) == 0) {
                relX *=  this.outerRadius;
                relY *=  this.outerRadius;
            } else {
                relX *=   this.innerRadius;
                relY *=   this.innerRadius;
            }

            //x[i] = (int) (koordX + relX);
           // y[i] = (int) (koordY + relY);

            polygon.addPoint((int) (koordX + relX), (int) (koordY + relY));

        }

        // g.fillPolygon(p);
        // g.setColor(Color.CYAN);
        // g.fillOval((int) (koordX - (innerRadius / 4)), (int) (koordY - (innerRadius / 4)), (int) ((innerRadius / 2)), (int) ((innerRadius / 2)));
        return polygon;
    }
    public Polygon getPolygon() {
        return polygon;
    }
}
