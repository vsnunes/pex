package pex.operators;

import pex.Expression;
import pex.Value;
import pex.atomic.IntegerLiteral;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;

/**
 * Class for describing the or ('or') operator
 */
public class Or extends BinaryExpression {
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;
 

  /**
   * @param first
   * @param second
   */
  public Or(Expression first, Expression second) {
    super(first, second);
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);} 
  
  @Override
  public void execute(Interpreter i) {
     first().execute(i);
     if ((int)first().getExpValue().getValue() > 0) {
        super.setValue(1); /* if the first expression is false then we dont evaluate the second */
        return;
     }
     second().execute(i);
     if ((int)second().getExpValue().getValue() > 0) super.setValue(1);
     else super.setValue(0);


  }
  

 
}
