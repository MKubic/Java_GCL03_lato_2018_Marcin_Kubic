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
public class Wspolbieznosc {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Worker worker1=new Worker("mojworker");
        Tasks task1=new Tasks(1,"task1");
        Tasks task2=new Tasks(2,"task2");
        Tasks task3=new Tasks(3,"task3");
        Tasks task4=new Tasks(4,"task4");
        worker1.enqueueTask(task1);
        worker1.enqueueTask(task2);
        worker1.enqueueTask(task3);
        worker1.enqueueTask(task4);
        worker1.Start();
        Thread.sleep(2000);
        if(worker1.isStarted())
            System.out.println("//////////isStarted/////////////////");
        if(worker1.isWorking())
            System.out.println("//////////isWorking//////////");
        worker1.Stop();
        if(worker1.isStarted())
            System.out.println("//////////isStarted/////////////////");
        if(worker1.isWorking())
            System.out.println("//////////isWorking//////////");
    }
    
}
