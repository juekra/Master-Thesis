package activiti.logic;

import java.util.logging.Level;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel8;

public class Finalization_Parallel8 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		 ProcessInstanceData_Parallel8.stop = System.currentTimeMillis();

	        System.out.println("Results: " + ProcessInstanceData_Parallel8.intermediantresultList.toString());
	        System.out.println("Time: " + (ProcessInstanceData_Parallel8.stop - ProcessInstanceData_Parallel8.start));
	    }
	}
