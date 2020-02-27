/*  */
package pex.atomic;

import java.lang.Comparable;
import java.util.Comparator;
import pex.Expression;
import pex.Value;
import pex.Visitor;
import pex.Interpreter;
/**
 * Class for describing syntactic tree leaves for holding identifier values.
 */
public class Identifier extends Expression implements Comparator<Identifier>, Comparable<Identifier> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201612081005L;

  /** Identifier name. */
  private String _name;

  public Identifier(Interpreter i, Expression first, Expression second) {
    first.execute(i);
    _name = (String)first.getExpValue().getValue();
    second.execute(i);
    super.setValue(second.getExpValue());
    i.add(this);
  }

  /**
   * @param name
   * @param expression
   */
  public Identifier(Interpreter i, String name, Expression exp) {
    _name = name;
    exp.execute(i);
    super.setValue(exp.getExpValue());
    i.add(this);
  }

  public Identifier(String name, Value value) {
    _name = name;
    super.setValue(value);
  }

  public Identifier(String name) {
    _name = name;
    super.setValue(0);
  }

  public Identifier() { }


  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }

  @Override
  public String accept(Visitor v) {return v.visit(this);}
   
  @Override
  public void execute(Interpreter i) { 
   if (i.idExists(_name))
     super.setValue(i.getId(_name).getExpValue());

 }

  public int compareTo(Identifier id) {
    return _name.compareTo(id.getName()); /*ids are compared by its name*/
  }

  public int compare(Identifier i1, Identifier i2) {
    return i1.compareTo(i2);
  }

}
