/*  */
package pex.atomic;

import pex.Value;
import pex.Visitor;
import pex.Interpreter;
/**
 * Class for describing syntactic tree leaves for holding string values.
 */
public class StringLiteral extends Value<String> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /**
   * @param value
   */
  public StringLiteral(String value) {
    super(value);
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);}

  @Override
  public void execute(Interpreter i) {
    super.setValue(getValue());
  }
 
}
