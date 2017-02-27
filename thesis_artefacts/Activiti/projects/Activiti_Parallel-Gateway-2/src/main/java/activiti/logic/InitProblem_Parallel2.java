package activiti.logic;

import java.util.LinkedList;
import java.util.Vector;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel2;


public class InitProblem_Parallel2 implements JavaDelegate {
	private int n = 100000;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		ProcessInstanceData_Parallel2.threadAmount = 2;
        ProcessInstanceData_Parallel2.repetitions = 1000;
        ProcessInstanceData_Parallel2.counter = -1;
        ProcessInstanceData_Parallel2.startList = new  LinkedList<Integer>();
        ProcessInstanceData_Parallel2.intermediantresultList = new Vector<Integer>();
        int primeNumber = 500009;


        for (int i=0;i<n;i++)
            ProcessInstanceData_Parallel2.startList.add(500009);

        System.out.println("Parallel Gateway 2x");
        System.out.println("Thread amount: " + ProcessInstanceData_Parallel2.threadAmount);
        System.out.println("Test size: " + ProcessInstanceData_Parallel2.startList.size());
        System.out.println("Test number: " + primeNumber);
        System.out.println("Test repetitions: " + ProcessInstanceData_Parallel2.repetitions);

        ProcessInstanceData_Parallel2.start = System.currentTimeMillis();
    }
}