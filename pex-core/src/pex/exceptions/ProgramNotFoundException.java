package pex.exceptions;
/**
 * Class for representing access to a program that dont exists.
 */
public class ProgramNotFoundException extends InterpreterException {
	public ProgramNotFoundException() {}
	public ProgramNotFoundException(String description) {
		super(description);
	}
}
