/** @version  */
package pex.app.main;

import pex.operators.Program;
import pex.Interpreter;
import pex.InterpreterManager;
import pex.exceptions.ProgramNotFoundException;
import pex.app.evaluator.EvaluatorMenu;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;

/**
 * Open menu for managing programs.
 */
public class DoManageProgram extends Command<InterpreterManager> {
  /** Input field. */
  Input<String> _program;

  /**
   * @param receiver
   */
  public DoManageProgram(InterpreterManager receiver) {
    super(Label.MANAGE_PROGRAM, receiver);
    _program = _form.addStringInput(Message.requestProgramId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    Interpreter interpreter = _receiver.getInterpreter();
    
    try {
		Program program = interpreter.getProgram(_program.value());
        Menu m = new EvaluatorMenu(interpreter, program);
        m.open();
	}
    catch(ProgramNotFoundException e) {
        _display.popup(Message.noSuchProgram(_program.value()));
    }
	
	
  }

}
