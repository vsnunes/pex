package pex.operators;

import pex.Expression;
import pex.Value;

import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
/**
 * Class for describing the equal (ge) operator
 */
public class Ge extends BinaryExpression {
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;
  
  /**
   * @param first
   * @param second
   */
  public Ge(Expression first, Expression second) {
    super(first, second);
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);}

  @Override
  public void execute(Interpreter i) {
    first().execute(i);
    second().execute(i);
    if ((int) first().getExpValue().getValue() >= (int) second().getExpValue().getValue()) super.setValue(1);
    else super.setValue(0);

  }
  

 
}
