package jbpm.logic;

import java.util.List;

import jbpm.application.Log;
import jbpm.data.DataStore;
import jbpm.data.ProcessInstanceData;

public class Logic_Parallel2 {

	public void initProblem(String s) {
		Log.init();
		int threadAmount = 5;
		DataStore.createProcessInstanceData("test", threadAmount);

		List<Integer> startList = DataStore.getProcessInstanceData("test").getStartList();

		for (int i = 0; i < 100000; i++)
			startList.add((int) ((Math.random() * startList.size() / 2) + startList.size() / 2));// Numbers
																									// from
																									// size/2
																									// to
																									// size-1
																									// ???
		/*
		 * for (int i = 100000; i > 0; i--) { startList.add(i); }
		 */
		Log.log("Size after creation: " + startList.size());

		Log.start = System.currentTimeMillis();
	}
	
	public void findMax(String s){
		ProcessInstanceData processInstanceData = DataStore.getProcessInstanceData("test");
        int counter = processInstanceData.count();

        int startListSize = processInstanceData.getStartList().size();
        int threadAmount = processInstanceData.getThreadAmount();

        int listDivider = startListSize / threadAmount;

        int startIndex = 0;
        int endIndex = 0;
        if(counter == 0){
            startIndex = counter * listDivider;
            endIndex = ((counter + 1) * listDivider);
        }

        if (counter > 0){
            startIndex =  (counter * listDivider) + 1;
            endIndex = ((counter + 1) * listDivider);
        }

        if (counter == threadAmount){
            endIndex = startListSize - 1;
        }

        List<Integer> startList = processInstanceData.getStartList();
        System.out.println("Size before calculation: " + startList.size());

        System.out.println("Thread-Nr:" + counter + " searching from " + startIndex + " to " + endIndex);

        int max = -1;

        for (int i = startIndex; i < endIndex; i++) {
            int number = startList.get(i);
            if (isPrime(number) && number > max) {
                max = number;
            }
        }

        System.out.println("Max=" + max);

        processInstanceData.addIntermediateResult(max);
	}
	
	private boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
	
	public void finalization(String s){
		Log.stop = System.currentTimeMillis();

        System.out.println("Results: " + DataStore.
                getProcessInstanceData("test").getIntermediantresultList().toString());
        Log.close();
	}

}
