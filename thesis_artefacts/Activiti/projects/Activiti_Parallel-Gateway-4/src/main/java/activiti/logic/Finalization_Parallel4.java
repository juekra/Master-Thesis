package activiti.logic;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel4;

public class Finalization_Parallel4 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		ProcessInstanceData_Parallel4.stop = System.currentTimeMillis();

        System.out.println("Results: " + ProcessInstanceData_Parallel4.intermediantresultList.toString());
        System.out.println("Time: " + (ProcessInstanceData_Parallel4.stop - ProcessInstanceData_Parallel4.start));
    }
}

