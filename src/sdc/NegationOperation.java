package sdc;

import sdc.Exceptions.IncompatibleTypeException;

public class NegationOperation extends UnaryOperation {

    @Override
    public Value compute(Value v) throws IncompatibleTypeException {
        return ((BooleanValue)v).negate();
    }

    @Override
    public boolean parse(String s) {
        return s.equals("~");
    }
}
