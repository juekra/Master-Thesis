package activiti.logic;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.data.ProcessInstanceData_Parallel8;


public class FindMax_Parallel8 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {


        int counter = ProcessInstanceData_Parallel8.count();
        int startListSize = ProcessInstanceData_Parallel8.startList.size();
        int threadAmount = ProcessInstanceData_Parallel8.threadAmount;
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

            List<Integer> startList = ProcessInstanceData_Parallel8.startList;

            System.out.println("Thread-Nr:" + counter + " searching from " + startIndex + " to " + endIndex);

            int max = -1;
            int prime = 0;
            for(int repeatCounter = 0; repeatCounter<ProcessInstanceData_Parallel8.repetitions; repeatCounter++){
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

            ProcessInstanceData_Parallel8.addIntermediateResult(max);
        }else{
            System.out.println("Wiederholung in FindMax");
        }
    }
}

