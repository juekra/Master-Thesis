package jbpm.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kraussju on 10.11.2016.
 */
public class DataStore {
    public static Map<String,ProcessInstanceData> dataMap = new HashMap<String, ProcessInstanceData>();

    public static void createProcessInstanceData(String processInstanceId, int threadAmount){
        dataMap.put(processInstanceId, new ProcessInstanceData(processInstanceId, threadAmount));
    }

    public static ProcessInstanceData getProcessInstanceData(String processInstanceId){
        return dataMap.get(processInstanceId);
    }

}