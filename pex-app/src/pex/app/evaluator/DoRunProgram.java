/** @version  */
package pex.app.evaluator;

import pt.tecnico.po.ui.Input;
import pex.Interpreter;
import pex.InputVisitor;
import pex.atomic.*;
import pex.Expression;
import java.util.List;
import pex.operators.*;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {
  Interpreter _interpreter;
  Program _program;
  Input<String> _value; /* the value to atribute to I/O functions */
  /**
   * @param interpreter 
   * @param receiver
   */
  public DoRunProgram(Interpreter interpreter, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
    _program = receiver;
    _interpreter = interpreter;
    _value = _form.addStringInput("");

  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _program.execute(_interpreter);
  }
  
}
