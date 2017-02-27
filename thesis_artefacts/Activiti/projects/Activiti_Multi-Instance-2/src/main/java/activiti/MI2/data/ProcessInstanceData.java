package activiti.MI2.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kraussju on 10.11.2016.
 */
public class ProcessInstanceData {
    private int threadAmount;
    private List<Integer> startList;
    private List<Integer> intermediantresultList;
    private long start;
    private long stop;
    private int repetitions;
    private int counter;

    public ProcessInstanceData(int threadAmount, int repetitions) {
        this.threadAmount = threadAmount;
        this.repetitions = repetitions;
        counter =  -1;
        startList = new LinkedList<Integer>();
        intermediantresultList = new Vector<Integer>();
    }


    public synchronized int count(){
        counter++;
        return counter;
    }

    public void addIntermediateResult(int max) {
        intermediantresultList.add(max);
    }

    public List<Integer> getIntermediantresultList(){
        return intermediantresultList;
    }


    public int getThreadAmount() {
        return threadAmount;
    }


    public List<Integer> getStartList() {
        return startList;
    }


    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getStop() {
        return stop;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }

    public int getRepetitions() {
        return repetitions;
    }
}

