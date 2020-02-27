/*  */
package pex.operators;

import java.util.ArrayList;
import java.util.Collections;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import java.util.List;

import pex.Expression;

/**
 * Class representing a sequence of expressions.
 */
public class Sequence extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /**
   * Storage for expressions.
   */
  List<Expression> _expressions = null;

  /**
   * Default constructor (empty sequence).
   */
  public Sequence() {
    _expressions = new ArrayList<Expression>();
  }

  /**
   * Constructor for single-expression sequences.
   * 
   * @param expression
   */
  public Sequence(Expression expression) {
    _expressions = new ArrayList<Expression>();
    _expressions.add(expression);
  }

  /**
   * Constructor for appending expressions to sequences.
   * 
   * @param previous
   * @param expression
   */
  public Sequence(Sequence previous, Expression expression) {
    _expressions = previous._expressions;
    _expressions.add(expression);
  }

  /**
   * @param expressions
   */
  public Sequence(List<Expression> expressions) {
    _expressions = new ArrayList<Expression>();
    _expressions.addAll(expressions);
  }

  /**
   * @param ix
   *          index to get
   * @return the expression at ix
   */
  public Expression get(int ix) {
    return _expressions.get(ix);
  }

  /**
   * @param expression
   */
  public void add(Expression expression) {
    _expressions.add(expression);
  }

  /**
   * @param index
   * @param expression
   */
  public void add(int index, Expression expression) {
    _expressions.add(index, expression);
  }

  /**
   * @param index
   * @param expression
   */
  public void set(int index, Expression expression) {
    _expressions.set(index, expression);
  }

  /**
   * @return a list with all the expressions
   */
  public List<Expression> getAll() {
    return Collections.unmodifiableList(_expressions);
  }

  /**
   * @return last expression
   */
  public Expression getLastExpression() {
    try {
      return _expressions.get(_expressions.size() - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  /**
   * @return size of sequence
   */
  public int size() {
    return _expressions.size();
  }

 @Override
 public String accept(Visitor v) {return v.visit(this);}

  @Override
  public void execute(Interpreter i) {
    Expression last = null;
    for (Expression e: _expressions) {
      e.execute(i);
      last = e;
    }
   if (last == null) {
     super.setValue(0); /* if the sequence is empty the value is zero. */
     return;
   }
      super.setValue(last.getExpValue());

  }

}
