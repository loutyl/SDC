package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.IncompatibleTypeException;

import java.util.Stack;

public abstract class BinaryOperation implements Symbol {

    public abstract Value compute(Value v1, Value v2) throws IncompatibleTypeException;

    @Override
    public void execute(Stack<? super Value> s) throws IncompatibleTypeException {
        Value v1 = (Value)s.pop();
        Value v2 = (Value)s.pop();

        s.push(this.compute(v1, v2));
    }
}
