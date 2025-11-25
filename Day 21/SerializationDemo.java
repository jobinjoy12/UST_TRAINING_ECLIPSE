
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        Book book = new Book("Harry Potter", "jobin", 30000, 09281);
        System.out.println(book);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"))){
           System.out.println("Successful Serialization of Book Object");
           oos.write(book);
        }catch(IOException e){e.printStackTrace();}
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"))){
            ois.read();
            System.out.println("Successful Deserialization of Book Object");
            System.out.println(ois);
        }catch(IOException e){e.printStackTrace();}
        
    }

    
}
