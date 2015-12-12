package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.Exceptions.ShutdownException;

import java.util.Stack;

public class ViewSymbol implements Symbol {

    @Override
    public boolean parse(String s) {
        return s.equals("view");
    }

    @Override
    public void execute(Stack<? super Value> s) throws ShutdownException, IncompatibleTypeException {
        int position = s.size();
        for (Object value : s){
            System.out.println((position--) + " ----> " + value);
        }
    }
}
