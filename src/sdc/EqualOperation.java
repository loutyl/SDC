package sdc;

import sdc.Abstraction.Comparable;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.BinaryOperation;
import sdc.Value;

public class EqualOperation extends BinaryOperation {

    @Override
    public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
        return ((Comparable)v1).equal(v2);
    }

    @Override
    public boolean parse(String s) {
        return s.equals("=");
    }
}
