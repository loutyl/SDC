package sdc;

import sdc.Exceptions.IncompatibleTypeException;
import sdc.Exceptions.UnknownVariableException;

import java.util.Stack;
import java.util.regex.Pattern;

public class Variable extends Value {

    private Value value;
    private String name;

    public Variable(Value val){
        this.value = val;
    }

    public Variable(){
        this(null);
    }

    @Override
    public String toString() {
        return String.format("%s", this.value);
    }

    @Override
    public void execute(Stack<? super Value> s){
        this.value = (Value)s.pop();
        VariableContainer.storeVariable(this.value, this.name);
    }

    @Override
    public boolean parse(String s) throws IncompatibleTypeException, UnknownVariableException {
        Pattern regex = Pattern.compile("\\b=>|=|<|>|\\|\\||\\||~|\\+|-|/|\\*|&|view|quit|clear\\b");
        if (!regex.matcher(s).find()){
            this.name = String.format("$%s", s);
            return !s.startsWith("$");
        }
        return false;
    }
}
