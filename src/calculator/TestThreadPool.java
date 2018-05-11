import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {  
     public static void main(String[] args) {  
        ExecutorService executor = Executors.newFixedThreadPool(50000);//creating a pool of 5 threads  
        EvaluateExpresion evaluateExpresion = new EvaluateExpresion();
        for (int i = 0; i < 50100; i++) {  
            Runnable worker = new WorkerThread("" + i, evaluateExpresion);  
            executor.execute(worker);//calling execute method of ExecutorService  
          }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
  
        System.out.println("Finished all threads");  
    }  
 }  