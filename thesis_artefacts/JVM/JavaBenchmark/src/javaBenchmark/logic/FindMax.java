package javaBenchmark.logic;


import javaBenchmark.data.DataStore;
import javaBenchmark.data.ProcessInstanceData;
import java.util.List;

/**
 * Created by kraussju on 10.11.2016.
 */

public class    FindMax implements Runnable {

    @Override
    public void run() {
        execute();
    }

    public void execute() {


        ProcessInstanceData processInstanceData = DataStore.getProcessInstanceData("id");

        int counter = processInstanceData.count();
        int startListSize = processInstanceData.getStartList().size();
        int threadAmount = processInstanceData.getThreadAmount();
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

            List<Integer> startList = processInstanceData.getStartList();

            System.out.println("Thread-Nr:" + counter + " searching from " + startIndex + " to " + endIndex);

            int prime = 0;
            int resultCounter = 0;
            for(int repeatCounter = 0; repeatCounter<processInstanceData.getRepetitions(); repeatCounter++){
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
                        resultCounter++;
                    }
                }
            }


            System.out.println("Thread-Nr:" + counter + " found Max= " +  resultCounter);

            processInstanceData.addIntermediateResult(resultCounter);
        }else{
            System.out.println("Wiederholung in FindMax");
        }
    }
}