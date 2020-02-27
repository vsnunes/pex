/*  */
package pex.operators;

import pex.Expression;

import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
/**
 * Class for describing binary operators.
 */
public abstract class BinaryExpression extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /** First operand. */
  Expression _first;

  /** Second operand. */
  Expression _second;

  /**
   * @param first
   *          first operand
   * @param second
   *          second operand
   */
  public BinaryExpression(Expression first, Expression second) {
    _first = first;
    _second = second;
  }

  /**
   * @return first operand
   */
  public Expression first() {
    return _first;
  }

  /**
   * @return second operand
   */
  public Expression second() {
    return _second;
  }
  
}
