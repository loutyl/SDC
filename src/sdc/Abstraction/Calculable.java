package sdc.Abstraction;

import sdc.Exceptions.IncompatibleTypeException;
import sdc.Value;

public interface Calculable {

    Value multiply(Value v) throws IncompatibleTypeException;
    Value divide(Value v) throws IncompatibleTypeException;
    Value add(Value v) throws IncompatibleTypeException;
    Value substract(Value v) throws IncompatibleTypeException;
    Value abs() throws IncompatibleTypeException;

}
