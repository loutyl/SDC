package sdc;

import sdc.Abstraction.Logical;
import sdc.Exceptions.IncompatibleTypeException;

public class BooleanValue extends Value implements Logical {

    private boolean value;

    public BooleanValue(boolean value){
        this.value = value;
    }

    public BooleanValue(){
        this(false);
    }

    @Override
    public Value and(Value v) throws IncompatibleTypeException {
        if (!(v instanceof BooleanValue)) {
            throw new IncompatibleTypeException();
        }
        return new BooleanValue(this.value && ((BooleanValue) v).value);
    }

    @Override
    public Value or(Value v) throws IncompatibleTypeException {
        if (!(v instanceof BooleanValue)) {
            throw new IncompatibleTypeException();
        }
        return new BooleanValue(this.value || ((BooleanValue) v).value);
    }

    @Override
    public Value negate() throws IncompatibleTypeException {
        return new BooleanValue(!this.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean parse(String s) {
        if (s.equals("true") || s.equals("false"))
        {
            this.value = Boolean.valueOf(s);
            return true;
        }
        return false;
    }
}
