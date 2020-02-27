package pex.operators;

import pex.Expression;
import pex.Value;
import pex.atomic.IntegerLiteral;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;

/**
 * Class for describing the div ('/') operator
 */
public class Div extends BinaryExpression {
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;
 
  
  /**
   * @param first
   * @param second
   */
  public Div(Expression first, Expression second) {
    super(first, second);
  }
 
  @Override
  public String accept(Visitor v) {return v.visit(this);}
 
  @Override
  public void execute(Interpreter i) {
    first().execute(i);
    second().execute(i);
    super.setValue((int) first().getExpValue().getValue() / (int) second().getExpValue().getValue());

  }
  

 
}
