package sdc.Abstraction;


import sdc.Exceptions.IncompatibleTypeException;
import sdc.Value;

public interface Logical {

    Value and(Value v) throws IncompatibleTypeException;
    Value or(Value v) throws IncompatibleTypeException;
    Value negate() throws IncompatibleTypeException;
}
