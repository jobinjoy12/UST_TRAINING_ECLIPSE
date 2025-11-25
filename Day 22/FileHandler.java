import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
	public String readFirstLine(String filePath) {
		try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line = br.readLine();
            return line;
        } catch(IOException e){return null;}
	}
}