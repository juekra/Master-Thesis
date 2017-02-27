package activiti.logic;

import java.util.LinkedList;
import java.util.Vector;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel4;

public class InitProblem_Parallel4 implements JavaDelegate {
	 private int n = 100000;
	    public void execute(DelegateExecution execution) throws Exception {
	        ProcessInstanceData_Parallel4.threadAmount = 4;
	        ProcessInstanceData_Parallel4.repetitions = 1000;
	        ProcessInstanceData_Parallel4.counter = -1;
	        ProcessInstanceData_Parallel4.startList = new LinkedList<Integer>();
	        ProcessInstanceData_Parallel4.intermediantresultList = new Vector<Integer>();
	        int primeNumber = 500009;


	        for (int i=0;i<n;i++)
	            ProcessInstanceData_Parallel4.startList.add(500009);

	        System.out.println("Parallel Gateway 4x");
	        System.out.println("Thread amount: " + ProcessInstanceData_Parallel4.threadAmount);
	        System.out.println("Test size: " + ProcessInstanceData_Parallel4.startList.size());
	        System.out.println("Test number: " + primeNumber);
	        System.out.println("Test repetitions: " + ProcessInstanceData_Parallel4.repetitions);

	        ProcessInstanceData_Parallel4.start = System.currentTimeMillis();
	    }
	}
