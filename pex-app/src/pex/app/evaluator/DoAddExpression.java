/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.ParserException;
import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.operators.Program;
import pex.operators.ProgramIO;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * Add expression.
 */
public class DoAddExpression extends ProgramCommand {
  /** Input field. */
  Input<Integer> _position;

  /** Input field. */
  Input<String> _description;

  Program _program;
  /**
   * @param interpreter
   * @param receiver
   */
  public DoAddExpression(Interpreter interpreter, Program receiver) {
    super(Label.ADD_EXPRESSION, interpreter, receiver);
    _position = _form.addIntegerInput(Message.requestPosition());
    _description = _form.addStringInput(Message.requestExpression());
    _program = receiver;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
       new ProgramIO().addParserExpProgram(_program, _position.value(), _description.value());
    }
    catch(ParserException e) {throw new BadExpressionException(_description.value());}
    catch(IndexOutOfBoundsException e) {throw new BadPositionException(_position.value());}

      }
}
