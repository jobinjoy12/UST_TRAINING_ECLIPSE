
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTask {
    public static void main(String[] args) throws IOException {
    FileReader read = new FileReader("myFile.txt");
     try {
            char i = '\0';
        while(i != -1)
        {
            i = (char) read.read();
           System.out.println(i);
        }} finally { read.close();}
    }   
}
