/** @version  */
package pex.app;

import static pt.tecnico.po.ui.Dialog.IO;
import pex.InterpreterManager;
import pex.ParserException;
import pex.operators.Program;
import pex.operators.ProgramIO;
import pex.ParserException;
import pex.app.main.MainMenu;
import pt.tecnico.po.ui.Menu;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App {
  /**
   * @param args
   */
  public static void main(String[] args) {

    /* Creates a new interpreter manager which display program's in pex. */
    InterpreterManager manager = new InterpreterManager(new Pex(), new PexInput());
    
    
    String datafile = System.getProperty("import"); //$NON-NLS-1$
    if (datafile != null) {
      try {
        
        new ProgramIO().addFromInputFile(manager.getInterpreter(), datafile);
      } catch (ParserException e) {
        // no behavior described: just present the problem
        e.printStackTrace();
      }
    }
	
	

    Menu menu = new MainMenu(manager);
    menu.open();
    IO.close();
  }

}
