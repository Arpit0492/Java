package udemyJAVA8Features;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Arpit on 28-06-2017.
 */
public class JavaScriptFromJava {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        String script = "var welcome = 'Hello';" +
                "var name = ' Arpit';" +
                "welcome + name;";
        Object result;
        try {
            result = engine.eval(script);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
