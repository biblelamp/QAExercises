public class Main {
    public static void main(String[] args) {
        BoxPrinterOld value1 = new BoxPrinterOld(10);
        System.out.println(value1);
        Integer intValue1 = (Integer)value1.getVal();
        BoxPrinterOld value2 = new BoxPrinterOld("Hello world!");
        //тут ошибка, но скопилируется
        //Integer intVal2 = (Integer)value2.getVal();

        BoxPrinterNew<Integer> value3 = new BoxPrinterNew<>(10);
        System.out.println(value3);
        Integer intVal3 = value3.getVal();
        BoxPrinterNew<String> value4 = new BoxPrinterNew<>("Hello world!");
        System.out.println(value4);
        //тут ошибка, но скомпилировать уже не даст.
        //Integer intVal4 = (Integer)value4.getVal();
    }
}
