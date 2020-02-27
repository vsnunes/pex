package pex;

import java.util.HashSet;
import java.util.TreeMap;
import java.io.Serializable;
import pex.atomic.Identifier;
import pex.operators.Program;
/**
 * Class for handling interpreter.
 * Allows to select beetween a range of interpreters.
 * */
public class InterpreterManager {
	Interpreter _interpreter;

	public InterpreterManager(Visitor v, InputVisitor iv) {
		_interpreter = new Interpreter(v, iv);
	}
	
	/**
	 * Sets the interpreter to a new one.
	 * @param the new interpreter.
	 * Note: This function do not save current interpreter state.
	 * */
	public void setInterpreter(Interpreter newInterpreter) {
		_interpreter = newInterpreter;
	}
	
	/**
	 * Gets the current interpreter.
	 * @return interpreter
	 * */
	public Interpreter getInterpreter() {
		return _interpreter;
	}
}
