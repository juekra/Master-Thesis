package camunda.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kraussju on 25.02.2017.
 */
abstract public class DataStore {

    public static Map<String,ProcessInstanceData> dataMap = new HashMap<String, ProcessInstanceData>();

    public static void newProcessInstanceData(int threadAmount, int repetitions, String id){
        dataMap.put(id,new ProcessInstanceData(threadAmount, repetitions));
    }

    public static ProcessInstanceData getProcessInstanceData(String id){
        return dataMap.get(id);
    }
}
