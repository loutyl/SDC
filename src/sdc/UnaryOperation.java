package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.IncompatibleTypeException;

import java.util.Stack;

public abstract class UnaryOperation implements Symbol {

    public abstract Value compute(Value v) throws IncompatibleTypeException;

    @Override
    public void execute(Stack<? super Value> s) throws IncompatibleTypeException {
        Value v = (Value)s.pop();
        s.push(this.compute(v));
    }
}
