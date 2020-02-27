package pex.operators;

import java.util.List;
import pex.Interpreter;
import pex.Expression;
import pex.Visitor;
import pex.InputVisitor;
import pex.Interpreter;
import pex.Parser;
import pex.ParserException;
import pex.exceptions.ExtraneousDataAtEndOfInputException;
import pex.exceptions.EndOfInputException;
import pex.exceptions.MissingClosingParenthesisException;
import pex.exceptions.UnknownOperationException;
import pex.exceptions.BadNumberException;
import pex.exceptions.BadExpressionException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;

/**
 * ProgramIO class contains IO functions in order to load and save to files.
 *
 */

public class ProgramIO {

	/**
	 * Loads the interpreter status from file.
         * @param the visitor of the interpreter.
	 * @param file
	 *          the name of file that contains the data.
	 * @throws IOException
	 *          just in case of reading problems
	 * @return Interpreter whose state was recovered from file.
	 * @throws ClassNotFoundException
	 * */
	public Interpreter load(Visitor v, String file) throws IOException, 
	ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		Interpreter interpreter = (Interpreter) in.readObject();
		in.close();
                interpreter.setVisitor(v);
		return interpreter;
	}
	
	/**
	 * Saves the current status of an interpreter.
	 * @param Interpreter
	 * @param file name
	 * @throws IOException
	 *               in case of trying to save on a read-only disk (example).
	 * */
	 public void save(Interpreter interpreter, String file) throws IOException {
		 interpreter.setName(file);
                 ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		 out.writeObject(interpreter);
		 out.close();
	 }
	 
	/**
	 * Parse the information about commands.
	 * @param interpreter
	 *               the interpreter to receive the new information.
	 * @param file name (pex extension)
	 * @throws ParserException
	 * */ 	
	 public void addFromInputFile(Interpreter interpreter, String file) throws ParserException {
		 
		Parser p = new Parser();
		interpreter.add(p.parseProgramFile(file));
	 }
	 
	 /**
	  * Save the program in textual representation to a file.
          * @param the visitor
	  * @param the program to be saved.
	  * @param the filename.
          * @throws IOException
	  * */
	 public void saveToText(Program program, Visitor v, String file) throws IOException {
		 BufferedWriter out = new BufferedWriter(new FileWriter(file));
		 List<Expression> exps = program.getExpressions();
		 for (Expression e: exps)
			out.write(e.accept(v));
                 out.write("\n");
		 out.close();
	 }

         /**
          * Parse a description and add it to a program.
          * @param program
          * @param index where to insert the new expression
          * @param description of the expression
          * @throws ParserException 
          **/ 
	 public void addParserExpProgram(Program program, int index, String description) throws ParserException {
              
              Parser p = new Parser();
              Expression e = p.parse(description);
              program.add(e, index);
         }
/**
          * Parse a description and replace it to a program.
          * @param program
          * @param index where to insert the new expression
          * @param description of the expression
          * @throws ParserException 
          **/ 
	 public void replaceParserExpProgram(Program program, int index, String description) throws ParserException {
              
              Parser p = new Parser();
              Expression e = p.parse(description);
              program.replace(e, index);
         }

}
