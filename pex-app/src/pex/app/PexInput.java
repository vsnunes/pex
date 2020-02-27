package pex.app;

import static pt.tecnico.po.ui.Dialog.IO;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;
import pex.Visitor;
import pex.InputVisitor;

public class PexInput implements InputVisitor {
   public String inputString() {
     Form _form = new Form();
     Input<String> input;
     input = _form.addStringInput("");
     _form.parse();
     return input.value();
   }

   public int inputInteger() {
     Form _form = new Form();
     Input<Integer> input;
     input = _form.addIntegerInput("");
     _form.parse();
     return input.value();

   }

   public void output(String s) {
     Display display = new Display();
     display.add(s);
     display.display();

   }
}
