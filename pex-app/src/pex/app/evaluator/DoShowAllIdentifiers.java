/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.Visitor;
import pex.atomic.Identifier;
import pex.operators.Program;

/**
 * Show all program identifiers.
 */
public class DoShowAllIdentifiers extends ProgramCommand {

  Interpreter _interpreter;
  Program     _program;
  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowAllIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_ALL_IDENTIFIERS, interpreter, receiver);
    _interpreter = interpreter;
    _program = receiver;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
   Visitor v = _interpreter.getVisitor();
   for (String s: _program.getIdentifiers(false)) {
	   _display.addLine(s);	   
   }
   _display.display();
    
  }

}
