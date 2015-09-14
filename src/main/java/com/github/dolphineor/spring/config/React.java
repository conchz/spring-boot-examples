package com.github.dolphineor.spring.config;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created on 2015-09-14.
 *
 * @author dolphineor
 */
public class React {

    private final ThreadLocal<NashornScriptEngine> scriptEngineHolder =
            ThreadLocal.withInitial(() -> {
                NashornScriptEngine nashornScriptEngine =
                        (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");

                try {
                    nashornScriptEngine.eval(read("static/nashorn-polyfill.js"));
                    nashornScriptEngine.eval(read("static/lib/react.min.js"));
                    nashornScriptEngine.eval(read("static/tutorial.js"));
                } catch (ScriptException e) {
                    e.printStackTrace();
                }

                return nashornScriptEngine;
            });


    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
