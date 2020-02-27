/** @version  */
package pex.app.main;

import pex.app.Pex;
import pex.app.PexInput;
import pex.operators.Program;
import pex.Interpreter;
import pex.Visitor;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Open a new interpreter.
 */
public class DoNew extends Command<InterpreterManager> {
  /** Input field. */
  Input<Boolean> _shouldSave;

  /**
   * @param receiver
   */
  public DoNew(InterpreterManager receiver) {
    super(Label.NEW, receiver);
    _shouldSave = _form.addBooleanInput(Message.saveBeforeExit());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _receiver.setInterpreter(new Interpreter(new Pex(), new PexInput()));
  }

}
