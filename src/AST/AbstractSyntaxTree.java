package AST;

//import org.abego.treelayout.TreeLayout;

//import javax.swing.JOptionPane;
//import javax.xml.parsers.*;

//import org.w3c.dom.*;
//import org.xml.sax.*;
//import org.antlr.runtime.tree.TreeWizard.Visitor;

//import org.antlr.runtime.tree.DOTTreeGenerator;
//import org.antlr.stringtemplate.StringTemplate;
//import java.beans.XMLEncoder;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
//import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//import java.lang.Object;

import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.Lexer;
//import org.antlr.v4.runtime.LexerInterpreter;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionMode;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.ErrorNode;
//import org.antlr.v4.runtime.tree.ParseTreeListener;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
//import org.antlr.v4.tool.DOTGenerator;
//import javax.swing.JOptionPane;
//import javax.swing.plaf.SeparatorUI;
//import java.util.ArrayList;
//import java.util.List;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
//import generated.JavaLexer;

class AbstractSyntaxTree {
// public static long lexerTime = 0;
public static boolean profile = true;
public static boolean notree = true;
public static boolean gui = true;
public static boolean printTree = true;
public static boolean SLL = true;
public static boolean diag = true;
public static boolean bail = true;
public static boolean x2 = false;
public static boolean threaded = false;
public static boolean quiet = false;
public static Worker[] workers = new Worker[3];
static int windex = 0;
public static CyclicBarrier barrier;
public static volatile boolean firstPassDone = false;
public static class Worker implements Runnable {
public long parserStart;
public long parserStop;
List<String> files;

public Worker(List<String> files) {
this.files = files;
}

@Override
public void run() {
			parserStart = System.currentTimeMillis();
			for (String f : files) {
			parseFile(f);
			}
			parserStop = System.currentTimeMillis();
			try {
			barrier.await();
			}
			catch (InterruptedException ex) {
			return;
			}
			catch (BrokenBarrierException ex) {
			return;
			}
			}
}

public class MethodVisitor extends ASTVisitor {
	  List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	    @Override
	    public boolean visit(MethodDeclaration node) {
	      methods.add(node);
	      return super.visit(node);
	    }

	    public List<MethodDeclaration> getMethods() {
	      return methods;
	    }
	}
public static void main(String[] args) {
doAll(args);


}
public static void doAll(String[] args) {
			List<String> inputFiles = new ArrayList<String>();
			//long start = System.currentTimeMillis();
			try {
			if (args.length > 0 ) {
			// for each directory/file specified on the command line
			for(int i=0; i< args.length;i++) {
			if ( args[i].equals("-notree") ) notree = true;
			else if ( args[i].equals("-gui") ) gui = true;
			else if ( args[i].equals("-ptree") ) printTree = true;
			else if ( args[i].equals("-SLL") ) SLL = true;
			else if ( args[i].equals("-bail") ) bail = true;
			else if ( args[i].equals("-diag") ) diag = true;
			else if ( args[i].equals("-2x") ) x2 = true;
			else if ( args[i].equals("-threaded") ) threaded = true;
			else if ( args[i].equals("-quiet") ) quiet = true;
			if ( args[i].charAt(0)!='-' ) { // input file name
			inputFiles.add(args[i]);
			}
			}
			List<String> javaFiles = new ArrayList<String>();
			for (String fileName : inputFiles) {
			List<String> files = getFilenames(new File(fileName));
			javaFiles.addAll(files);
			}
			doFiles(javaFiles);

			if ( x2 ) {
			System.gc();
			System.out.println("waiting for 1st pass");
			if ( threaded ) while ( !firstPassDone ) { } // spin
			System.out.println("2nd pass");
			doFiles(javaFiles);
			}
			}
			else {
			System.err.println("Usage: java Main <directory or file name>");
			}
			}
			catch(Exception e) {
			System.err.println("exception: "+e);
			e.printStackTrace(System.err); // so we can get stack trace
			}
			//long stop = System.currentTimeMillis();
			// System.out.println("Overall time " + (stop - start) + "ms.");
			System.gc();
}
public static void doFiles(List<String> files) throws Exception {
			long parserStart = System.currentTimeMillis();
			// lexerTime = 0;
			if ( threaded ) {
			barrier = new CyclicBarrier(3,new Runnable() {
			public void run() {
			report(); firstPassDone = true;
			}
			});
			int chunkSize = files.size() / 3; // 10/3 = 3
			int p1 = chunkSize; // 0..3
			int p2 = 2 * chunkSize; // 4..6, then 7..10
			workers[0] = new Worker(files.subList(0,p1+1));
			workers[1] = new Worker(files.subList(p1+1,p2+1));
			workers[2] = new Worker(files.subList(p2+1,files.size()));
			new Thread(workers[0], "worker-"+windex++).start();
			new Thread(workers[1], "worker-"+windex++).start();
			new Thread(workers[2], "worker-"+windex++).start();
			}
			else {
			for (String f : files) {
			parseFile(f);
			}
			long parserStop = System.currentTimeMillis();
			System.out.println("Total lexer+parser time " + (parserStop - parserStart) + "ms.");
			}
}
private static void report() {
			long time = 0;
			if ( workers!=null ) {
			// compute max as it's overlapped time
			for (Worker w : workers) {
			long wtime = w.parserStop - w.parserStart;
			time = Math.max(time,wtime);
			System.out.println("worker time " + wtime + "ms.");
			}
			}
			System.out.println("Total lexer+parser time " + time + "ms.");
			System.out.println("finished parsing OK");
			System.out.println(LexerATNSimulator.match_calls+" lexer match calls");
}

public static List<String> getFilenames(File f) throws Exception {
			List<String> files = new ArrayList<String>();
			getFilenames_(f, files);
			return files;
}

public static void getFilenames_(File f, List<String> files) throws Exception {
			// If this is a directory, walk each file/dir in that directory
			if (f.isDirectory()) {
			String flist[] = f.list();
			for(int i=0; i < flist.length; i++) {
			getFilenames_(new File(f, flist[i]), files);
			}
			}
			// otherwise, if this is a java file, parse it!
			else if ( ((f.getName().length()>5) &&
			f.getName().substring(f.getName().length()-5).equals(".java")) )
			{
			files.add(f.getAbsolutePath());
			}
}

public static String formatParseTree(ParseTree tree, String separator) {
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < tree.getChildCount(); i ++) {
        ParseTree child = tree.getChild(i);
        
        if(child instanceof TerminalNode) {
        	//builder.append(" deneme "+child.getClass());
        	builder.append(child.getParent().getText());
        	//builder.append(child.getText());
            builder.append(separator);
        } else if(child instanceof RuleContext) {
            builder.append(formatParseTree(child, separator));
        }
    }

    return(builder.toString());
}

public static void parseFile(String f) {
			try {
					if ( !quiet ) System.err.println(f);
					
					// Create a scanner that reads from the input stream passed to us
					ANTLRFileStream input=new ANTLRFileStream(f);
					Lexer lexer = new JavaLexer(input);
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					//System.out.println("tokens "+tokens.getText());
					
					// Create a parser that reads from the scanner
					JavaParser parser = new JavaParser(tokens);
					ParseTree tree = parser.compilationUnit();
					
					//JOptionPane.showMessageDialog(null,parser.tokenNames[1].toString());
					if ( diag ) parser.addErrorListener(new DiagnosticErrorListener());
					if ( bail ) parser.setErrorHandler(new BailErrorStrategy());
					if ( SLL ) parser.getInterpreter().setPredictionMode(PredictionMode.SLL);

					// start parsing at the compilationUnit rule
					ParserRuleContext t = parser.compilationUnit();
					
					if ( notree ) parser.setBuildParseTree(false);
					if ( gui ) t.inspect(parser);				
					if ( printTree ) System.out.println(t.toStringTree(parser));
															        
					//JOptionPane.showMessageDialog(null, f.toString().substring(53)+".txt");
					FileWriter fw = new FileWriter("C:\\Users\\MrtOrc\\Desktop\\Graph Mining\\Subgraph Mining in OO Projects\\zest\\zest\\src\\org\\zkoss\\zest\\sys\\ZestFilter.txt");
		            fw.write(t.toStringTree(parser).toString());
		            fw.close();
		                      
		            System.out.println(tree.getText());
		            String separator="\n";
		            System.out.println("tree burdan ba�l�yor "+formatParseTree(tree,separator)+"murat");
		            
			}
			catch (Exception e) {
			System.err.println("parser exception: "+e);
			e.printStackTrace(); // so we can get stack trace
			}
}



}