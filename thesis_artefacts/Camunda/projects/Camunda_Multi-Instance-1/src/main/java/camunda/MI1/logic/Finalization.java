package camunda.MI1.logic;


import camunda.MI1.data.DataStore;
import camunda.MI1.data.ProcessInstanceData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

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

