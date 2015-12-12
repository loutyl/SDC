package sdc;

import sdc.BooleanValue;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.BinaryOperation;
import sdc.Value;

public class OrOperation extends BinaryOperation {

    @Override
    public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
        return ((BooleanValue)v1).or(v2);
    }

    @Override
    public boolean parse(String s) {
        return s.equals("|");
    }
}
