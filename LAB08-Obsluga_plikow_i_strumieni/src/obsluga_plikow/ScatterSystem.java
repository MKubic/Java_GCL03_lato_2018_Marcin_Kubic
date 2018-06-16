/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obsluga_plikow;

/**
 *
 * @author marcin
 */
class ScatterSystem {

    Double makeOperation(double[] input) {
        double wynik=1;
        for(int i=0;i<5;i++){
            wynik*=input[i];
        } 
        return wynik;
    }
    
}
