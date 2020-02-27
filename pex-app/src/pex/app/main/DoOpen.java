/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

import pex.operators.Program;
import pex.operators.ProgramIO;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Open existing interpreter.
 */
public class DoOpen extends Command<InterpreterManager> {
  
  Input<String> _file;
  /**
   * @param receiver
   */
  public DoOpen(InterpreterManager receiver) {
    super(Label.OPEN, receiver);
    _file = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    try { //The visitor will be the same as the current interpreter
            _receiver.setInterpreter(new ProgramIO().load(_receiver.getInterpreter().getVisitor(), _file.value()));
		
	}
	catch(FileNotFoundException e) {
            _display.popup(Message.fileNotFound());
	}
	catch(IOException e) { e.printStackTrace();}
	catch (ClassNotFoundException e) {	e.printStackTrace();}
  }

}
