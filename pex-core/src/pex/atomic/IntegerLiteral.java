/*  */
package pex.atomic;

import pex.Value;
import pex.Visitor;
import pex.Interpreter;
/**
 * Class for describing syntactic tree leaves for holding integer values.
 */
public class IntegerLiteral extends Value<Integer> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /**
   * @param value
   */
  public IntegerLiteral(int value) {
    super(value);
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);}
  
  @Override
  public void execute(Interpreter i) {
    super.setValue(getValue());
  } 
}
