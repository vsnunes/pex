/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;

/**
 * Commands for programs.
 */
public abstract class ProgramCommand extends Command<Program> {
  /** The context of the program. */
  protected Interpreter _interpreter;
  
  /**
   * @param label 
   * @param interpreter
   * @param receiver
   */
  public ProgramCommand(String label, Interpreter interpreter, Program receiver) {
    super(label, receiver);
    _interpreter = interpreter;
  }

}
