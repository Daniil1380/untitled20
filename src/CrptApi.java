import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class CrptApi {

    private final long delta;
    private long requestsLockedTo;

    public CrptApi(TimeUnit timeUnit, int requestLimit) {
        long millis = timeUnit.toMillis(1);
        delta = millis / requestLimit;
        requestsLockedTo = 0;
    }

    public synchronized void request() throws InterruptedException {
        long now = System.currentTimeMillis();

        if (now < requestsLockedTo) {
            Thread.sleep(requestsLockedTo - now);
        }
        3





        now = System.currentTimeMillis();

        //            HttpClient client = HttpClient.newHttpClient();
        //            HttpRequest request = HttpRequest.newBuilder()
        //                    .uri(URI.create("http://javarush.com"))
        //                    .POST(HttpRequest.BodyPublishers.ofString("1e2fwwcs"))
        //    .build();
        //            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("Запрос отправлен");
        System.out.println(LocalDateTime.now());
        requestsLockedTo = now + delta;
    }
}
