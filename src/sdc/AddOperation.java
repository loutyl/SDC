package sdc;

import sdc.Abstraction.Calculable;
import sdc.Exceptions.IncompatibleTypeException;

public class AddOperation extends BinaryOperation {

    @Override
    public boolean parse(String s) {
	    return s.equals("+");
    }

    @Override
    public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
        return ((Calculable)v1).add(v2);
    }
}
