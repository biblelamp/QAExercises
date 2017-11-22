import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        //exceptonMethod1();
        try {
            exceptonMethod2();
        } catch (LearningException e) {
            System.out.println("Catched LearningException");
            e.printStackTrace();
            exceptonMethod1();
        } catch (IOException e) {
            System.out.println("Catched IOException");
        } finally {
            System.out.println("filanny block");
        }
    }

    public static void exceptonMethod1() {
        throw new StringFormatInvanidException("%d", "format invalid");
    }

    public static void exceptonMethod2() throws IOException {
        throw new LearningException();
    }
}
