package activiti.MI8.logic;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.MI8.data.DataStore;
import activiti.MI8.data.ProcessInstanceData;




/**
 * Created by kraussju on 10.11.2016.
 */
public class Finalization implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {

        ProcessInstanceData processInstanceData = DataStore.getProcessInstanceData(execution.getProcessInstanceId());

        processInstanceData.setStop(System.currentTimeMillis());

        System.out.println("Results: " + processInstanceData.getIntermediantresultList().toString());
        System.out.println("Time: " + (processInstanceData.getStop() - processInstanceData.getStart()));
    }
}

