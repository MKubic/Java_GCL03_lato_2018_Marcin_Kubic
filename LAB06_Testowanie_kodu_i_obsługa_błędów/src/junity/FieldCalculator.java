/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junity;

/**
 *
 * @author marcin
 */
public class FieldCalculator {
    
    public double calculateSquare(double side)throws IllegalArgumentException{
        if(side <= 0 ){
            throw new IllegalArgumentException("data is invalid");
        }
        return side*side;
    }
    public double calculateCircle(double radius)throws IllegalArgumentException{
        if(radius <= 0){
            throw new IllegalArgumentException("data is invalid");
        }
        return 3.14*radius*radius;
    }
    public double calculateTriangle(double basis, double height)throws IllegalArgumentException{
        if(basis <= 0 || height <= 0){
            throw new IllegalArgumentException("data is invalid");
        }
        return basis*height/2;
    }
    public double calculateRectangle(double sideA, double sideB)throws IllegalArgumentException{
        if(sideA <= 0 || sideB <= 0){
            throw new IllegalArgumentException("data is invalid");
        }
        return sideA*sideB;
    }            
}
