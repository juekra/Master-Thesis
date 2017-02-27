package activiti.MI4.logic;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.MI4.data.DataStore;
import activiti.MI4.data.ProcessInstanceData;

/**
 * Created by kraussju on 10.11.2016.
 */
public class InitProblem implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {

        int listSize = 100000;
        int primeNumber = 500009;
        int threadAmount = 4;
        int repetitions = 500;

        DataStore.newProcessInstanceData(threadAmount, repetitions, execution.getProcessInstanceId());

        ProcessInstanceData processInstanceData = DataStore.getProcessInstanceData(execution.getProcessInstanceId());


        for (int i=0;i<listSize;i++)
            processInstanceData.getStartList().add(500009);

        System.out.println("Multi Instance 4x");
        System.out.println("Thread amount: " + processInstanceData.getThreadAmount());
        System.out.println("Test size: " + processInstanceData.getStartList().size());
        System.out.println("Test number: " + primeNumber);
        System.out.println("Test repetitions: " + processInstanceData.getRepetitions());

        processInstanceData.setStart(System.currentTimeMillis());
    }
}
