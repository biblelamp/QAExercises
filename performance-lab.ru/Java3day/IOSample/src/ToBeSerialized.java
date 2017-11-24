import java.io.*;

public class ToBeSerialized implements Serializable {
    int field1;
    double field2;
    String field3;
    transient int filed4;

    public ToBeSerialized(){
        field1 = 100;
        field2 = 123d;
        field3 = "Asdzxc";
        filed4 = 150;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serialize();
        deserialize();
    }

    public static void serialize() throws IOException {
        FileOutputStream os = new FileOutputStream("ToBeSerialized.bin");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        ToBeSerialized ts = new ToBeSerialized();
        oos.writeObject(ts);
        oos.flush();
        oos.close();
        os.close();
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream("ToBeSerialized.bin");
        ObjectInputStream ois = new ObjectInputStream(is);
        ToBeSerialized ts = (ToBeSerialized)ois.readObject();
        System.out.printf("%d\n%f\n%s\n%d", ts.field1, ts.field2, ts.field3, ts.filed4);
    }
}
