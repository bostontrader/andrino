import junit.framework.TestCase;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class RhinoTest extends TestCase {

    public void testRhino() {
        Context cx = org.mozilla.javascript.Context.enter();
        Scriptable scope = cx.initStandardObjects();
        String expression = "5+10";
        Object rhinoResult = cx.evaluateString(scope, expression, "<cmd>", 1, null);
        String result = rhinoResult.toString();
        assertEquals("15", result);
    }
}