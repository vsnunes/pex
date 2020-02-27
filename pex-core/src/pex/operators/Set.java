package pex.operators;

import pex.Expression;
import pex.Value;
import pex.atomic.StringLiteral;
import pex.atomic.Identifier;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;

/**
 * Class for describing the set ('set') operator
 */
public class Set extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /**
   * @param first
   * @param second
   */
  public Set(Expression first, Expression second) {
    super(first, second);
    
  }

 @Override
 public String accept(Visitor v) {return v.visit(this);} 
  
  @Override
  public void execute(Interpreter i) {
   second().execute(i);
   super.setValue(second().getExpValue());
   first().setValue(second().getExpValue());
   i.add((Identifier)first());
  }
  

 
}
