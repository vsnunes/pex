/** @version  */
package pex.app.evaluator;

import java.util.List;
import java.io.PrintStream;
import pex.Expression;
import pex.Interpreter;
import pex.Visitor;
import pex.operators.Program;

/**
 * Show program (present code).
 */
public class DoShowProgram extends ProgramCommand {
   Program _program;
   Visitor _visitor; //the program's visitor

   /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(Interpreter interpreter, Program program) {
    super(Label.SHOW_PROGRAM, interpreter, program);
    _program = program;
    _visitor = interpreter.getVisitor();
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {

    _display.addLine(_program.accept(_visitor));
    _display.display();
	
  }

}
