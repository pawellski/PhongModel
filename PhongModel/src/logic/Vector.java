/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Paweł
 */
public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void normalize(){
        double length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        if(length != 0){
            x = x/length;
            y = y/length;
            z = z/length;
        } else{
            x = 0;
            y = 0;
            z = 0;
        }
    }
    
    public Vector mulitplyVectorByConst(double constant){
        return new Vector(x*constant, y*constant, z*constant);
    }
    
    public double mulitpyVectorByVector(Vector vector){
        return x*vector.getX() + y*vector.getY() + z*vector.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Vector [X=" + x + " Y=" + y + " Z=" + z + "]";
    }
}
