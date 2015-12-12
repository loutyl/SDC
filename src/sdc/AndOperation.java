package sdc;

import sdc.Abstraction.Logical;
import sdc.Exceptions.IncompatibleTypeException;

public class AndOperation extends BinaryOperation {

    @Override
    public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
        return ((Logical)v1).and(v2);
    }

    @Override
    public boolean parse(String s) {
        return s.equals("&");
    }
}
