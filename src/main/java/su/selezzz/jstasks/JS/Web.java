package su.selezzz.jstasks.JS;

import su.selezzz.jstasks.Tools.HttpRequest;

import java.io.IOException;

public class Web implements WebJS {
    public void logToTG(String userID, String token, String message) {
        try {
            HttpRequest.send("https://api.telegram.org/bot" + token +"/sendMessage?chat_id="+ userID +"&text=" + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
