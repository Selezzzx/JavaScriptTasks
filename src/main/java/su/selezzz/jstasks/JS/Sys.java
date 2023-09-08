package su.selezzz.jstasks.JS;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;

public class Sys implements  SystemJS {
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static final double NANOSECS = 1000000000.0;

    public void print(String text) {
        System.out.print(text);
    }
    public void println(String text) {
        System.out.println(text);
    }
    public void println(int num) {
        System.out.println(num);
    }
    public void print(int num) {
        System.out.print(num);
    }
    public String input() {
        Scanner in = new Scanner(System.in);
        String resp = in.nextLine();
        return resp;
    }
    public String input(String text) {
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        String resp = in.nextLine();
        return resp;
    }
    public void exec(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String genToken(int bytes) {
        byte[] randomBytes = new byte[bytes];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

}
    


