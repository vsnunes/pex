/** @version  */
package pex.app.main;
import pex.InterpreterManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu builder.
 */
public class MainMenu extends Menu {

  /**
   * @param receiver
   */
  public MainMenu(InterpreterManager manager) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoNew(manager), //
            new DoOpen(manager), //
            new DoSave(manager), //
            new DoNewProgram(manager), //
            new DoReadProgram(manager), //
            new DoWriteProgram(manager), //
            new DoManageProgram(manager), //
        });
  }

}
