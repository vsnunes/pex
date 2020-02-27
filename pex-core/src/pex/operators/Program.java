/*  */
package pex.operators;

import java.util.*;
import pex.Expression;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import pex.atomic.Identifier;
import java.io.Serializable;

/**
 * Class for describing programs.
 */
public class Program extends Expression implements Serializable {
	/** Program's name */
	private String _name;
	/** List of program's expressions */
	private List<Expression> _expressions;
	
	/**
	 * Constructor for class Program
	 * @param program's name
	 * 
	 * */
	 public Program(String name) {
		 _name = name;
		 _expressions = new ArrayList<Expression>();
	 }
	 /**
	  * Constructor for class Program
	  * By default when you don't specify the program name, it become 'import'.
	  * */
	 public Program() {
		 _name = "import";
		 _expressions = new ArrayList<Expression>();
	 }
	 /**
	  * Getters and setters of name.
	  * */
	 public String getName() {return _name;}
	 public void setName(String name) {_name = name;}
	 
	 /**
	  * Add an expression
	  * @param the expression
	  * 				to be added.
	  * */
	 public void add(Expression exp) {
		 _expressions.add(exp);
	 }

         /**
          * Add an expression at a specific index.
          * @param expression to be added.
          * @param index where to add the expression
          */
	 public void add(Expression exp, int index) {
            _expressions.add(index,exp);
         }

         /**
          * Replaces an instruction
          * @param new_expression to be added
          * @param index of the current (and marked to be replaced) expression.
          **/
         public void replace(Expression exp, int index) {
            _expressions.remove(index);
            _expressions.add(index,exp);
         }
	 /**
	  * Returns the expressions of the current program.
	  * @return expressions
	  * */
	 public List<Expression> getExpressions() {
		 return Collections.unmodifiableList(_expressions);
	 }
	 
	 /**
	  * Define the default evaluate process of a program.
	  * By default this returns a textual representation of all
	  * expressions.
          * @param  the expression's visitor
	  * @return textual_representation.
	  * */
	  
	  public String toString(Visitor vi) {
		 String txt_rep = "";
		 for (Expression exp: _expressions)
			{
				txt_rep = txt_rep + exp.accept(vi) + "\n";
			}
		return txt_rep;
	 }
         /**
          * Returns a list with all identifiers in the program.
          * @param expression to search.
          * @param ids to add the identifiers name (if find any)
          * @param init true if want to display only the initalized identifiers, false to get all identifiers.
          * @return ids
          * This is an auxiliar function to search. See the next function more information. 
          **/
         private ArrayList<String> getIdentifiers(Expression e, ArrayList<String> ids, boolean init) {
            if ((init)&&(e instanceof Set)) {
				Set s = (Set)e;
				Identifier i = (Identifier)s.first();
                                if (!ids.contains(i.getName()))
				   ids.add(i.getName());
				return ids; /* prevents catch the Set as a binary expression */
			}
			else if ((!init) && (e instanceof Identifier)) {
				Identifier i = (Identifier)e;
                                if (!ids.contains(i.getName()))
				   ids.add(i.getName());
			}
                             if (e instanceof UnaryExpression) {
                                 UnaryExpression un = (UnaryExpression)e;
                                 ids = getIdentifiers(un.argument(), ids, init);
                             }
                             if (e instanceof BinaryExpression){
				 BinaryExpression be = (BinaryExpression)e;
				 ids = getIdentifiers(be.first(), ids, init);
			         ids = getIdentifiers(be.second(), ids, init);
		             }
		             if (e instanceof Print) {
			     Print p = (Print)e;
				for (Expression ex : p.getAll())
					ids = getIdentifiers(ex, ids, init);
			}
			if (e instanceof Sequence) {
				Sequence s = (Sequence)e;
				for (Expression ex: s.getAll())
					ids = getIdentifiers(ex, ids, init);
			}
			if (e instanceof While) {
				While w = (While)e;
				ids = getIdentifiers(w.first(), ids, init);
				ids = getIdentifiers(w.second(), ids, init);
			}
			if (e instanceof If) {
				If i = (If)e;
				ids = getIdentifiers(i.first(), ids, init);
				ids = getIdentifiers(i.second(), ids, init);
				ids = getIdentifiers(i.third(), ids, init);
			}
                        if (e instanceof Call) {
                                Call c = (Call)e;
                                ids = getIdentifiers(c.argument(), ids, init);
                        }
            
            return ids;
         }
         
         /**
          * Searchs for identifiers in a program.
          * @param init false will get all identifiers, true only gets the initalized identifiers. (identifiers with set operator)
          * @return ids containing the ids found on this program.
          * */
         public ArrayList<String> getIdentifiers(boolean init) {
			 ArrayList<String> ids = new ArrayList<String>();
			 for (Expression e : _expressions) {
				 ids = getIdentifiers(e,ids, false);
			 }
			 if (init) {
				 ArrayList<String> init_ids = new ArrayList<String>();
				 for (Expression e: _expressions) {
					init_ids = getIdentifiers(e,init_ids,true);
				 }
				 for (String s: init_ids) {
						ids.remove(s); //remove the initialized identifiers.
				 }
			 }

                         Collections.sort(ids);
			 return ids;
		 }

         /**
          * Get the number of expression in a program.
          * @return number of expressions.
          **/
         public int getElements() {return _expressions.size();}

         public String accept(Visitor v) {return v.visit(this);}    

         public final void execute(Interpreter i) {
             try {
             Expression last = null;
             for(Expression e: _expressions) {
                 e.execute(i);
                 last = e;
             }
			 if (last == null)
				super.setValue(0);
             else super.setValue(last.getExpValue()); /* the value of a program its the value of the last expression */
                 }
             catch(ClassCastException e) {}
             catch(NullPointerException e) {}
         }
}
