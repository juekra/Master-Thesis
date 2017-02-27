package javaBenchmark.logic;


import javaBenchmark.data.DataStore;
import javaBenchmark.data.ProcessInstanceData;

/**
 * Created by kraussju on 10.11.2016.
 */
public class Finalization {
    public void execute() {
        ProcessInstanceData processInstanceData = DataStore.getProcessInstanceData("id");

        processInstanceData.setStop(System.currentTimeMillis());

        System.out.println("Results: " + processInstanceData.getIntermediantresultList().toString());
        System.out.println("Time: " + (processInstanceData.getStop() - processInstanceData.getStart()));
    }
}
