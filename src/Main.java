import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CrptApi crptApi = new CrptApi(TimeUnit.SECONDS, 50);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try {
                    crptApi.request();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
        }
    }
}
