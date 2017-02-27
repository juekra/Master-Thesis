package activiti.logic;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel2;


public class Finalization_Parallel2 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		  ProcessInstanceData_Parallel2.stop = System.currentTimeMillis();

	        System.out.println("Results: " + ProcessInstanceData_Parallel2.intermediantresultList.toString());
	        System.out.println("Time: " + (ProcessInstanceData_Parallel2.stop - ProcessInstanceData_Parallel2.start));
	    }
	}


