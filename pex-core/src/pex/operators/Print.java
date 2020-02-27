package pex.operators;

import pex.Expression;
import pex.atomic.Identifier;
import pex.Value;
import java.util.ArrayList;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import java.util.Collections;
import java.util.List;

/**
 * Class for describing the print ('print') operator
 */
public class Print extends Expression {
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;
 /**
   * Storage for expressions.
   */
  List<Expression> _expressions = null;
  
  /**
   * Default constructor (empty sequence).
   */
  public Print() {
    _expressions = new ArrayList<Expression>();
  }

  /**
   * Constructor for single-expression.
   * 
   * @param expression
   */
  public Print(Expression expression) {
    _expressions = new ArrayList<Expression>();
    _expressions.add(expression);
  }
  
  /**
   * @param expressions
   */
  public Print(List<Expression> expressions) {
    _expressions = new ArrayList<Expression>();
    _expressions.addAll(expressions);
  }
  /**
   * @return a list with all expressions
   */

  public List<Expression> getAll() {
    return Collections.unmodifiableList(_expressions);
  }


  @Override
  public String accept(Visitor v) {return v.visit(this);} 
  
  @Override
  public void execute(Interpreter i) {
    Expression last = null;
    String output = "";
    for (Expression e : _expressions) {
        e.execute(i); /* executes all expression in order to get the values */
        output += e.getExpValue().toString();
        last = e;
    }
    i.getInVisitor().output(output);
   /* the last argument is the value of this expression */
      super.setValue(last.getExpValue());
  }

 
}
