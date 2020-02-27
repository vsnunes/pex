/** @version  */
package pex.app.evaluator;

import pex.Visitor;
import pex.Interpreter;
import pex.operators.Program;

/**
 * Show uninitialized identifiers.
 */
public class DoShowUninitializedIdentifiers extends ProgramCommand {
   Program _program;
  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowUninitializedIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, interpreter, receiver);
    _program = receiver;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
   Visitor v = _interpreter.getVisitor();
   for (String s: _program.getIdentifiers(true)) {
	     _display.addLine(s);
   }
   _display.display();
  }

}
