package pex;

import pex.atomic.Identifier;
import pex.atomic.IntegerLiteral;
import pex.atomic.StringLiteral;
import pex.operators.*;
/**
 * Interface to handle textual representation of atomic literals and programs.
 **/
public interface Visitor{
  /* Visitor for atomic values */
  String visit(IntegerLiteral literal);
  String visit(StringLiteral literal);
  String visit(Identifier id);

  /* Visitor for operators */
  String visit(Add operator);
  String visit(And operator);
  String visit(Call operator);
  String visit(Div operator);
  String visit(Eq operator);
  String visit(Ge operator);
  String visit(Gt operator);
  String visit(If operator);
  String visit(Le operator);
  String visit(Lt operator);
  String visit(Mod operator);
  String visit(Mul operator);
  String visit(Ne operator);
  String visit(Neg operator);
  String visit(Not operator);
  String visit(Or operator);
  String visit(Print operator);
  String visit(ReadI operator);
  String visit(ReadS operator);
  String visit(Sequence operator);
  String visit(Set operator);
  String visit(Sub operator);
  String visit(While operator);

  String visit(Program operator);

}
