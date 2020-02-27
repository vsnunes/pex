/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {

  /**
   * @param interpreter 
   * @param receiver
   */
  public EvaluatorMenu(Interpreter interpreter, Program program) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoShowProgram(interpreter, program), //
            new DoRunProgram(interpreter, program), //
            new DoAddExpression(interpreter, program), //
            new DoReplaceExpression(interpreter, program), //
            new DoShowAllIdentifiers(interpreter, program), //
            new DoShowUninitializedIdentifiers(interpreter, program), //
        });
  }

}
