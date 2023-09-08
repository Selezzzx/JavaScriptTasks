package su.selezzz.jstasks;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import su.selezzz.jstasks.JS.Sys;
import su.selezzz.jstasks.JS.SystemJS;
import su.selezzz.jstasks.JS.Web;
import su.selezzz.jstasks.JS.WebJS;
import su.selezzz.jstasks.Tools.ConsoleColors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static byte anime;
    static void animate(int i)
    {
        try
        {
            for(int j = 0 ; j<=100 ; j++)
            {
                switch(anime)
                {
                    case 1:
                        System.out.print("\r[ \\ ] :" + j + "%");
                        break;
                    case 2:
                        System.out.print("\r[ | ] :" + j + "%");
                        break;
                    case 3:
                        System.out.print("\r[ / ] :" + j + "%");
                        break;
                    default:
                        anime = 0;
                        System.out.print("\r[ - ] :" + j + "%");
                }
                anime++;
                Thread.sleep(i);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Context rhinoContext = Context.enter();
        Scriptable scope = rhinoContext.initStandardObjects();

        // Создание экземпляра реализации интерфейса
        SystemJS sysJS = new Sys();
        WebJS webJS = new Web();


        Object sysJSInterface = Context.javaToJS(sysJS, scope);
        scope.put("sys", scope, sysJSInterface);
        Object webJSInterface = Context.javaToJS(webJS, scope);
        scope.put("web", scope, webJSInterface);

        String scriptContent = readScriptFile("Z:\\.projects\\Java\\SelezzzJSTasks\\scripts\\script.js");
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "╰─────────╮  " + ConsoleColors.WHITE_BOLD_BRIGHT + "JSTasks" + " by " + ConsoleColors.PURPLE_BOLD_BRIGHT + "selezzz" + ConsoleColors.WHITE_BOLD_BRIGHT +  " (v1.0)"  + ConsoleColors.CYAN_BOLD_BRIGHT + "  ╭─────────╯" + ConsoleColors.RESET);

        rhinoContext.evaluateString(scope, scriptContent, "RhinoScript", 1, null);

        Context.exit();
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "╭─────────╯            " + ConsoleColors.WHITE_BOLD_BRIGHT + "END" + ConsoleColors.CYAN_BOLD_BRIGHT + "              ╰─────────╮" + ConsoleColors.RESET);
    }
    private static String readScriptFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}