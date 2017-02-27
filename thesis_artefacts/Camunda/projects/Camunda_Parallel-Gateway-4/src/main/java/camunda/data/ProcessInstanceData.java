package camunda.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kraussju on 10.11.2016.
 */
public class ProcessInstanceData {
    public static int counter;
    public static int threadAmount;
    public static List<Integer> startList;
    public static List<Integer> intermediantresultList;
    public static long start;
    public static long stop;
    public static int repetitions;

    public static synchronized int count(){
        counter++;
        return counter;
    }

    public static void addIntermediateResult(int max) {
        intermediantresultList.add(max);
    }
}

