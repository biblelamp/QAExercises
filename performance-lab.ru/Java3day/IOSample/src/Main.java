import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void unbufferedReader(){
        long startTime = System.currentTimeMillis();

        try (InputStream is = new FileInputStream("big.txt")) {
            int size = is.available();

            for (int i=0; i < size; i++) {
                is.read();
            }

        } catch (IOException ignored) {}

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void bufferedReadeer() {
        long startTime = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();

        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream("big.txt");
            bis = new BufferedInputStream(is);
            byte[] buf = new  byte[1024];
            for (int i = 0; bis.available() > 0; i++) {
                bis.read(buf, 0, 1024);
                result.append(new String(buf));
            }

        } catch (IOException ignored) {}
        finally {
            try {
                bis.close();
                is.close();
            } catch (IOException ignored) {}
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) {
        //unbufferedReader();
        bufferedReadeer();
    }
}
