package sdc;

import sdc.Abstraction.Calculable;
import sdc.Abstraction.Comparable;
import sdc.Exceptions.IncompatibleTypeException;

public class IntegerValue extends Value implements Calculable, Comparable {

    private int value;

    public IntegerValue() {
		this(0);
    }

    public IntegerValue(int value) {
		this.value = value;
    }

    public boolean parse(String s) {
		try {
			this.value = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
    }

	@Override
	public String toString() {
		return String.valueOf(this.value);
    }

    @Override
    public Value add(Value v) throws IncompatibleTypeException {
		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value + this.value);
    }

    @Override
    public Value multiply(Value v) throws IncompatibleTypeException {
		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value * this.value);
    }

    @Override
    public Value divide(Value v) throws IncompatibleTypeException {
		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}
		return new IntegerValue(((IntegerValue) v).value / this.value);
    }

    @Override
    public Value substract(Value v) throws IncompatibleTypeException {
		if (!(v instanceof IntegerValue)) {
			throw new IncompatibleTypeException();
		}

		return new IntegerValue(((IntegerValue) v).value - this.value);
    }

    @Override
    public Value abs() {
		// attention à bien créer une nouvelle instance
		return this.value < 0 ? new IntegerValue(-1 * this.value) : new IntegerValue(this.value);
    }

    @Override
    public Value greaterThan(Value v) throws IncompatibleTypeException {
        if (!(v instanceof IntegerValue)) {
            throw new IncompatibleTypeException();
        }
        return new BooleanValue(((IntegerValue) v).value > this.value);
    }

    @Override
    public Value lowerThan(Value v) throws IncompatibleTypeException {
        if (!(v instanceof IntegerValue)) {
            throw new IncompatibleTypeException();
        }
        return new BooleanValue(((IntegerValue) v).value < this.value);
    }

    @Override
    public Value equal(Value v) throws IncompatibleTypeException {
        if (!(v instanceof IntegerValue)) {
            throw new IncompatibleTypeException();
        }
        return new BooleanValue(((IntegerValue) v).value == this.value);
    }
}
