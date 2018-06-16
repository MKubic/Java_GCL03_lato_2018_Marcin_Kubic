/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspolbieznosc;

/**
 *
 * @author marcin
 */
public class Tasks implements Task,WorkerListener{
    int number;
    String Name;
    public Tasks(int number1, String Name1){
        this.number=number1;
        this.Name=Name1;
    }
    @Override
    public void onWorkerStarted(){
    }
    @Override
    public void onWorkerStoped(){
    }
    @Override
    public void onTaskStarted( int taskNumber, String taskName ){
        System.out.println("task number" + taskNumber + "started");       
    }
    @Override
    public void onTaskCompleted( int taskNumber, String taskName ){
        System.out.println("task number" + taskNumber + "completed");  
    }
    @Override
    public void run( int taskNumber ) throws InterruptedException{
        System.out.println("running task with number" + taskNumber);  
    }
}
