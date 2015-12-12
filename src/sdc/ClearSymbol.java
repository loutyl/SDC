package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.ShutdownException;

import java.util.Stack;

public class ClearSymbol implements Symbol {

    @Override
    public boolean parse(String s) {
	    return s.equals("clear");
    }

    @Override
    public void execute(Stack<? super Value> s) throws ShutdownException {
	    s.clear();
    }
}