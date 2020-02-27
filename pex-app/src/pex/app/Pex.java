package pex.app;

import pex.Visitor;
import pex.Expression;
import pex.atomic.*;
import pex.operators.*;
/*
 * Pex textual representation.
 */
public class Pex implements Visitor {
  public String visit(Add o) {return "(add " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(And o) {return "(and " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 
  
  public String visit(Sub o) {return "(sub " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 
  
  public String visit(Div o) {return "(div " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Eq o) {return "(eq " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Mul o) {return "(mul " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Ge o) {return "(ge " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Gt o) {return "(gt " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Le o) {return "(le " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Lt o) {return "(lt " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Mod o) {return "(mod " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Ne o) {return "(ne " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(Or o) {return "(or " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 
  
  public String visit(Set o) {return "(set " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(While o) {return "(while " + o.first().accept(this) + " " + o.second().accept(this) + ")";} 

  public String visit(If o) {return "(if " + o.first().accept(this) + " " + o.second().accept(this) + " " + o.third().accept(this) + ")";}

  public String visit(Not o) {return "(not " + o.argument().accept(this) + ")";}

  public String visit(Neg o) {return "(neg " + o.argument().accept(this) + ")";}

  public String visit(Call o) {return "(call " + o.argument().accept(this) + ")";}

  public String visit(ReadI o) {return "(readi)";}
  public String visit(ReadS o) {return "(reads)";}

  public String visit(IntegerLiteral o) {return o.toString();}

  public String visit(StringLiteral o) {return "\"" + o.toString() + "\"";}

  public String visit(Sequence o) {
   String rep = "(seq";
     for (Expression e : o.getAll())
        rep = rep + " " + e.accept(this);
     rep += ")";
     return rep;

 }

  public String visit(Print o) {
  String rep = "(print";
     for (Expression e : o.getAll())
        rep = rep + " " + e.accept(this);
     rep += ")";
     return rep;
  }

  public String visit(Identifier o) {return o.getName();}

  public String visit(Program o) {
   String rep = "";
   for (Expression e: o.getExpressions())
     rep = rep + e.accept(this) + "\n";
   return rep;
  }
}
