package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.Exceptions.ShutdownException;
import sdc.Exceptions.UnknownVariableException;

import java.util.Stack;

public class AffectationOperation implements Symbol {

    @Override
    public boolean parse(String s) throws IncompatibleTypeException, UnknownVariableException {
        return s.equals("=>");
    }

    @Override
    public void execute(Stack<? super Value> s) throws ShutdownException, IncompatibleTypeException, UnknownVariableException {
       return;
    }
}
