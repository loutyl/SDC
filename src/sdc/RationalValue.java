package sdc;

import sdc.Abstraction.Calculable;
import sdc.Abstraction.Comparable;
import sdc.Exceptions.IncompatibleTypeException;

public class RationalValue extends Value implements Calculable, Comparable {

    private int numerator;
    private int denumerator;

    public RationalValue(){
        this(1,1);
    }

    public RationalValue(int numerator, int denumerator){
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    @Override
    public Value multiply(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }
        return new RationalValue((this.numerator * ((RationalValue) v).numerator),
                (this.denumerator * ((RationalValue) v).denumerator));
    }

    @Override
    public Value divide(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }

        RationalValue upsideDownValue = new RationalValue(this.denumerator, this.numerator);
        return ((RationalValue)v).multiply(upsideDownValue);
    }

    @Override
    public Value add(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }

        if (this.isDenumeratorEqual(v)){
            return new RationalValue(this.numerator + ((RationalValue) v).numerator, this.denumerator);
        }
        return new RationalValue(
                (this.numerator * ((RationalValue) v).denumerator) + (((RationalValue) v).numerator * this.denumerator),
                this.denumerator * ((RationalValue) v).denumerator);
    }

    @Override
    public Value substract(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }

        if (this.isDenumeratorEqual(v)){
            return new RationalValue(Math.abs(this.numerator - ((RationalValue) v).numerator), this.denumerator);
        }

        return new RationalValue(
                ((((RationalValue) v).numerator * this.denumerator) - (this.numerator * ((RationalValue) v).denumerator)),
                this.denumerator * ((RationalValue) v).denumerator);
    }

    @Override
    public Value abs() {
        int numeratorCoeff = (this.numerator < 0) ? -1 : 1;
        int denumeratorCoeff = (this.denumerator < 0) ? -1 : 1;
        return new RationalValue((numeratorCoeff * this.numerator), (denumeratorCoeff * this.denumerator));
    }

    @Override
    public boolean parse(String s)  {
        try {
            String[] values = s.split("#");
            this.numerator = Integer.parseInt(values[0]);
            this.denumerator = Integer.parseInt(values[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%1s#%s", this.numerator, this.denumerator);
    }

    @Override
    public Value greaterThan(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }
        return this.isDenumeratorEqual(v)
                ? new BooleanValue(((RationalValue) v).numerator > this.numerator)
                : new BooleanValue((((RationalValue) v).numerator * this.denumerator) > (this.numerator * ((RationalValue) v).denumerator));
    }

    @Override
    public Value lowerThan(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }
        return this.isDenumeratorEqual(v)
                ? new BooleanValue(((RationalValue) v).numerator < this.numerator)
                : new BooleanValue((((RationalValue) v).numerator * this.denumerator) < (this.numerator * ((RationalValue) v).denumerator));
    }

    @Override
    public Value equal(Value v) throws IncompatibleTypeException {
        if (!(v instanceof RationalValue)) {
            throw new IncompatibleTypeException();
        }
        return this.isDenumeratorEqual(v)
                ? new BooleanValue(((RationalValue) v).numerator == this.numerator)
                : new BooleanValue(false);
    }

    private boolean isDenumeratorEqual(Value v){
        return this.denumerator == ((RationalValue) v).denumerator;
    }
}
