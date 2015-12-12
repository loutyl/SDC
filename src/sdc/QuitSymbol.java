package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.ShutdownException;

import java.util.Stack;

public class QuitSymbol implements Symbol {

    @Override
    public boolean parse(String s) {
	    return s.equals("quit");
    }

    @Override
    public void execute(Stack<? super Value> s) throws ShutdownException {
	    throw new ShutdownException();
    }

}