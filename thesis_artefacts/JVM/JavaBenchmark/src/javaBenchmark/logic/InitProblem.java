package javaBenchmark.logic;


import javaBenchmark.data.DataStore;
import javaBenchmark.data.ProcessInstanceData;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by kraussju on 10.11.2016.
 */
public class InitProblem{

    public void execute()  {

        int listSize = 100000;
        int primeNumber = 500009;
        int threadAmount = 8;
        int repetitions = 1;

        DataStore.newProcessInstanceData(threadAmount, repetitions, "id");

        ProcessInstanceData processInstanceData = DataStore.getProcessInstanceData("id");


        for (int i=0;i<listSize;i++)
            processInstanceData.getStartList().add(500009);

        System.out.println("Multi Instance 8x");
        System.out.println("Thread amount: " + processInstanceData.getThreadAmount());
        System.out.println("Test size: " + processInstanceData.getStartList().size());
        System.out.println("Test number: " + primeNumber);
        System.out.println("Test repetitions: " + processInstanceData.getRepetitions());

        processInstanceData.setStart(System.currentTimeMillis());
    }
}
