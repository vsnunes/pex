
package pex;

/**
 * Interface to handle inputs from the user.
 **/

public interface InputVisitor {
  String inputString();
  int    inputInteger();
  void   output(String s);
}
