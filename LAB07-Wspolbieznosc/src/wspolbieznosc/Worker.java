/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspolbieznosc;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcin
 */
public class Worker extends Thread implements WorkerListener{
    public Thread thread=new Thread();
    public List<Tasks> tasklist=new LinkedList();
    public boolean started = false;
    public boolean action = false;
    public Worker(String WorkerName){
        String FullName="Worker"+WorkerName+"Thread";
        thread.setName(FullName);
    }
    void enqueueTask(Tasks task ) {
        tasklist.add(task);
    }
    @Override
    public void run(){
        this.onWorkerStarted();
        System.out.println("runned");
        for (Tasks tasklist1 : tasklist) {
            tasklist1.onTaskStarted(tasklist1.number, tasklist1.Name);
                        try {
            tasklist1.run(tasklist1.number);
            }catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }

            tasklist1.onTaskCompleted(tasklist1.number, tasklist1.Name);
        }
        this.onWorkerStoped();
        action=false;
    }
    void Start(){
        if(this.isStarted()==false){
            started=true;
            action=true;
            this.start();
        }else
            System.out.println("thread has already started");
    }
    void Stop() throws InterruptedException{
        if(started==true){
            if(action==false){
                started=false;
                this.stop();
            }else{
                while(action==true){
                    this.sleep(5000);
                }
                started=false;
                this.stop();
                System.out.println("thread stopped");
            }
        }    
    }
    void setListener( WorkerListener worklistener ){
    
    }
    boolean isStarted(){
        if(started==true)
            return true;
        else
            return false;
    }
    boolean isWorking(){
        if(action==true)
            return true;
        else
            return false;
    }
    @Override
    public void onWorkerStarted(){
        System.out.println("worker started");
    }
    @Override
    public void onWorkerStoped(){
        System.out.println("worker stopped");
    }
    @Override
    public void onTaskStarted( int taskNumber, String taskName ){  
    }
    @Override
    public void onTaskCompleted( int taskNumber, String taskName ){
    }
}
