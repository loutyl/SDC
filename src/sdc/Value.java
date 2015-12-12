package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.Exceptions.ShutdownException;

import java.util.Stack;

public abstract class Value implements Symbol {

    @Override
    public void execute(Stack<? super Value> s) throws ShutdownException, IncompatibleTypeException {
        s.push(this);
    }
}
