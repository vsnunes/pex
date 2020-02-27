package pex.operators;

import pex.atomic.StringLiteral;
import pex.Expression;
import pex.Value;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;

/**
 * Class for describing the If ('if') operator
 */
public class If extends Expression {
   /** Serial number for serialization. */
   private static final long serialVersionUID = 201612081005L;

   Expression _first;
   Expression _second;
   Expression _third;
   
   public If(Expression first, Expression second, Expression third) {
	   _first = first;
	   _second = second;
	   _third = third;
   }

  public Expression first() {return _first;}
  public Expression second(){return _second;}
  public Expression third() {return _third;}

  @Override
  public String accept(Visitor v) {return v.visit(this);}
 
  @Override
  public void execute(Interpreter i) {
    first().execute(i);
    if((int)first().getExpValue().getValue() != 0) {
      second().execute(i);
      super.setValue(second().getExpValue());
    }
    else {
       third().execute(i);
       super.setValue(third().getExpValue());
    }
  }

}
