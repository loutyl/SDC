package sdc.Abstraction;

import sdc.Exceptions.IncompatibleTypeException;
import sdc.Value;

public interface Comparable {

    Value greaterThan(Value v) throws IncompatibleTypeException;
    Value lowerThan(Value v) throws IncompatibleTypeException;
    Value equal(Value v) throws IncompatibleTypeException;
}
