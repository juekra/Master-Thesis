package camunda.logic;

import camunda.data.ProcessInstanceData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kraussju on 10.11.2016.
 */
public class InitProblem implements JavaDelegate {
    private int n = 100000;
    public void execute(DelegateExecution execution) throws Exception {
        ProcessInstanceData.threadAmount = 2;
        ProcessInstanceData.repetitions = 1000;
        ProcessInstanceData.counter = -1;
        ProcessInstanceData.startList = new  LinkedList<Integer>();
        ProcessInstanceData.intermediantresultList = new Vector<Integer>();
        int primeNumber = 500009;


        for (int i=0;i<n;i++)
            ProcessInstanceData.startList.add(500009);

        System.out.println("Parallel Gateway 2x");
        System.out.println("Thread amount: " + ProcessInstanceData.threadAmount);
        System.out.println("Test size: " + ProcessInstanceData.startList.size());
        System.out.println("Test number: " + primeNumber);
        System.out.println("Test repetitions: " + ProcessInstanceData.repetitions);

        ProcessInstanceData.start = System.currentTimeMillis();
    }
}
