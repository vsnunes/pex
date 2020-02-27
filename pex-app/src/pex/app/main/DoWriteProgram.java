/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import pex.exceptions.ProgramNotFoundException;

import pex.operators.Program;
import pex.operators.ProgramIO;
import pex.Interpreter;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Write (save) program to file.
 */
public class DoWriteProgram extends Command<InterpreterManager> {
  /** Input field. */
  Input<String> _programName;
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoWriteProgram(InterpreterManager receiver) {
    super(Label.WRITE_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    Interpreter interpreter = _receiver.getInterpreter();
    Program program;
       
    try {
		program = interpreter.getProgram(_programName.value());
                new ProgramIO().saveToText(program, interpreter.getVisitor(), _filename.value());
    }
    catch(ProgramNotFoundException e) {
        _display.popup(Message.noSuchProgram(_programName.value()));
    }
    catch (IOException e) {e.printStackTrace();}
    
  }

}
