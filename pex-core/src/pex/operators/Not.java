/*  */
package pex.operators;

import pex.Expression;

import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
/**
 * Class for describing the negation operator
 */
public class Not extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /**
   * @param argument
   */
  public Not(Expression argument) {
    super(argument);
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);} 

  @Override
  public void execute(Interpreter i) {
    argument().execute(i);
    if ((int)argument().getExpValue().getValue() != 0)
         super.setValue(0);
    else 
         super.setValue(1);

}

}
