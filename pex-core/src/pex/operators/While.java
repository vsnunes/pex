package pex.operators;

import pex.Expression;
import pex.Value;

import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
/**
 * Class for describing the While ('While') operator
 */
public class While extends Expression {
   /** Serial number for serialization. */
   private static final long serialVersionUID = 201612081005L;

  Expression _first;
  Expression _second;
  
  public While(Expression first, Expression second) {
	  _first = first;
	  _second = second;
  }

  public Expression first() {return _first;}
  public Expression second(){return _second;}

  @Override
  public String accept(Visitor v) {return v.visit(this);} 
  
  @Override
  public void execute(Interpreter i) {
   while(true) {
     first().execute(i);
     if((int)first().getExpValue().getValue() == 0) {
       super.setValue(0);
       return;
     }
     else {
       second().execute(i);
     }
  }
  }

}
