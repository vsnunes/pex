package pex;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import pex.atomic.Identifier;
import pex.operators.Program;
import pex.exceptions.ProgramNotFoundException;
/**
 * Interpreter class -> contains the identifiers and programs.
 * Note: The identifiers are shared beetwen programs.
 */
public class Interpreter implements Serializable{
	
	HashMap<String, Identifier>      _ids      = new HashMap<String, Identifier>();
	HashMap<String, Program>         _programs = new HashMap<String, Program>();
        /* The filename where to save the intepreter's status. */
        transient String _filename = null;

        transient Visitor _visitor; //sets how to display the program's operators.
        transient InputVisitor _inVisitor; //sets how to handle inputs
    
    /** Serial number for serialization. */
	private static final long serialVersionUID = 201611191614L;
    
    /**
     * Constructor of Interpreter class.
     * Requires a visitor.
     * @param the visitor
     **/
    public Interpreter(Visitor v, InputVisitor iv) {
       _visitor = v;
       _inVisitor = iv;}

    /**
     * Adds a program to an interpreter.
     * @param Program
     *               to be added.
     * */
	public void add(Program program) {
		_programs.put(program.getName(), program);
	}
	
	/**
	 * Adds a identifier to an interpreter.
	 * Note: if the id already exists then its replaced.
	 * @param Identifier
	 *                  to be added.
	 * */
	public void add(Identifier id) {
		if (idExists(id.getName()))
				_ids.remove(id.getName());
		_ids.put(id.getName(), id);
	}
	/**
	 * Check if a id has been added to the interpreter.
	 * @param Identifier (to be checked)
	 * @return true if id exists or false otherwise.
	 * */
	public boolean idExists(String id) {
		return _ids.containsKey(id);
	}

        public Identifier getId(String id) {
               return _ids.get(id);
        }
	
	/**
	 * Checks if a program's name already exists.
	 * @param program's name
	 * @return true if programs exists or false otherwise
	 * */
	public boolean programExists(String name) {
		return _programs.containsKey(name);
			
	}
	
	/**
	 * Get the expression of a program
	 * @param the program
	 * @return textual representation of all expression of the program.
	 * @throws ProgramNotFoundException if program dont exists.
	 * */
	public String evaluateProgram(String programName) throws ProgramNotFoundException {
		if (programExists(programName))
			return getProgram(programName).toString();
		throw new ProgramNotFoundException();
	}
	/**
	 * Returns the program whose program_id match the argument.
	 * @param program_id
	 * @return Program
	 * @throws ProgramNotFoundException if program dont exists.
	 * */
	public Program getProgram(String id) throws ProgramNotFoundException {
		if (programExists(id))
			return _programs.get(id);
		throw new ProgramNotFoundException();
	}
       
       /**
        * Sets the filename
        * The filename will allow to save the interpreter's state without prompting always.
        * @param filename
        **/
        public void setName(String name) {
            _filename = name;
        }

        /**
         * Returns the filename (if any)
         * @return the filename
         **/
        public String getName() { return _filename; }
        
        /**
         * Returns the visitor
         * @return the visitor
         **/
        public Visitor getVisitor() {return _visitor;}
        /**
         * Sets (change) the visitor
         * @param the new visitor
         **/
        public void setVisitor(Visitor v) {_visitor = v;}
        public InputVisitor getInVisitor() {return _inVisitor;}
        public void setInVisitor(InputVisitor v) {_inVisitor = v;}

        public List<Identifier> getIdentifiers() {
           return new ArrayList<Identifier>(_ids.values());
        }

        public List<Identifier> getIdentifiersByOrder() {
          ArrayList<Identifier> ids = new ArrayList<Identifier>(_ids.values());
          ids.sort(new Identifier()); /* sort by name */
          return ids;
        }

}
