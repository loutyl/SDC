package sdc;

import sdc.Abstraction.Symbol;
import sdc.Exceptions.*;
import sdc.Exceptions.InternalError;

import java.util.*;

public class SDC {

    private Factory factory;
    private Stack<Value> stack;

    public SDC() {
		this.factory = new Factory();
		this.stack = new Stack<Value>();
    }

    public void executeLine(String line)
	throws ShutdownException, InternalError,
            IncompatibleTypeException, StackException,
            SymbolNotFoundException, UnknownVariableException {
		// main method:

		// parse the line to execute
		// tokens are separated by a space
		StringTokenizer st = new StringTokenizer(line);
		while (st.hasMoreTokens()) {

			// read the next token
			String token = st.nextToken();

			// try every registered symbole
			boolean found = false;
			ArrayList<Symbol> symbols = this.factory.registered();
			for (Symbol s : symbols) {
				if (s.parse(token)) {
					found = true;
                    Stack<Value> oldStack = (Stack<Value>) this.stack.clone();
					try {
                        s.execute(this.stack);
					} catch (EmptyStackException e) {
						// we might have read some symbols from the stack
						// roll back
						this.stack = oldStack;
						throw new StackException("Empty stack --- aborting last operations");
					} catch (IncompatibleTypeException e) {
						// we might have read some symbols from the stack
						// roll back
						this.stack = oldStack;
						throw new IncompatibleTypeException("Illegal operations: values must have the same type --- aborting last operations");
					} catch (UnknownVariableException e){
                        this.stack = oldStack;
                        throw new UnknownVariableException("Illegal operation: unknown variable. Ignore last command line");
                    }
					break;
				}
				// continue to the next symbol

			}

			if (!found) {
				throw new SymbolNotFoundException("the token " + token + " has not been recognized. Abort");
			}
		}
    }

    public String getLastResult() {
		try {
			Value v = this.stack.peek();
			return v.toString();
		} catch (EmptyStackException e) {
			return "";
		}
    }
}
