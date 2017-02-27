package activiti.data;

import java.util.List;


public class ProcessInstanceData_Parallel8 {
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
