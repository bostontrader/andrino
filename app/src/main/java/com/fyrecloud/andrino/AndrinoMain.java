package com.fyrecloud.andrino;

import java.util.ArrayList;
import java.util.List;

//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.ContextAction;
//import org.mozilla.javascript.EvaluatorException;
//import org.mozilla.javascript.Function;
//import org.mozilla.javascript.Kit;
//import org.mozilla.javascript.RhinoException;
//import org.mozilla.javascript.Script;
//import org.mozilla.javascript.Scriptable;
//import org.mozilla.javascript.tools.shell.Global;
//import org.mozilla.javascript.tools.shell.QuitAction;
//import org.mozilla.javascript.tools.shell.ShellContextFactory;

/**
 * The shell program.
 *
 * Can execute scripts interactively or in batch mode at the command line.
 * An example of controlling the JavaScript engine.
 */
public class AndrinoMain {

	//public boolean fAndrino = true;	// hack that says "this is Andrino"
	//public Context andrinoCx;
	//public SecurityDomain andrinoSecurityDomain;
	//public int andrinoLineno;
	//public String andrinoSource;

	//public static ShellContextFactory
	//shellContextFactory = new ShellContextFactory();
	//private ShellContextFactory shellContextFactory = new ShellContextFactory();

	//public static Global global = new Global();
	//private Global global = new Global();

	//static protected ToolErrorReporter errorReporter;

	//static protected int exitCode = 0;
	//private int exitCode = 0;

	//static private final int EXITCODE_RUNTIME_ERROR = 3;
	//private final int EXITCODE_RUNTIME_ERROR = 3;
	//static private final int EXITCODE_FILE_NOT_FOUND = 4;
	//static boolean processStdin = true;

	//static List<String> fileList = new ArrayList<String>();
	//private List<String> fileList = new ArrayList<String>();

	//private static SecurityProxy securityImpl;

	//static {
	//global.initQuitAction(new IProxy(IProxy.SYSTEM_EXIT));
	//}

	/**
	 * Proxy class to avoid proliferation of anonymous classes.
	 */
	//private static class IProxy implements ContextAction, QuitAction {
	/*private class IProxy implements ContextAction, QuitAction {
		private static final int PROCESS_FILES = 1;
		private static final int EVAL_INLINE_SCRIPT = 2;
		private static final int SYSTEM_EXIT = 3;

		private int type;
		public String[] args;
		private String scriptText;

		IProxy(int type) {this.type = type;}

		public Object run(Context cx) {
			if (type == PROCESS_FILES) {
				processFiles(cx, args);
			} else if (type == EVAL_INLINE_SCRIPT) {
				Script script = loadScriptFromSource(
					cx, scriptText,
					"<command>", 1, null
				);
				if (script != null) {
					evaluateScript(script, cx, getGlobal());
				}
			} else {
				throw Kit.codeBug();
			}
			return null;
		}
	
		public void quit(Context cx, int exitCode) {
			if (type == SYSTEM_EXIT) {
				System.exit(exitCode);
				return;
			}
				throw Kit.codeBug();
		}
	}*/

	/**
	 * Main entry point.
	 *
	 * Process arguments as would a normal Java program. Also
	 * create a new Context and associate it with the current thread.
	 * Then set up the execution environment and begin to
	 * execute scripts.
	 */
	//public static void main(String args[]) {
	//public void main(String args[]) {
		//try {
		//if (Boolean.getBoolean("rhino.use_java_policy_security")) {
		//initJavaPolicySecuritySupport();
		//}
		//} catch (SecurityException ex) {
		//ex.printStackTrace(System.err);
		//}
	
		//int result = exec(args);
		//exec(args);
		//if (result != 0) {
		//System.exit(result);
		//}
	//}

	/**
	 *Execute the given arguments, but don't System.exit at the end.
	 */
	//public static int exec(String origArgs[])
	//private int exec(String origArgs[]) {
		//errorReporter = new ToolErrorReporter(false, global.getErr());
		//shellContextFactory.setErrorReporter(errorReporter);
		//String[] args = processOptions(origArgs);
		//if (processStdin)
		//fileList.add(null);

		//if (!global.initialized) {
		//global.init(shellContextFactory);
		//}
		//IProxy iproxy = new IProxy(IProxy.PROCESS_FILES);
		//iproxy.args = args;
		//iproxy.args = origArgs;
		//shellContextFactory.call(iproxy);

		//return exitCode;
		//return 0; // tfr
	//}

	//private void processFiles(Context cx, String[] args) {
		// define "arguments" array in the top-level object:
		// need to allocate new array since newArray requires instances
		// of exactly Object[], not ObjectSubclass[]
		//Object[] array = new Object[args.length];
		//System.arraycopy(args, 0, array, 0, args.length);
		//Scriptable argsObj = cx.newArray(global, array);
		//global.defineProperty("arguments", argsObj,
		//ScriptableObject.DONTENUM);

		//for (String file: fileList) {
			//processSource(cx, file);
		//}
	//}

	//private Global getGlobal() {return global;}

/**
 * Parse arguments.
 */
	//public static String[] processOptions(String args[])
	//{
	//String usageError;
	//goodUsage: for (int i = 0; ; ++i) {
	//if (i == args.length) {
	//return new String[0];
	//}
	//String arg = args[i];
	//if (!arg.startsWith("-")) {
	//processStdin = false;
	//fileList.add(arg);
	//String[] result = new String[args.length - i - 1];
	//System.arraycopy(args, i+1, result, 0, args.length - i - 1);
	//return result;
	//}
	//if (arg.equals("-version")) {
	//if (++i == args.length) {
	//usageError = arg;
	//break goodUsage;
	//}
	//int version;
	//try {
	//version = Integer.parseInt(args[i]);
	//} catch (NumberFormatException ex) {
	//usageError = args[i];
	//break goodUsage;
	//}
	//if (!Context.isValidLanguageVersion(version)) {
	//usageError = args[i];
	//break goodUsage;
	//}
	//shellContextFactory.setLanguageVersion(version);
	//continue;
	//}
	//if (arg.equals("-opt") || arg.equals("-O")) {
/*if (++i == args.length) {
usageError = arg;
break goodUsage;
}
int opt;
try {
opt = Integer.parseInt(args[i]);
} catch (NumberFormatException ex) {
usageError = args[i];
break goodUsage;
}
if (opt == -2) {
// Compatibility with Cocoon Rhino fork
opt = -1;
} else if (!Context.isValidOptimizationLevel(opt)) {
usageError = args[i];
break goodUsage;
}
shellContextFactory.setOptimizationLevel(opt);
continue;
}
if (arg.equals("-encoding")) {
if (++i == args.length) {
usageError = arg;
break goodUsage;
}
String enc = args[i];
shellContextFactory.setCharacterEncoding(enc);
continue;
}
if (arg.equals("-strict")) {
shellContextFactory.setStrictMode(true);
errorReporter.setIsReportingWarnings(true);
continue;
}
if (arg.equals("-fatal-warnings")) {
shellContextFactory.setWarningAsError(true);
continue;
}
if (arg.equals("-e")) {
processStdin = false;
if (++i == args.length) {
usageError = arg;
break goodUsage;
}
if (!global.initialized) {
global.init(shellContextFactory);
}
IProxy iproxy = new IProxy(IProxy.EVAL_INLINE_SCRIPT);
iproxy.scriptText = args[i];
shellContextFactory.call(iproxy);
continue;
}
if (arg.equals("-w")) {
errorReporter.setIsReportingWarnings(true);
continue;
}
if (arg.equals("-f")) {
processStdin = false;
if (++i == args.length) {
usageError = arg;
break goodUsage;
}
fileList.add(args[i].equals("-") ? null : args[i]);
continue;
}
if (arg.equals("-sealedlib")) {
global.setSealedStdLib(true);
continue;
}
if (arg.equals("-debug")) {
shellContextFactory.setGeneratingDebug(true);
continue;
}
if (arg.equals("-?") ||
arg.equals("-help")) {
// print usage message
global.getOut().println(
ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
System.exit(1);
}
usageError = arg;
break goodUsage;
}
// print error and usage message
global.getOut().println(
ToolErrorReporter.getMessage("msg.shell.invalid", usageError));
global.getOut().println(
ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
System.exit(1);
return null;
}

private static void initJavaPolicySecuritySupport()
{
Throwable exObj;
try {
Class<?> cl = Class.forName
("org.mozilla.javascript.tools.shell.JavaPolicySecurity");
securityImpl = (SecurityProxy)cl.newInstance();
SecurityController.initGlobal(securityImpl);
return;
} catch (ClassNotFoundException ex) {
exObj = ex;
} catch (IllegalAccessException ex) {
exObj = ex;
} catch (InstantiationException ex) {
exObj = ex;
} catch (LinkageError ex) {
exObj = ex;
}
throw Kit.initCause(new IllegalStateException(
"Can not load security support: "+exObj), exObj);
}*/

	//public String processSourceAndrino(String newline) {
		//if (filename == null || filename.equals("-")) {
		//PrintStream ps = global.getErr();
		//if (filename == null) {
		// print implementation version
		//ps.println(cx.getImplementationVersion());
		//}
		// Use the interpreter for interactive input
		//cx.setOptimizationLevel(-1);
		//String charEnc = shellContextFactory.getCharacterEncoding();
		//if(charEnc == null)
		//{
		//charEnc = System.getProperty("file.encoding");
		//}
		//BufferedReader in;
		//try
		//{
		//in = new BufferedReader(new InputStreamReader(global.getIn(), 
		//charEnc));
		//}
		//catch(UnsupportedEncodingException e)
		//{
		//throw new UndeclaredThrowableException(e);
		//}
		//int lineno = 1;
		//boolean hitEOF = false;
		//while (!hitEOF) {
		//String[] prompts = global.getPrompts(cx);
		//if (filename == null)
		//ps.print(prompts[0]);
		//ps.flush();
		//String source = "";
		// Collect lines of source to compile.
		//while (true) {
		//String newline;
		//try {
		//newline = in.readLine();
		//newline = "Math.PI";
		//}
		//catch (IOException ioe) {
		//ps.println(ioe.toString());
		//break;
		//}
		//if (newline == null) {
		//hitEOF = true;
		//break;
		//}
		//andrinoSource = andrinoSource + newline + "\n";
		//andrinoLineno++;
		//if (cx.stringIsCompilableUnit(source))
		//break;
		//ps.print(prompts[1]);
		//}
		/*Script script = loadScriptFromSource(andrinoCx, andrinoSource, "<stdin>", andrinoLineno, null);
		if (script != null) {
			Object result = evaluateScript(script, andrinoCx, global);
			// Avoid printing out undefined or function definitions.
			if (result != Context.getUndefinedValue() && !(result instanceof Function && andrinoSource.trim().startsWith("function"))) {
				//try {
				//ps.println(Context.toString(result));
				//} catch (RhinoException rex) {
				//ToolErrorReporter.reportException(
				//cx.getErrorReporter(), rex);
				//}
				// stuff this into list view
				String s = result.toString();
				//System.out.println(s);
				return s;
			}

			//NativeArray h = global.history;
			//h.put((int)h.getLength(), h, source);
			//}
			//}
			//ps.println();
			//} else {
			//processFile(cx, global, filename);
		}
		//System.gc();
		return "nada";
	}*/

	/**
	 * Evaluate JavaScript source.
	 *
	 * @param cx the current context
	 * @param filename the name of the file to compile, or null
	 * for interactive mode.
	 */
/*	private void processSource(Context cx, String filename) {
		//if (filename == null || filename.equals("-")) {
		//PrintStream ps = global.getErr();
		//if (filename == null) {
		// print implementation version
		//ps.println(cx.getImplementationVersion());
		//}
		// Use the interpreter for interactive input
		andrinoCx = cx;
		cx.setOptimizationLevel(-1);
		if (fAndrino) return;
		//String charEnc = shellContextFactory.getCharacterEncoding();
		//if(charEnc == null)
		//{
		//charEnc = System.getProperty("file.encoding");
		//}
		//BufferedReader in;
		//try
		//{
		//in = new BufferedReader(new InputStreamReader(global.getIn(), 
		//charEnc));
		//}
		//catch(UnsupportedEncodingException e)
		//{
		//throw new UndeclaredThrowableException(e);
		//}
		int lineno = 1;
		//boolean hitEOF = false;
		//while (!hitEOF) {
		//String[] prompts = global.getPrompts(cx);
		//if (filename == null)
		//ps.print(prompts[0]);
		//ps.flush();
		String source = "";
		// Collect lines of source to compile.
		//while (true) {
		String newline;
		//try {
		//newline = in.readLine();
		newline = "Math.PI";
		//}
		//catch (IOException ioe) {
		//ps.println(ioe.toString());
		//break;
		//}
		//if (newline == null) {
		//hitEOF = true;
		//break;
		//}
		source = source + newline + "\n";
		lineno++;
		//if (cx.stringIsCompilableUnit(source))
		//break;
		//ps.print(prompts[1]);
		//}
		Script script = loadScriptFromSource(cx, source, "<stdin>", lineno, null);
		//if (script != null) {
		Object result = evaluateScript(script, cx, global);

		// Avoid printing out undefined or function definitions.
		if (result != Context.getUndefinedValue() && !(result instanceof Function && source.trim().startsWith("function"))) {
			//try {
			//ps.println(Context.toString(result));
			//} catch (RhinoException rex) {
			//ToolErrorReporter.reportException(
			//cx.getErrorReporter(), rex);
			//}

			// stuff this into list view
			String s = result.toString();
			System.out.println(s);

		}*/

		//NativeArray h = global.history;
		//h.put((int)h.getLength(), h, source);
		//}
		//}
		//ps.println();
		//} else {
		//processFile(cx, global, filename);
		//}
		//System.gc();
	}

/*public static void processFile(Context cx, Scriptable scope,
 String filename)
{
if (securityImpl == null) {
processFileSecure(cx, scope, filename, null);
} else {
securityImpl.callProcessFileSecure(cx, scope, filename);
}
}

static void processFileSecure(Context cx, Scriptable scope,
String path, Object securityDomain)
{
Script script;
if (path.endsWith(".class")) {
script = loadCompiledScript(cx, path, securityDomain);
} else {
String source = (String)readFileOrUrl(path, true);
if (source == null) {
exitCode = EXITCODE_FILE_NOT_FOUND;
return;
}

// Support the executable script #! syntax:If
// the first line begins with a '#', treat the whole
// line as a comment.
if (source.length() > 0 && source.charAt(0) == '#') {
for (int i = 1; i != source.length(); ++i) {
int c = source.charAt(i);
if (c == '\n' || c == '\r') {
source = source.substring(i);
break;
}
}
}
script = loadScriptFromSource(cx, source, path, 1, securityDomain);
}
if (script != null) {
evaluateScript(script, cx, scope);
}
}*/

	/*private Script loadScriptFromSource(
		Context cx, String scriptSource,
		String path, int lineno,
		Object securityDomain
	) {
		try {
			return cx.compileString(scriptSource, path, lineno,securityDomain);
		} catch (EvaluatorException ee) {
			// Already printed message.
			exitCode = EXITCODE_RUNTIME_ERROR;
		} catch (RhinoException rex) {
			//ToolErrorReporter.reportException(
			//cx.getErrorReporter(), rex);
			exitCode = EXITCODE_RUNTIME_ERROR;
		} catch (VirtualMachineError ex) {
			// Treat StackOverflow and OutOfMemory as runtime errors
			//ex.printStackTrace();
			//String msg = ToolErrorReporter.getMessage(
			//"msg.uncaughtJSException", ex.toString());
			exitCode = EXITCODE_RUNTIME_ERROR;
			//Context.reportError(msg);
		} catch(Throwable th) {
			th.printStackTrace();
		}
		return null;
	}*/

/*private static Script loadCompiledScript(Context cx, String path,
 Object securityDomain)
{
byte[] data = (byte[])readFileOrUrl(path, false);
if (data == null) {
exitCode = EXITCODE_FILE_NOT_FOUND;
return null;
}
// : For now extract class name of compiled Script from path
// instead of parsing class bytes
int nameStart = path.lastIndexOf('/');
if (nameStart < 0) {
nameStart = 0;
} else {
++nameStart;
}
int nameEnd = path.lastIndexOf('.');
if (nameEnd < nameStart) {
// '.' does not exist in path (nameEnd < 0)
// or it comes before nameStart
nameEnd = path.length();
}
String name = path.substring(nameStart, nameEnd);
try {
GeneratedClassLoader loader = SecurityController.createLoader(cx.getApplicationClassLoader(), securityDomain);
Class<?> clazz = loader.defineClass(name, data);
loader.linkClass(clazz);
if (!Script.class.isAssignableFrom(clazz)) {
throw Context.reportRuntimeError("msg.must.implement.Script");
}
return (Script) clazz.newInstance();
 } catch (RhinoException rex) {
ToolErrorReporter.reportException(
cx.getErrorReporter(), rex);
exitCode = EXITCODE_RUNTIME_ERROR;
} catch (IllegalAccessException iaex) {
exitCode = EXITCODE_RUNTIME_ERROR;
Context.reportError(iaex.toString());
} catch (InstantiationException inex) {
exitCode = EXITCODE_RUNTIME_ERROR;
Context.reportError(inex.toString());
}
return null;
}*/

/*	private Object evaluateScript(
		Script script, Context cx,
		Scriptable scope
	) {
		try {
			return script.exec(cx, scope);
		} catch (RhinoException rex) {
			//ToolErrorReporter.reportException(
			//cx.getErrorReporter(), rex);
			//exitCode = EXITCODE_RUNTIME_ERROR;
		} catch (VirtualMachineError ex) {
			// Treat StackOverflow and OutOfMemory as runtime errors
			//ex.printStackTrace();
			//String msg = ToolErrorReporter.getMessage(
			//"msg.uncaughtJSException", ex.toString());
			//exitCode = EXITCODE_RUNTIME_ERROR;
			//Context.reportError(msg);
		}
		//return Context.getUndefinedValue();
		return null; // tfr
	}
*/
/*public static InputStream getIn() {
return getGlobal().getIn();
}

public static void setIn(InputStream in) {
getGlobal().setIn(in);
}

public static PrintStream getOut() {
return getGlobal().getOut();
}

public static void setOut(PrintStream out) {
getGlobal().setOut(out);
}

public static PrintStream getErr() {
return getGlobal().getErr();
}

public static void setErr(PrintStream err) {
getGlobal().setErr(err);
}*/

/**
 * Read file or url specified by <tt>path</tt>.
 * @return file or url content as <tt>byte[]</tt> or as <tt>String</tt> if
 * <tt>convertToString</tt> is true.
 */
	//private static Object readFileOrUrl(String path, boolean convertToString)
	//{
	//try {
	//return SourceReader.readFileOrUrl(path, convertToString, 
	//shellContextFactory.getCharacterEncoding());
	//} catch (IOException ex) {
	//Context.reportError(ToolErrorReporter.getMessage(
	//"msg.couldnt.read.source", path, ex.getMessage()));
	//return null;
	//}
	//}

