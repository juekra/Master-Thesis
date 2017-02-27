package camunda.logic;

import camunda.data.ProcessInstanceData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * Created by kraussju on 10.11.2016.
 */
public class Finalization implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        ProcessInstanceData.stop = System.currentTimeMillis();

        System.out.println("Results: " + ProcessInstanceData.intermediantresultList.toString());
        System.out.println("Time: " + (ProcessInstanceData.stop - ProcessInstanceData.start));
    }
}

