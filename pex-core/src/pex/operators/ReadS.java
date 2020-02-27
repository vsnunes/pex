package pex.operators;

import pex.Expression;
import pex.Value;
import java.util.ArrayList;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import java.util.Collections;
import java.util.List;

/**
 * Class for describing the reads ('reads') operator
 */
public class ReadS extends Expression {
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;
 
 @Override
 public String accept(Visitor v) {return v.visit(this);} 
  
  @Override
  public void execute(Interpreter i) {
    String input = i.getInVisitor().inputString();
    super.setValue(input);

  }
  

 
}
