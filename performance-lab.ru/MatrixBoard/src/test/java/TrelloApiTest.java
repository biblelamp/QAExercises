import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс для тестирования API на примере Trello.
 * Формирует HTTP GET запрос и отправляет его на сервер.
 */
public class TrelloApiTest {
    public static final String API_KEY = "714e9a588188a0c9f8c4b403d349edfb"; //Наш API ключ
    public static final String API_SECRET = "5b46fb6cabf40c355d2275ef624f9ecbadd66fc6df7b9ad2ad536fec21ded008"; //наш API токен

    @Test
    public void listCards() throws IOException {
        //формируем URL, на который наш запрос будет отправлен.
        URL url = new URL("https://api.trello.com/1/boards/lrXqYBnc/?cards=all&key=" + API_KEY + "&token=" + API_SECRET);
        //после чего отекрываем соединение. Необходимо сконвертировать (привести) его в  HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //Устанавливаем метод запроса
        connection.setRequestMethod("GET");
//        connection.setRequestMethod("POST");
        //говорим, что вывод нам необходим
        connection.setDoOutput(true);

        //OutputStream st = connection.getOutputStream();

        //устанавливаем заголовок запроса
        connection.setRequestProperty("User-Agent", "Java client v1.0");

        //получаем код ответа
        int code = connection.getResponseCode();
        Assert.assertEquals(200, code);

        //получаем поток входных данных (ответ сервера), преобразуем его к BufferedReader для удобства
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line; //куда будем читать данные.
        StringBuilder sb = new StringBuilder(); //для формирования конечного результата
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n"); //добавляем прочитанную строку к результату и добавляем перенос строки (для удобства, если строк в ответе было несколько)
        }

        System.out.println(sb.toString());
    }
}
