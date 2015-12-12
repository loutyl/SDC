package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.Exceptions.UnknownVariableException;

import java.util.Stack;

public class VariableSymbol implements Symbol {

    private String varSymbol;

    @Override
    public boolean parse(String s) throws IncompatibleTypeException, UnknownVariableException {
        this.varSymbol = s;
        return this.varSymbol.startsWith("$");
    }

    @Override
    public void execute(Stack<? super Value> s) throws UnknownVariableException {
        if (!VariableContainer.contains(this.varSymbol)){
            throw new UnknownVariableException();
        }
        s.push(VariableContainer.getVariable(varSymbol));
    }
}
