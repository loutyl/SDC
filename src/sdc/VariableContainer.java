package sdc;

import java.util.HashMap;

public final class VariableContainer {

    private static HashMap<String, Value> container = new HashMap<String, Value>();

    public static void storeVariable(Value val, String name){
        container.put(name, val);
    }

    public static boolean contains(String varName){
        return container.containsKey(varName);
    }

    public static Value getVariable(String varName){
        return container.get(varName);
    }
}
