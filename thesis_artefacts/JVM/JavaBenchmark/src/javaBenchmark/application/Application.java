package javaBenchmark.application;

import javaBenchmark.data.DataStore;
import javaBenchmark.data.ProcessInstanceData;
import javaBenchmark.logic.Finalization;
import javaBenchmark.logic.FindMax;
import javaBenchmark.logic.InitProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kraussju on 10.11.2016.
 */

public class Application {
    public static void main(String args[]){

            Finalization fin = new Finalization();
            InitProblem init = new InitProblem();

            init.execute();

            ExecutorService pool = Executors.newCachedThreadPool();
            for (int thnr = 0; thnr< DataStore.getProcessInstanceData("id").getThreadAmount(); thnr++)
                pool.execute(new FindMax());
            pool.shutdown();
            try {
                pool.awaitTermination(1, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fin.execute();




    }
}
