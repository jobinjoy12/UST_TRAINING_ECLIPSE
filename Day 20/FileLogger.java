
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger
{
    public static void main(String[] args) throws IOException {
        try(FileWriter write = new FileWriter("log.txt");){
        write.append("Application started successfully." );
        write.append("User 'learner123' logged in at 10:30 AM.");
        write.append("Data processed: 50 records.");
        write.append("Application shutting down.");}

    }
}