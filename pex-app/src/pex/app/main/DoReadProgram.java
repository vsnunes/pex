/** @version  */
package pex.app.main;

import pex.Parser;
import pex.ParserException;
import pex.app.BadFileException;
import pex.operators.Program;
import pex.Interpreter;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Read existing program.
 */
public class DoReadProgram extends Command<InterpreterManager> {
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoReadProgram(InterpreterManager receiver) {
    super(Label.READ_PROGRAM, receiver);
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws BadFileException {
    _form.parse();
    Interpreter interpreter = _receiver.getInterpreter();
    try {
            Parser p = new Parser();
    
            Program prg = p.parseProgramFile(_filename.value());
            prg.setName(_filename.value()); //program's name = filename
            interpreter.add(prg);

        }
        catch(ParserException e) {
            throw new BadFileException(_filename.value());
		 }
		 
	 }
  }


