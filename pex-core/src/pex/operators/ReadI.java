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
 * Class for describing the readI ('readI') operator
 */
public class ReadI extends Expression {
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;
 
 @Override
 public String accept(Visitor v) {return v.visit(this);}   
  
  @Override
  public void execute(Interpreter i) {
     int input = i.getInVisitor().inputInteger();
     super.setValue(input);
  }
  

 
}
