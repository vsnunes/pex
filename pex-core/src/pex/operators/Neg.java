package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
/**
 *
 * Class for describing the negation operator
 */
public class Neg extends UnaryExpression {

  

  /**
   * @param argument
   */
  public Neg(Expression argument) {
    super(argument);
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);}
  
  @Override
  public void execute(Interpreter i) {
    argument().execute(i);
    super.setValue(-1 * (int)argument().getExpValue().getValue());
  }

}
