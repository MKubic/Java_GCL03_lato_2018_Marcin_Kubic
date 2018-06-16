/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obsluga_plikow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author marcin
 */
public class SystemCache implements Serializable{
    public HashMap<Parameter, Double> cache = new HashMap<>();
    public double [][]Inputs=new double[100][5];
    public int i=0;
    public void put( double[] input, double output ){
        this.cache.put( new Parameter( input ), output );
        Inputs[i]=input;
        i++;
    }
    public Double get( double[] input ){
        return this.cache.get( new Parameter( input ) );
    }
    private class Parameter implements Serializable{
        private double[] values;
        public Parameter( double[] values ){
            this.values = values;
        }
        @Override
        public int hashCode(){
            return 31 + Arrays.hashCode( this.values );
        }
        @Override
        public boolean equals( Object obj ){
            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( this.getClass() != obj.getClass() )
                return false;
            Parameter other = (Parameter) obj;
            if ( !Arrays.equals( this.values, other.values ) )
                return false;
            
            return true;
        }
    }
}
