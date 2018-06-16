/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junity;

import static java.lang.Math.*;

/**
 *
 * @author marcin
 */
public class BasicCalculator {
    public double calculateSum(double component1, double component2){
        return component1+component2;
    }
    public double calculateDifference(double minuend, double substrahend){
        return minuend-substrahend;
    }
    public double calculateMultiplication(double factor1, double factor2){
        return factor1*factor2;
    }  
    public double calculateDivision(double dividend, double divider)throws IllegalArgumentException{
        if(divider == 0.0){
            throw new IllegalArgumentException("data is invalid");
        }
        else
        return dividend/divider;
    } 
    public double calculateSqlr(double number)throws IllegalArgumentException{
        if(number < 0){
            throw new IllegalArgumentException("data is invalid");
        }
        return sqrt(number);
    }  
    public double calculatePow(double basis, double index){
        return pow(basis,index);
    }  
}
