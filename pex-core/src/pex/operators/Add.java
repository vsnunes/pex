/*  */
package pex.operators;

import pex.Expression;
import pex.Value;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import pex.atomic.IntegerLiteral;

/**
 * Class for describing the sum ('+') operator
 */
public class Add extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /**
   * @param first
   * @param second
   */
  public Add(Expression first, Expression second) {
    super(first, second);
  }
  
  @Override
  public String accept(Visitor v) {return v.visit(this);}
  
  @Override
  public void execute(Interpreter i) {
    first().execute(i);
    second().execute(i);
    
    super.setValue((int) first().getExpValue().getValue() + (int) second().getExpValue().getValue());

  }
  

 
}
