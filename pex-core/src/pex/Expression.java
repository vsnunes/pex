/*  */
package pex;

import pex.atomic.IntegerLiteral;
import pex.atomic.StringLiteral;
import pex.Interpreter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * An expressions can be evaluated to produce a value.
 */
public abstract class Expression implements Serializable {
  /**
   * The value of an expression. 
   **/
  private Value _value;
 
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  public Value getExpValue() {return _value;}

  public void setValue(Value val) {_value = val;}
  public void setValue(int val) {_value = new IntegerLiteral(val);}
  public void setValue(String val) {_value = new StringLiteral(val);}
  /** Gives the textual representation of the expression. **/
  public abstract String accept(Visitor v);
  public abstract void execute(Interpreter i);
}
