/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obsluga_plikow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author marcin
 */
public class ExtendedSystemCache extends SystemCache implements Serializable{
    void exportCSV( String path ) throws IOException{
        PrintWriter Save = new PrintWriter(path);
        for(int i=0;i<this.cache.size();i++){
        Save.println(Inputs[i][0]);
        Save.println(Inputs[i][1]);
        Save.println(Inputs[i][2]);
        Save.println(Inputs[i][3]);
        Save.println(Inputs[i][4]);
        Save.println(this.get(this.Inputs[i]));
        }
        Save.close();
    }
    void importCSV( File file ) throws IOException{
         Scanner in = new Scanner(file);
         String line="a";
         String number;
         int j=0;
         if(in.hasNextLine()){
            while(true){
                line="";
                for(int i=0;i<6;i++){   
                    line=in.nextLine();
                    if(i!=5){
                        this.Inputs[j][i]=Double.parseDouble(line);
                    }else{
                        this.put(this.Inputs[j],Double.parseDouble(line));
                    }
                }
                j++;
                if(!in.hasNextLine())
                    break;
            }
        }
        System.out.println(j);
        this.i=j;
        in.close();
    }
    void serialize( String path ) throws IOException{
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(path));
        outputStream.writeObject(this);
    }
    
    void deserialize( String path ) throws IOException, ClassNotFoundException{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        ExtendedSystemCache cachee=new ExtendedSystemCache();
        cachee=(ExtendedSystemCache) inputStream.readObject();
        this.Inputs=cachee.Inputs;
        this.cache=cachee.cache;
        this.i=cachee.i;
    }
}
