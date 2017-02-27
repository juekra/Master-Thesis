package camunda.logic;

import camunda.data.ProcessInstanceData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.List;

/**
 * Created by kraussju on 10.11.2016.
 */

public class FindMax implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {


        int counter = ProcessInstanceData.count();
        int startListSize = ProcessInstanceData.startList.size();
        int threadAmount = ProcessInstanceData.threadAmount;
        if(!(counter>=threadAmount)){
            int listDivider = startListSize / threadAmount;

            int startIndex = 0;
            int endIndex = 0;
            if(counter == 0){
                startIndex = counter * listDivider;
                endIndex = ((counter + 1) * listDivider);
            }

            if (counter > 0){
                startIndex =  (counter * listDivider);
                endIndex = ((counter + 1) * listDivider);
            }

            if (counter == threadAmount){
                endIndex = startListSize - 1;
            }

            List<Integer> startList = ProcessInstanceData.startList;

            System.out.println("Thread-Nr:" + counter + " searching from " + startIndex + " to " + endIndex);

            int max = -1;
            int prime = 0;
            for(int repeatCounter = 0; repeatCounter<ProcessInstanceData.repetitions; repeatCounter++){
                for (int i = startIndex; i < endIndex; i++) {
                    int number = startList.get(i);
                    prime = 0;

                    if (number%2==0){
                        prime = -1;
                    }

                    if(prime!=-1){
                        for(int n=3;n*n<=number;n+=2) {
                            if(number%n==0){
                                prime = -1;
                                break;
                            }
                        }
                    }
                    if(prime!=-1){
                        if (number > max) {
                            max = number;
                        }
                    }
                }

            }

            System.out.println("Thread-Nr:" + counter + " found Max= " +  max);

            ProcessInstanceData.addIntermediateResult(max);
        }else{
            System.out.println("Wiederholung in FindMax");
        }
    }
}
