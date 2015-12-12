package sdc;

import sdc.Abstraction.Calculable;
import sdc.Exceptions.IncompatibleTypeException;

public class AbsoluteOperation extends UnaryOperation {

    @Override
    public boolean parse(String s) {
       return s.equals("||");
    }

    @Override
    public Value compute(Value v) throws IncompatibleTypeException {
        return ((Calculable)v).abs();
    }
}
