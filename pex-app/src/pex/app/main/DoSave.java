/** @version  */
package pex.app.main;

import java.io.IOException;

import pex.Interpreter;
import pex.operators.Program;
import pex.operators.ProgramIO;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<InterpreterManager> {
  /** Input field. */
  Input<String> _filename;
  
  Interpreter _interpreter;
  
  /**
   * @param receiver
   */
  public DoSave(InterpreterManager receiver) {
    super(Label.SAVE, receiver);
    _interpreter = _receiver.getInterpreter();
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try {
            if (_interpreter.getName() == null) {
               _form.parse();
               new ProgramIO().save(_interpreter, _filename.value());
             }
            else new ProgramIO().save(_interpreter, _interpreter.getName());
      	} catch(IOException e) {
              e.printStackTrace();
	}
  }
}
