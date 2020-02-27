/** @version  */
package pex.app.main;

import pex.operators.Program;
import pex.Interpreter;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Create new program.
 */
public class DoNewProgram extends Command<InterpreterManager> {
  /** Input field. */
  Input<String> _programName;

  /**
   * @param receiver
   */
  public DoNewProgram(InterpreterManager receiver) {
    super(Label.NEW_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    Interpreter interpreter = _receiver.getInterpreter();
    interpreter.add(new Program(_programName.value()));
  }

}
