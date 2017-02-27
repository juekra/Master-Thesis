package activiti.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel8;

public class InitProblem_Parallel8 implements JavaDelegate {
	private int n = 100000;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		 ProcessInstanceData_Parallel8.threadAmount = 8;
	        ProcessInstanceData_Parallel8.repetitions = 1000;
	        ProcessInstanceData_Parallel8.counter = -1;
	        ProcessInstanceData_Parallel8.startList = new LinkedList<Integer>();
	        ProcessInstanceData_Parallel8.intermediantresultList = new Vector<Integer>();
	        int primeNumber = 500009;


	        for (int i=0;i<n;i++)
	            ProcessInstanceData_Parallel8.startList.add(500009);

	        System.out.println("Parallel Gateway 8x");
	        System.out.println("Thread amount: " + ProcessInstanceData_Parallel8.threadAmount);
	        System.out.println("Test size: " + ProcessInstanceData_Parallel8.startList.size());
	        System.out.println("Test number: " + primeNumber);
	        System.out.println("Test repetitions: " + ProcessInstanceData_Parallel8.repetitions);

	        ProcessInstanceData_Parallel8.start = System.currentTimeMillis();
	    }
	}