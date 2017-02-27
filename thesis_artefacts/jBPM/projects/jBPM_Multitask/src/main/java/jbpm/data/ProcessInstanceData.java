package jbpm.data;
import java.util.LinkedList;
import java.util.List;

public class ProcessInstanceData {
	private int counter = -1;
    private int threadAmount;
    private String processInstanceId;
    private List<Integer> startList = new LinkedList<Integer>();
    private List<Integer> intermediantresultList = new LinkedList<Integer>();



    public ProcessInstanceData(String processInstanceId, int threadAmount){
        this.processInstanceId = processInstanceId;
        this.threadAmount = threadAmount;
    }

    public List<Integer> getStartList(){
        return startList;
    }

    public List<Integer> getIntermediantresultList(){
        return intermediantresultList;
    }

    public int getThreadAmount(){
        return threadAmount;
    }


    public int count(){
        counter++;
        return counter;
    }

    public int getCounter(){
        return counter;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void addIntermediateResult(int max) {
        intermediantresultList.add(max);
    }
}
