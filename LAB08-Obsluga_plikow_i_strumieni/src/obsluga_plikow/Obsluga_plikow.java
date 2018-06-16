/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obsluga_plikow;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
/**
 *
 * @author marcin
 */
public class Obsluga_plikow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        File Database=new File("Database.txt");
        String FileName="Database.txt";
        String FileName1="objects.bin";
        Random r = new Random();
        ScatterSystem system = new ScatterSystem(); // można umieścić wewnątrz dowolną funkcję matematyczną
        ExtendedSystemCache cache = new ExtendedSystemCache();
        double[] input=new double[5] ;
        double[] input1=new double[5] ; 
        for(int i=0;i<5;i++){
            input[i]=(r.nextInt(1000)+100)/100.0;
            input1[i]=(r.nextInt(1000)+100)/100.0;
        }    
        Double output = cache.get( input );
        Double output1= cache.get(input);
        //cache.importCSV(Database);
        if( output == null ){
            output = system.makeOperation( input );
            cache.put( input, output );
        }
        if( output1 == null ){
            output1 = system.makeOperation( input1 );
            cache.put( input1, output1 );
        }

        if(Objects.equals(output, output1)) {
            System.out.println("worth");
        } else {
            System.out.println("not ");
        }
        cache.deserialize(FileName1);
        cache.serialize(FileName1);
        //cache.exportCSV(FileName);
    }
    
}
