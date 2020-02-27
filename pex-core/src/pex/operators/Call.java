package pex.operators;

import pex.atomic.StringLiteral;
import pex.Expression;
import pex.Value;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import pex.exceptions.ProgramNotFoundException;

/**
 * Class for describing the Call ('call') operator
 */
public class Call extends Expression {
   /** Serial number for serialization. */
   private static final long serialVersionUID = 201612081005L;
   Expression _programName;
   
   public Call(Expression expression)
   {
	 _programName = expression;
         //  _programName = new StringLiteral(expression.toString());
   }
 
  public Expression argument() {return _programName;}
 
   @Override
   public String accept(Visitor v) {return v.visit(this);}
  
  @Override
  public void execute(Interpreter i) {
   try {
        _programName.execute(i);
        Program program = i.getProgram((String)_programName.getExpValue().getValue());
        program.execute(i);
        super.setValue(program.getExpValue());
   }
   catch(ProgramNotFoundException e) {e.printStackTrace();}
  }
}
