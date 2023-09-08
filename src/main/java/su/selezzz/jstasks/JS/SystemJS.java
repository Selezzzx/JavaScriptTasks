package su.selezzz.jstasks.JS;

public interface SystemJS {
    void print(String text);
    void println(String text);
    void print(int num);
    void println(int num);
    void exec(String command);
    String input();
    String input(String text);
    String genToken(int bytes);
}
